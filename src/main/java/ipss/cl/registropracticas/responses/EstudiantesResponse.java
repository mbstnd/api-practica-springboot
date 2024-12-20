package ipss.cl.registropracticas.responses;

import java.util.List;

import ipss.cl.registropracticas.models.Estudiante;
import lombok.Data;

@Data
public class EstudiantesResponse {

  private int status;
  private String message;
  private List<Estudiante> estudiantes;

}
