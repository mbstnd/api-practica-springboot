package ipss.cl.registropracticas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ipss.cl.registropracticas.models.Practica;

public interface PracticaRepository extends MongoRepository<Practica, String> {

}
