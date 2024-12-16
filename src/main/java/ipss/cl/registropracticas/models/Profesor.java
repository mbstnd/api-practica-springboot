package ipss.cl.registropracticas.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "profesores")
public class Profesor {

  @Id
  private String id; // Identificador único del profesor

  private String nombre;
  private String email;
  private String telefono;

  // Relación con las prácticas supervisadas
  private List<String> practiceIds; // Lista de IDs de prácticas supervisadas

}
