package ipss.cl.registropracticas.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ipss.cl.registropracticas.models.Estudiante;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {

  List<Estudiante> findByNombreCompleto(String nombreCompleto);

  List<Estudiante> findByCarrera(String carrera);

  List<Estudiante> findByCorreo(String correo);

  List<Estudiante> findByTelefono(String telefono);

  List<Estudiante> findByDireccion(String direccion);

}
