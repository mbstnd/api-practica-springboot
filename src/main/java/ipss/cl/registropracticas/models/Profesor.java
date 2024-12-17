package ipss.cl.registropracticas.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
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

  // Clase interna que actúa como una vista simplificada del profesor
  private ProfesorSupervisor profesorSupervisor;

}
