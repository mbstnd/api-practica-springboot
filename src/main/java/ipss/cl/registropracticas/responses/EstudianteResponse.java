package ipss.cl.registropracticas.responses;

import ipss.cl.registropracticas.models.Estudiante;
import lombok.Data;

@Data
public class EstudianteResponse {

  private int status;
  private String message;
  private Estudiante estudiante;

}
