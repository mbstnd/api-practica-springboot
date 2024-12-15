package ipss.cl.registropracticas.models;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "practicas")
public class Practica {

  @Id
  private String id; // Identificador único de la práctica

  private String studentId;
  private String profesorId;
  private String description;
  private LocalDate startDate; // Fecha de inicio de la práctica
  private LocalDate endDate; // Fecha de término de la práctica
  private String companyName; // Nombre de la empresa
  private String companyAddress; // Dirección de la empresa
  private String companyPhone; // Teléfono de la empresa
  private String directSupervisor; // Nombre del jefe directo en la empresa
  private String supervisorContact; // Contacto del jefe directo

}
