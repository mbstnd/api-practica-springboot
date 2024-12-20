package ipss.cl.registropracticas.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import ipss.cl.registropracticas.models.Estudiante;
import ipss.cl.registropracticas.models.Practica;

public interface PracticaRepository extends MongoRepository<Practica, String> {

  List<Practica> findByEstudiantes(List<Estudiante> estudiantes);

  List<Practica> findByFechaInicio(String fechaInicio, String fechaTermino);

  List<Practica> findByEmpresa(String empresaNombre);

}
