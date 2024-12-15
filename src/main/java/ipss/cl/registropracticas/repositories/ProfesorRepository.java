package ipss.cl.registropracticas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ipss.cl.registropracticas.models.Profesor;

public interface ProfesorRepository extends MongoRepository<Profesor, String> {

}
