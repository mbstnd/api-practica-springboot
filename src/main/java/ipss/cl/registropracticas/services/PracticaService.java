package ipss.cl.registropracticas.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipss.cl.registropracticas.models.EstadoPractica;
import ipss.cl.registropracticas.models.Estudiante;
import ipss.cl.registropracticas.models.Practica;
import ipss.cl.registropracticas.repositories.EstudianteRepository;
import ipss.cl.registropracticas.repositories.PracticaRepository;

@Service
public class PracticaService {

  @Autowired
  private PracticaRepository practicaRepository;

  @Autowired
  private EstudianteRepository estudianteRepository;

  // Estudiante: Crear práctica

  public Practica addPracticaAsStudent(String studentId, Practica practica) {
    // Verificar si el estudiante existe en la base de datos
    Estudiante estudiante = estudianteRepository.findById(studentId).orElse(null);

    if (estudiante == null) {
      // Si no se encuentra el estudiante, lanzar una excepción
      throw new IllegalArgumentException("El estudiante con ID " + studentId + " no existe.");
    }

    // Agregar el ID de la práctica a la lista de prácticas del estudiante
    estudiante.getPracticaIds().add(practica.getId());

    // Establecer el estado de la práctica
    practica.setEstado(EstadoPractica.PENDIENTE);

    // Guardar la práctica en el repositorio
    Practica savedPractica = practicaRepository.save(practica);

    // Guardar el estudiante actualizado
    estudianteRepository.save(estudiante);

    return savedPractica;
  }

  // Profesor: Agregar práctica en nombre de un estudiante

  public Practica addPracticaAsTeacher(Practica practica) {
    practica.setEstado(EstadoPractica.PENDIENTE);
    return practicaRepository.save(practica);

  }

  // Obtener prácticas por el ID del estudiante

  public List<Practica> getPacticasByStudent(String studentId) {
    return practicaRepository.findByStudentIds(studentId);

  }

  // Profesor: Leer todas las prácticas

  public List<Practica> getAllPracticas() {
    return practicaRepository.findAll();
  }

  // Profesor: Actualizar práctica
  public Practica updatePractica(String practicaId, Practica updatedPractica) {
    Practica existingPractica = practicaRepository.findById(practicaId)
        .orElseThrow(() -> new RuntimeException("Práctica no encontrada"));

    // Aquí, se puede permitir actualizar el estado de la práctica, si es necesario
    if (updatedPractica.getEstado() != null) {
      existingPractica.setEstado(updatedPractica.getEstado()); // Actualizar el estado si se proporciona
    }

    // Copiar otras propiedades excepto el ID y studentId
    BeanUtils.copyProperties(updatedPractica, existingPractica, "id", "studentId");

    return practicaRepository.save(existingPractica);
  }

  // Profesor: Eliminar práctica

  public void deletePractica(String practicaId) {
    practicaRepository.deleteById(practicaId);
  }

}
