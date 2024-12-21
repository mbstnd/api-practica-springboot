package ipss.cl.registropracticas.responses;

import java.util.List;

import ipss.cl.registropracticas.models.Practica;
import lombok.Data;

@Data
public class PracticaResponse {
  private int status;
  private String message;
  private List<Practica> practica;

}
