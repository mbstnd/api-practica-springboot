package ipss.cl.registropracticas.models;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "estudiantes")
public class Estudiante {

  @Id
  private String id; // Identificador único del estudiante

  @Indexed(unique = true)
  private String name; // Nombre del estudiante

  private String career;
  private String email;
  private String phone;
  private String address;

  // Relación con las prácticas
  private List<Practica> practica;

}
