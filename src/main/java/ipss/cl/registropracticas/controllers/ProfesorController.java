package ipss.cl.registropracticas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ipss.cl.registropracticas.models.Profesor;
import ipss.cl.registropracticas.responses.ProfesorResponse;
import ipss.cl.registropracticas.services.ProfesorService;

@Controller
@RequestMapping("api/profesores")
public class ProfesorController {
  @Autowired
  private ProfesorService profesorService;

  // Crear un profesor
  @PostMapping(value = "create", produces = "application/json")
  public ResponseEntity<ProfesorResponse> createProfesor(@RequestBody Profesor profesor) {
    Profesor profesorCreado = profesorService.save(profesor);

    ProfesorResponse response = new ProfesorResponse();
    response.setStatus(201);
    response.setMessage("Profesor creado exitosamente");
    response.setProfesor(profesorCreado);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  // Obtener todos los profesores
  @GetMapping(value = "getAll", produces = "application/json")
  public ResponseEntity<List<Profesor>> getAllProfesores() {
    List<Profesor> profesores = profesorService.findAll();
    return ResponseEntity.ok().body(profesores);
  }

  // Obtener un profesor por ID
  @GetMapping(value = "getById/{id}", produces = "application/json")
  public ResponseEntity<ProfesorResponse> getProfesorById(@PathVariable String id) {
    Profesor profesor = profesorService.findById(id);
    ProfesorResponse response = new ProfesorResponse();
    response.setStatus(200);
    response.setMessage("Profesor encontrado exitosamente");
    response.setProfesor(profesor);

    return ResponseEntity.ok().body(response);
  }

  // Actualizar un profesor
  @PutMapping(value = "update/{id}", produces = "application/json")
  public ResponseEntity<ProfesorResponse> updateProfesor(@PathVariable String id,
      @RequestBody Profesor profesorRequest) {
    Profesor profesor = profesorService.findById(id);

    if (profesor == null) {
      ProfesorResponse response = new ProfesorResponse();
      response.setStatus(404);
      response.setMessage("Profesor no encontrado");
      response.setProfesor(null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    profesor.setNombreCompleto(profesorRequest.getNombreCompleto());
    profesor.setDepartamento(profesorRequest.getDepartamento());
    profesor.setCorreo(profesorRequest.getCorreo());
    profesor.setTelefono(profesorRequest.getTelefono());

    Profesor profesorActualizado = profesorService.save(profesor);

    ProfesorResponse response = new ProfesorResponse();
    response.setStatus(200);
    response.setMessage("Profesor actualizado exitosamente");
    response.setProfesor(profesorActualizado);

    return ResponseEntity.ok().body(response);
  }

  // Eliminar un profesor
  @DeleteMapping(value = "delete/{id}", produces = "application/json")
  public ResponseEntity<ProfesorResponse> deleteProfesor(@PathVariable String id) {
    Profesor profesor = profesorService.findById(id);
    ProfesorResponse response = new ProfesorResponse();

    if (profesor == null) {
      response.setStatus(404);
      response.setMessage("Profesor no encontrado");
      response.setProfesor(null); // Asignar null explícitamente
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    profesorService.delete(profesor);
    response.setStatus(200);
    response.setMessage("Profesor eliminado exitosamente");
    response.setProfesor(profesor); // Si quieres devolver el profesor eliminado

    return ResponseEntity.ok().body(response);
  }

  // Buscar un profesor por nombre completo
  @GetMapping(value = "searchByName/{nombreCompleto}", produces = "application/json")
  public ResponseEntity<List<Profesor>> getProfesorByName(@PathVariable String nombreCompleto) {
    List<Profesor> profesores = profesorService.findByNombreCompleto(nombreCompleto);
    return ResponseEntity.ok().body(profesores);
  }

}
