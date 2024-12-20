package ipss.cl.registropracticas.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import ipss.cl.registropracticas.models.Profesor;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfesorResponse {
  private int status; // Código de estado (por ejemplo, 200, 400, 500)
  private String message;
  private Profesor profesor;
}