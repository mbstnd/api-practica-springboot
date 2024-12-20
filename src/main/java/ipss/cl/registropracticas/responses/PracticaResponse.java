package ipss.cl.registropracticas.responses;

import ipss.cl.registropracticas.models.Practica;
import lombok.Data;

@Data
public class PracticaResponse {
  private int status; // Código de estado (por ejemplo, 200, 400, 500)
  private String message;
  private Practica practica;

}
