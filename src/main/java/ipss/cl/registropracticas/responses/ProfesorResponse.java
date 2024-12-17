package ipss.cl.registropracticas.responses;

import java.util.List;

import lombok.Data;

@Data
public class ProfesorResponse {

  private String id;
  private String nombre;
  private String email;
  private String telefono;
  private List<String> practiceIds;

}
