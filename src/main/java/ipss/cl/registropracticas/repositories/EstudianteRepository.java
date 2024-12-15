package ipss.cl.registropracticas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ipss.cl.registropracticas.models.Estudiante;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {

}
