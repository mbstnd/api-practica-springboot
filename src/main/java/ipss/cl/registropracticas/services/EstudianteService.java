package ipss.cl.registropracticas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipss.cl.registropracticas.models.Estudiante;

import ipss.cl.registropracticas.repositories.EstudianteRepository;

@Service
public class EstudianteService {

  @Autowired
  private EstudianteRepository estudianteRepository;

  // Crear estudiante
  public Estudiante create(Estudiante estudiante) {
    return estudianteRepository.save(estudiante);
  }

  // Listar todos los estudiantes
  public List<Estudiante> getAll() {
    return estudianteRepository.findAll();
  }

  // Buscar estudiante por ID
  public Estudiante getById(String id) {
    return estudianteRepository.findById(id).orElse(null);
  }

  // Eliminar estudiante por ID
  public void delete(String id) {
    estudianteRepository.deleteById(id);
  }

}
