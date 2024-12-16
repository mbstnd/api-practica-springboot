package ipss.cl.registropracticas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ipss.cl.registropracticas.models.Practica;
import ipss.cl.registropracticas.responses.PracticaResponse;
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

  // Agregar práctica

  @PostMapping(value = "create", produces = "application/json")
  public ResponseEntity<Object> createPractica(@RequestBody Practica practica) {

    PracticaResponse practicaResponse = new PracticaResponse();

    practicaResponse.setStatus(200);
    practicaResponse.setMessage("Practica creada correctamente.");
    practicaResponse.setPractica(practica);

    return ResponseEntity.ok().body(practicaResponse);
  }

  @GetMapping(value = "getAll", produces = "application/json")
  public ResponseEntity<List<Practica>> getAllPracticas() {
    List<Practica> practicas = practicaService.getAllPracticas();
    return ResponseEntity.ok(practicas);
  }

  @PutMapping(value = "update/{id}", produces = "application/json")
  public ResponseEntity<Object> updatePractica(@PathVariable("id") String id, @RequestBody Practica practica) {
    Practica practicaActualizada = practicaService.updatePractica(id, practica);

    PracticaResponse practicaResponse = new PracticaResponse();
    practicaResponse.setStatus(200);
    practicaResponse.setMessage("Práctica actualizada correctamente.");
    practicaResponse.setPractica(practicaActualizada);

    return ResponseEntity.ok().body(practicaResponse);

  }

}
