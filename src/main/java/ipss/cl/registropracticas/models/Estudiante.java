package ipss.cl.registropracticas.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import ipss.cl.registropracticas.repositories.PracticaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
@Document(collection = "estudiantes")
public class Estudiante {

  @Id
  private String id; // Identificador único del estudiante

  @Indexed(unique = true)
  private String nombre;
  private String carrera;
  private String email;
  private String telefono;
  private String direccion;

  // Relación con la práctica (un solo id de práctica)
  private List<String> practicaIds = new ArrayList<>(); // ID de la práctica asociada al estudiante

  // Método para obtener las prácticas completas usando los IDs almacenados
  public List<Practica> getPractices(PracticaRepository practicaRepository) {
    List<Practica> practices = new ArrayList<>();
    for (String practicaId : practicaIds) {
      // Buscar cada práctica usando su ID
      Optional<Practica> practicaOpt = practicaRepository.findById(practicaId);
      practicaOpt.ifPresent(practices::add); // Si existe, añadirla a la lista
    }
    return practices;
  }

}
