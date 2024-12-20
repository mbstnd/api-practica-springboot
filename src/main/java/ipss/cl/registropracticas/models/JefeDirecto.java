package ipss.cl.registropracticas.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "jefes")
public class JefeDirecto {

  private String nombre;
  private String contacto;

}
