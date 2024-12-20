package ipss.cl.registropracticas.models;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class EstudianteResumen {

  @Id
  private String id;
  private String nombreCompleto;
  private String carrera;

}
