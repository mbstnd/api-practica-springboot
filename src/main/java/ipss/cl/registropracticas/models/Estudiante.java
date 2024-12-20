package ipss.cl.registropracticas.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
@Document(collection = "estudiantes")
public class Estudiante {

  @Id
  private String id;

  @Indexed(unique = true)
  private String nombreCompleto;
  private String carrera;
  private String correo;
  private String telefono;
  private String direccion;

  @DBRef
  private Practica practica;

}
