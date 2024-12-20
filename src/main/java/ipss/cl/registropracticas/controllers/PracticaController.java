package ipss.cl.registropracticas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ipss.cl.registropracticas.models.Estudiante;
import ipss.cl.registropracticas.models.Practica;
import ipss.cl.registropracticas.responses.EstudiantesResponse;
import ipss.cl.registropracticas.responses.PracticaResponse;
import ipss.cl.registropracticas.services.PracticaService;

@Controller
@RequestMapping("api/practicas")
public class PracticaController {

  @Autowired
  private PracticaService practicaService;

  // Crear una práctica
  @PostMapping(value = "create", produces = "application/json")
  public ResponseEntity<Object> createPractica(@RequestBody Practica practica) {
    Practica nuevaPractica = practicaService.createPractica(practica);
    PracticaResponse response = new PracticaResponse();
    response.setStatus(200);
    response.setMessage("Práctica creada exitosamente");
    response.setPractica(nuevaPractica);
    return ResponseEntity.ok()
        .body(response);
  }

  // Obtener práctica por ID de estudiante
  @GetMapping(value = "getPracticaByEstudiante/{estudianteId}", produces = "application/json")
  public ResponseEntity<Practica> getPracticaByEstudiante(@PathVariable String estudianteId) {
    Practica practica = practicaService.getPracticaByEstudiante(estudianteId);
    PracticaResponse response = new PracticaResponse();
    response.setStatus(200);
    response.setMessage("Práctica encontrada para el estudiante");
    response.setPractica(practica);
    return ResponseEntity.ok()
        .body(practica);
  }

  // Obtener todas las prácticas
  @GetMapping(value = "getAll", produces = "application/json")
  public ResponseEntity<List<Practica>> getAllPracticas() {
    List<Practica> practicas = practicaService.getAllPracticas();
    PracticaResponse response = new PracticaResponse();
    response.setStatus(200);
    response.setMessage("Lista de prácticas obtenida con éxito");
    return ResponseEntity.ok()
        .body(practicas);
  }

  @PutMapping(value = "update/{id}", produces = "application/json")
  public ResponseEntity<PracticaResponse> updatePractica(@PathVariable String id,
      @RequestBody Practica practicaRequest) {
    PracticaResponse practicaResponse = new PracticaResponse();

    Practica practicaActualizada = practicaService.updatePractica(id, practicaRequest);

    // Verifica si la práctica fue encontrada y actualizada
    if (practicaActualizada == null) {
      // Si la práctica no se encontró, retorna un mensaje de error
      practicaResponse.setStatus(404);
      practicaResponse.setMessage("Práctica no encontrada");
      return ResponseEntity.status(404).body(practicaResponse);
    }

    // Si la práctica se actualizó correctamente
    practicaResponse.setStatus(200);
    practicaResponse.setMessage("Práctica actualizada exitosamente");
    practicaResponse.setPractica(practicaActualizada); // Asignamos la práctica actualizada al response
    return ResponseEntity.ok().body(practicaResponse); // Retorna la respuesta con la práctica actualizada
  }

  // Obtener estudiantes de una práctica
  @GetMapping(value = "{practicaId}/estudiantes", produces = "application/json")
  public ResponseEntity<List<Estudiante>> getEstudiantesByPractica(@PathVariable String practicaId) {
    List<Estudiante> estudiantes = practicaService.getEstudiantesByPractica(practicaId);
    EstudiantesResponse response = new EstudiantesResponse();
    response.setStatus(200);
    response.setMessage("Lista de estudiantes obtenida con éxito");
    return ResponseEntity.ok()
        .body(estudiantes);
  }

  // Asignar estudiantes a una práctica
  @PostMapping(value = "{practicaId}/asignar-estudiantes", produces = "application/json")
  public ResponseEntity<Practica> asignarEstudiantesAPractica(
      @PathVariable String practicaId,
      @RequestBody List<String> estudianteIds) {
    Practica practica = practicaService.asignarEstudiantesAPractica(practicaId, estudianteIds);
    PracticaResponse response = new PracticaResponse();
    response.setStatus(200);
    response.setPractica(practica);
    return ResponseEntity.ok()
        .body(practica);
  }

  // Asignar práctica a un estudiante
  @PostMapping(value = "getPracticaByEstudiante/{estudianteId}", produces = "application/json")
  public ResponseEntity<Estudiante> asignarPracticaAEstudiante(
      @PathVariable String estudianteId,
      @PathVariable String practicaId) {
    Estudiante estudiante = practicaService.asignarPracticaAEstudiante(estudianteId, practicaId);
    EstudiantesResponse response = new EstudiantesResponse();
    response.setStatus(200);
    response.setMessage("Práctica asignada exitosamente al estudiante");
    return ResponseEntity.ok()
        .body(estudiante);
  }

  // Obtener una práctica por su ID
  @GetMapping(value = "getPracticaById/{practicaId}", produces = "application/json")
  public ResponseEntity<Practica> getById(@PathVariable String practicaId) {
    Practica practica = practicaService.getById(practicaId);
    PracticaResponse response = new PracticaResponse();
    response.setStatus(200);
    response.setMessage("Práctica obtenida con éxito");
    response.setPractica(practica);
    return ResponseEntity.ok()
        .body(practica);
  }

  @DeleteMapping(value = "delete/{id}", produces = "application/json")
  public ResponseEntity<PracticaResponse> deletePractica(@PathVariable String id) {
    PracticaResponse practicaResponse = new PracticaResponse();

    boolean isDeleted = practicaService.deletePractica(id);

    if (isDeleted) {
      practicaResponse.setStatus(200);
      practicaResponse.setMessage("La práctica ha sido eliminada correctamente.");
      return ResponseEntity.ok().body(practicaResponse);
    } else {
      practicaResponse.setStatus(404);
      practicaResponse.setMessage("Práctica no encontrada.");
      return ResponseEntity.status(404).body(practicaResponse);
    }
  }

}
