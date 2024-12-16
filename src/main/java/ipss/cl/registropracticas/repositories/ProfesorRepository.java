package ipss.cl.registropracticas.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ipss.cl.registropracticas.models.Profesor;

public interface ProfesorRepository extends MongoRepository<Profesor, String> {

  List<Profesor> findByNombre(String nombre);

  List<Profesor> findByEmail(String email);

  List<Profesor> findByPracticeIds(List<String> practiceIds);

}
