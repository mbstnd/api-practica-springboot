package ipss.cl.registropracticas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ipss.cl.registropracticas.models.Practica;
import ipss.cl.registropracticas.responses.PracticaResponse;
import ipss.cl.registropracticas.services.EstudianteService;
import ipss.cl.registropracticas.services.PracticaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("api/profesores")
public class ProfesorController {

  @Autowired
  private PracticaService practicaService;

  @Autowired
  EstudianteService estudianteService;

  // Agregar práctica (para profesor)

  @PostMapping(value = "/create", produces = "application/json")
  public ResponseEntity<PracticaResponse> create(@RequestBody Practica practica) {
    // Guardar la práctica como profesor
    Practica practicaGuardada = practicaService.addPracticaAsTeacher(practica);

    // Asociar la práctica a los estudiantes si hay IDs disponibles
    List<String> studentIds = practica.getStudentIds();
    if (studentIds != null && !studentIds.isEmpty()) {
      studentIds.forEach(
          estudianteId -> estudianteService.asignarPracticaAEstudiante(estudianteId, practicaGuardada.getId()));
    }

    // Crear la respuesta
    PracticaResponse practicaResponse = PracticaResponse.builder()
        .status(200)
        .message("Práctica creada y asociada correctamente a los estudiantes.")
        .practica(practicaGuardada)
        .build();

    // Retornar la respuesta
    return ResponseEntity.ok(practicaResponse);
  }

  // Obtener todas las prácticas (para profesor)

  @GetMapping(value = "getAll", produces = "application/json")
  public ResponseEntity<List<Practica>> getAllPracticas() {
    List<Practica> practicas = practicaService.getAllPracticas();
    return ResponseEntity.ok(practicas);
  }

  // Actualizar práctica (para profesor)

  @PutMapping(value = "update/{id}", produces = "application/json")
  public ResponseEntity<PracticaResponse> updatePractica(@PathVariable("id") String id,
      @RequestBody Practica practica) {
    Practica practicaActualizada = practicaService.updatePractica(id, practica);

    // Crear la respuesta
    PracticaResponse practicaResponse = PracticaResponse.builder()
        .status(200)
        .message("Práctica actualizada correctamente.")
        .practica(practicaActualizada)
        .build();

    // Retornar la respuesta
    return ResponseEntity.ok(practicaResponse);

  }

}
