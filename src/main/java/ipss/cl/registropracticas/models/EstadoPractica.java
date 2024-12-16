package ipss.cl.registropracticas.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EstadoPractica {

  PENDIENTE("Pendiente"),
  EN_CURSO("En curso"),
  FINALIZADA("Finalizada");

  private final String nombre;

  EstadoPractica(String nombre) {
    this.nombre = nombre;
  }

  // Método para obtener el nombre legible
  @JsonValue
  public String getNombre() {
    return nombre;
  }

  // Método estático para convertir el valor del JSON al valor del Enum
  @JsonCreator
  public static EstadoPractica fromString(String value) {
    for (EstadoPractica estado : EstadoPractica.values()) {
      if (estado.getNombre().equalsIgnoreCase(value)) {
        return estado;
      }
    }
    throw new IllegalArgumentException("Valor desconocido: " + value);
  }
}
