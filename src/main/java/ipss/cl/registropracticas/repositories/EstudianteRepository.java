package ipss.cl.registropracticas.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ipss.cl.registropracticas.models.Estudiante;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {

  List<Estudiante> findByCarrera(String carrera);

  List<Estudiante> findByNombreCompleto(String nombreCompleto);

}
