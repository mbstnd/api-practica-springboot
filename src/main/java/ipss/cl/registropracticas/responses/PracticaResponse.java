package ipss.cl.registropracticas.responses;

import java.util.List;

import ipss.cl.registropracticas.models.Practica;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PracticaResponse {
  private int status;
  private String message;
  private Practica practica;
  private List<Practica> practicas;

}
