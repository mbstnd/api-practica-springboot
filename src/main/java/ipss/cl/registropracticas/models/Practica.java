package ipss.cl.registropracticas.models;

import java.util.List;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
@Document(collection = "practicas")
@CompoundIndex(name = "unique_practica_index", def = "{'fechaInicio': 1, 'fechaTermino': 1, 'empresa.id': 1}", unique = true)
public class Practica {

  @Id
  private String id;
  private String fechaInicio;
  private String fechaTermino;
  private String descripcion;

  private Empresa empresa;
  private JefeDirecto jefeDirecto;
  private Profesor profesorSupervisor;

  @JsonManagedReference
  private List<Estudiante> estudiantes;

}
