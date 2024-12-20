package ipss.cl.registropracticas.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
@Document(collection = "profesores")
public class Profesor {

  @Id
  private String id;
  private String nombreCompleto;
  private String departamento;
  private String correo;
  private String telefono;
  private List<EstudianteResumen> estudiantesSupervisados = new ArrayList<>();

}
