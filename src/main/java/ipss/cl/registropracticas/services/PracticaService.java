package ipss.cl.registropracticas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipss.cl.registropracticas.models.Estudiante;
import ipss.cl.registropracticas.models.Practica;
import ipss.cl.registropracticas.repositories.EstudianteRepository;
import ipss.cl.registropracticas.repositories.PracticaRepository;
import ipss.cl.registropracticas.repositories.ProfesorRepository;
import jakarta.transaction.Transactional;

@Service
public class PracticaService {

  @Autowired
  private PracticaRepository practicaRepository;

  @Autowired
  private EstudianteRepository estudianteRepository;

  @Autowired
  private ProfesorRepository profesorRepository;

  // Crear práctica con validación de relaciones
  @Transactional
  public Practica createPractica(Practica practica) {
    // Verificar si el profesor supervisor tiene id, si no, guardarlo primero
    if (practica.getProfesorSupervisor() != null && practica.getProfesorSupervisor().getId() == null) {
      practica.setProfesorSupervisor(profesorRepository.save(practica.getProfesorSupervisor()));
    }

    // Verificar si tiene estudiantes asignados y guardarlos si es necesario
    if (practica.getEstudiantes() != null) {
      practica.getEstudiantes().forEach(estudiante -> {
        if (estudiante.getId() == null) {
          // Guardar estudiantes sin ID
          estudianteRepository.save(estudiante);
        }
      });
    }

    // Finalmente, guardar la práctica con todas las relaciones resueltas
    return practicaRepository.save(practica);
  }

  // Obtener la práctica de un estudiante
  public Practica getPracticaByEstudiante(String estudianteId) {
    Estudiante estudiante = estudianteRepository.findById(estudianteId)
        .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

    // Si un estudiante no tiene asignada una práctica, lanzamos un error
    Practica practica = estudiante.getPractica();
    if (practica == null) {
      throw new RuntimeException("El estudiante no tiene asignada una práctica.");
    }
    return practica;
  }

  // Obtener todas las prácticas
  public List<Practica> getAllPracticas() {
    return practicaRepository.findAll();
  }

  // Obtener una práctica por su ID
  public Practica getById(String practicaId) {
    return practicaRepository.findById(practicaId)
        .orElseThrow(() -> new RuntimeException("Práctica no encontrada"));
  }

  // Obtener los estudiantes de una práctica
  public List<Estudiante> getEstudiantesByPractica(String practicaId) {
    Practica practica = practicaRepository.findById(practicaId)
        .orElseThrow(() -> new RuntimeException("Práctica no encontrada"));

    // Retornar los estudiantes asignados a la práctica
    return practica.getEstudiantes();
  }

  // Asignar estudiantes a una práctica
  public Practica asignarEstudiantesAPractica(String practicaId, List<String> estudianteIds) {
    Practica practica = practicaRepository.findById(practicaId)
        .orElseThrow(() -> new RuntimeException("Práctica no encontrada"));

    // Buscar los estudiantes por sus ObjectId
    List<Estudiante> estudiantes = estudianteRepository.findAllById(estudianteIds);

    // Asignar la lista de estudiantes a la práctica
    practica.setEstudiantes(estudiantes);

    // Guardar la práctica con los estudiantes asignados
    return practicaRepository.save(practica);
  }

  public Estudiante asignarPracticaAEstudiante(String estudianteId, String practicaId) {
    Estudiante estudiante = estudianteRepository.findById(estudianteId)
        .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

    Practica practica = practicaRepository.findById(practicaId)
        .orElseThrow(() -> new RuntimeException("Práctica no encontrada"));

    // Asignar la práctica al estudiante
    estudiante.setPractica(practica);

    // Guardar el estudiante con la práctica asignada
    estudiante = estudianteRepository.save(estudiante);

    // Asegurarse de que los estudiantes también estén relacionados con la práctica
    if (practica.getEstudiantes() == null) {
      practica.setEstudiantes(new ArrayList<>());
    }
    practica.getEstudiantes().add(estudiante);

    // Guardar la práctica con los estudiantes asignados
    practicaRepository.save(practica);

    return estudiante;
  }

  public Practica updatePractica(String id, Practica practicaRequest) {
    // Implementa la lógica para actualizar una práctica
    return practicaRequest; // Retorna la práctica actualizada
  }

  public boolean deletePractica(String id) {

    Optional<Practica> practicaOpt = practicaRepository.findById(id);
    if (practicaOpt.isPresent()) {
      practicaRepository.delete(practicaOpt.get());
      return true;
    }
    return false;
  }

}
