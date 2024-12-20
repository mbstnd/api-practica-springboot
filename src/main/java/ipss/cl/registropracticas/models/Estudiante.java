package ipss.cl.registropracticas.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
@Document(collection = "estudiantes")
public class Estudiante {

  @Id
  private String id;

  private String nombreCompleto;
  private String carrera;
  @Indexed(unique = true)
  private String correo;
  private String telefono;
  private String direccion;

  @JsonBackReference
  private Practica practica;

}
