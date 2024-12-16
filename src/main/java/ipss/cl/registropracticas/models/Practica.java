package ipss.cl.registropracticas.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
@Document(collection = "practicas")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Practica {

  @Id
  private String id; // Identificador único de la práctica

  @Indexed
  private String profesorId;

  private String descripcion;
  private LocalDate fechaInicio;
  private LocalDate fechaTermino;

  private Empresa empresa;
  private JefeDirecto jefeDirecto;
  private ProfesorSupervisor profesorSupervisor;

  private EstadoPractica estado;

  private List<String> studentIds;

}
