package ipss.cl.registropracticas.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ipss.cl.registropracticas.models.Estudiante;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {

  // Método para encontrar estudiantes por nombre
  List<Estudiante> findByNombre(String nombre);

  // Método para encontrar estudiantes por carrera
  List<Estudiante> findByCarrera(String carrera);

  // Método para buscar estudiantes por nombre y carrera
  List<Estudiante> findByNombreAndCarrera(String nombre, String carrera);

}
