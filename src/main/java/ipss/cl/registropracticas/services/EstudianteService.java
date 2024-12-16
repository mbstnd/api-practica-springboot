package ipss.cl.registropracticas.services;

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
    // Obtener todos los estudiantes
    List<Estudiante> estudiantes = estudianteRepository.findAll();
    return estudiantes;
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

}
