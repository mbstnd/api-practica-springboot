package ipss.cl.registropracticas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ipss.cl.registropracticas.models.Practica;

import ipss.cl.registropracticas.responses.PracticaResponse;
import ipss.cl.registropracticas.services.PracticaService;

@RestController
@RequestMapping("api/practicas")
public class PracticaController {

  @Autowired
  private PracticaService practicaService;

  // Crear una práctica
  @PostMapping(value = "create", produces = "application/json")
  public ResponseEntity<PracticaResponse> createPractica(@RequestBody Practica practica) {
    Practica nuevaPractica = practicaService.createPractica(practica);
    PracticaResponse response = new PracticaResponse();
    response.setStatus(201);
    response.setMessage("Práctica creada exitosamente");
    response.setPractica(List.of(nuevaPractica));
    return ResponseEntity.status(201).body(response);
  }

  @GetMapping(value = "getAll", produces = "application/json")
  public ResponseEntity<PracticaResponse> getAllPracticas() {
    List<Practica> practicas = practicaService.getAllPracticas();
    PracticaResponse response = new PracticaResponse();
    response.setStatus(200);
    response.setMessage("Lista de prácticas obtenida con éxito");
    response.setPractica(practicas);
    return ResponseEntity.ok().body(response);
  }

  @GetMapping(value = "getPracticaById/{practicaId}", produces = "application/json")
  public ResponseEntity<PracticaResponse> getById(@PathVariable String practicaId) {
    Practica practica = practicaService.getById(practicaId);
    PracticaResponse response = new PracticaResponse();
    response.setStatus(200);
    response.setMessage("Práctica obtenida con éxito");
    response.setPractica(List.of(practica));
    return ResponseEntity.ok().body(response);
  }

  @DeleteMapping(value = "delete/{id}", produces = "application/json")
  public ResponseEntity<PracticaResponse> deletePractica(@PathVariable String id) {
    boolean isDeleted = practicaService.deletePractica(id);
    PracticaResponse response = new PracticaResponse();

    if (isDeleted) {
      response.setStatus(200);
      response.setMessage("La práctica ha sido eliminada correctamente.");
      return ResponseEntity.ok().body(response);
    } else {
      response.setStatus(404);
      response.setMessage("Práctica no encontrada.");
      return ResponseEntity.status(404).body(response);
    }
  }

}
