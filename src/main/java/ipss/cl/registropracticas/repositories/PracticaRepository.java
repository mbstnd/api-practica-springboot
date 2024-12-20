package ipss.cl.registropracticas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ipss.cl.registropracticas.models.Practica;
import java.util.List;

public interface PracticaRepository extends MongoRepository<Practica, String> {

  List<Practica> findByEstudiantes(String estudiantes);

  List<Practica> findByFechaInicio(String fechaInicio, String fechaTermino);

  List<Practica> findByEmpresa(String empresaNombre);

}
