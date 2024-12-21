package ipss.cl.registropracticas.responses;

import ipss.cl.registropracticas.models.Profesor;
import lombok.Data;

@Data
public class ProfesorResponse {
  private int status;
  private String message;
  private Profesor profesor;
}