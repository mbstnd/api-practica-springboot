package ipss.cl.registropracticas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipss.cl.registropracticas.models.Estudiante;
import ipss.cl.registropracticas.models.Practica;
import ipss.cl.registropracticas.repositories.EstudianteRepository;
import ipss.cl.registropracticas.repositories.PracticaRepository;

@Service
public class EstudianteService {

  @Autowired
  private EstudianteRepository estudianteRepository;

  @Autowired
  private PracticaRepository practicaRepository;

  public List<Estudiante> getAllEstudiantes() {
    return estudianteRepository.findAll();
  }

  public Estudiante createEstudiante(Estudiante estudiante) {
    if (estudiante.getPractica() != null && estudiante.getPractica().getId() == null) {
      // Si la práctica no tiene id, guardarla primero
      Practica practica = practicaRepository.save(estudiante.getPractica());
      estudiante.setPractica(practica);
    }
    return estudianteRepository.save(estudiante);
  }

  public Estudiante obtenerEstudiante(String id) {
    return estudianteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
  }

  public Estudiante actualizarEstudiante(String id, Estudiante estudianteActualizado) {
    Estudiante estudianteExistente = obtenerEstudiante(id);
    estudianteExistente.setNombreCompleto(estudianteActualizado.getNombreCompleto());
    estudianteExistente.setCarrera(estudianteActualizado.getCarrera());
    estudianteExistente.setCorreo(estudianteActualizado.getCorreo());
    estudianteExistente.setTelefono(estudianteActualizado.getTelefono());
    estudianteExistente.setDireccion(estudianteActualizado.getDireccion());
    return estudianteRepository.save(estudianteExistente);
  }

  // Asignar una práctica a un estudiante
  public Estudiante asignarPractica(String estudianteId, String practicaId) {
    Estudiante estudiante = obtenerEstudiante(estudianteId);
    Practica practica = practicaRepository.findById(practicaId)
        .orElseThrow(() -> new RuntimeException("Práctica no encontrada"));

    // Asignar la práctica al estudiante
    estudiante.setPractica(practica);

    // Guardar el estudiante con la práctica asignada
    return estudianteRepository.save(estudiante);
  }

  // Obtener las prácticas de un estudiante
  public Practica obtenerPracticaEstudiante(String estudianteId) {
    Estudiante estudiante = obtenerEstudiante(estudianteId);
    return estudiante.getPractica();
  }

  public void eliminarEstudiante(String id) {
    Estudiante estudiante = obtenerEstudiante(id);
    estudianteRepository.delete(estudiante);
  }

}