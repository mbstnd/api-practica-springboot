package ipss.cl.registropracticas.models;

import lombok.Data;

@Data
public class EstudianteResumen {

  private String nombreCompleto;
  private String carrera;
  private String correo;
  private String telefono;
  private String direccion;

}
