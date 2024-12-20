package ipss.cl.registropracticas.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
@Document(collection = "practicas")
public class Practica {

  @Id
  private String id;

  private LocalDate fechaInicio;
  private LocalDate fechaTermino;
  private String descripcion;
  private String estado;

  private JefeDirecto jefeDirecto;

  private Empresa empresa;

  @DBRef(lazy = false)
  private Profesor profesorSupervisor;

  @DBRef
  private List<Estudiante> estudiantes = new ArrayList<>();

}
