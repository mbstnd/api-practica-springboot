package ipss.cl.registropracticas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipss.cl.registropracticas.models.Estudiante;
import ipss.cl.registropracticas.repositories.EstudianteRepository;
// import ipss.cl.registropracticas.repositories.PracticaRepository;

@Service
public class EstudianteService {

  @Autowired
  private EstudianteRepository estudianteRepository;

  // @Autowired
  // private PracticaRepository practicaRepository;

  // Listar todos los estudiantes
  public List<Estudiante> getAll() {
    return estudianteRepository.findAll();
  }

  // Buscar estudiante por ID
  public Estudiante getById(String id) {
    return estudianteRepository.findById(id).orElse(null);
  }

  // Crear estudiante
  public Estudiante create(Estudiante estudiante) {
    return estudianteRepository.save(estudiante);
  }

  // Eliminar estudiante por ID
  public void delete(String id) {
    estudianteRepository.deleteById(id);
  }

  public void asignarPracticaAEstudiante(String estudianteId, String practicaId) {
    Estudiante estudiante = getById(estudianteId); // Usa el método `getById` para manejar excepciones

    // Inicializar la lista de prácticas si está vacía
    if (estudiante.getPracticaIds() == null) {
      estudiante.setPracticaIds(new ArrayList<>());
    }

    // Verificar si la práctica ya está asignada
    if (estudiante.getPracticaIds().contains(practicaId)) {
      throw new IllegalArgumentException("La práctica con ID " + practicaId + " ya está asignada al estudiante.");
    }

    // Agregar el ID de la práctica a la lista del estudiante
    estudiante.getPracticaIds().add(practicaId);

    // Guardar los cambios en la base de datos
    estudianteRepository.save(estudiante);
  }

}
