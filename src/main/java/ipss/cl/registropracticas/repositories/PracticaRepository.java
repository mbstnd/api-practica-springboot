package ipss.cl.registropracticas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ipss.cl.registropracticas.models.Practica;
import java.util.List;

public interface PracticaRepository extends MongoRepository<Practica, String> {

  List<Practica> findByStudentIds(String studentId); // Buscar todas las prácticas de un estudiante por su ID

}
