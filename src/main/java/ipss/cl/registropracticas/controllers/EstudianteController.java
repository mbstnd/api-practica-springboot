package ipss.cl.registropracticas.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ipss.cl.registropracticas.models.Estudiante;
import ipss.cl.registropracticas.models.Practica;
import ipss.cl.registropracticas.responses.EstudiantesResponse;
import ipss.cl.registropracticas.services.EstudianteService;
import ipss.cl.registropracticas.services.PracticaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("api/estudiantes")
public class EstudianteController {

  @Autowired
  private EstudianteService estudianteService;

  @Autowired
  private PracticaService practicaService;

  // @Autowired
  // private ProfesorService profesorService;

  // Crear un estudiante
  @PostMapping(value = "create", produces = "application/json")
  public ResponseEntity<Object> createEstudiante(@RequestBody Estudiante estudiante) {
    Estudiante estudianteCreado = estudianteService.createEstudiante(estudiante);

    // Crear la respuesta
    EstudiantesResponse response = new EstudiantesResponse();
    response.setStatus(201);
    response.setMessage("Estudiante creado exitosamente.");

    // Crear lista de estudiantes e incluir el recién creado
    response.setEstudiantes(Arrays.asList(estudianteCreado));

    // Retornar la respuesta
    return ResponseEntity.status(201).body(response);
  }

  // Obtener todos los estudiantes
  @GetMapping(value = "getAll", produces = "application/json")
  public ResponseEntity<EstudiantesResponse> getAllEstudiantes() {
    List<Estudiante> estudiantes = estudianteService.getAllEstudiantes();
    EstudiantesResponse estudiantesResponse = new EstudiantesResponse();
    estudiantesResponse.setStatus(200);
    estudiantesResponse.setMessage("Lista de estudiantes obtenida exitosamente");
    estudiantesResponse.setEstudiantes(estudiantes);

    return new ResponseEntity<>(estudiantesResponse, HttpStatus.OK);
  }

  // Obtener un estudiante por ID
  @GetMapping(value = "getById/{id}", produces = "application/json")
  public ResponseEntity<Object> getByIdEstudiante(@PathVariable String id) {
    EstudiantesResponse estudiantesResponse = new EstudiantesResponse();
    estudiantesResponse.setStatus(200);
    estudiantesResponse.setMessage("El estudiante fue encontrado exitosamente");

    // Obtener al estudiante por ID
    Estudiante estudiante = estudianteService.obtenerEstudiante(id);

    // Establecer el estudiante encontrado en la respuesta
    estudiantesResponse.setEstudiantes(List.of(estudiante));

    return ResponseEntity.ok().body(estudiantesResponse);
  }

  // Asignar una práctica a un estudiante
  @PutMapping(value = "asignarPractica/{estudianteId}/{practicaId}", produces = "application/json")
  public ResponseEntity<Object> asignarPracticaAEstudiante(@PathVariable String estudianteId,
      @PathVariable String practicaId) {
    // Asignar la práctica al estudiante
    Estudiante estudianteAsignado = practicaService.asignarPracticaAEstudiante(estudianteId, practicaId);

    // Crear la respuesta
    EstudiantesResponse response = new EstudiantesResponse();
    response.setStatus(200);
    response.setMessage("Práctica asignada al estudiante exitosamente.");

    // Retornar la respuesta
    response.setEstudiantes(Arrays.asList(estudianteAsignado));
    return ResponseEntity.status(200).body(response);
  }

  // Obtener todas las prácticas de un estudiante
  @GetMapping(value = "getPracticas/{estudianteId}", produces = "application/json")
  public ResponseEntity<Object> getPracticasDeEstudiante(@PathVariable String estudianteId) {
    // Obtener la práctica del estudiante
    Practica practica = practicaService.getPracticaByEstudiante(estudianteId);

    // Crear la respuesta
    EstudiantesResponse response = new EstudiantesResponse();
    response.setStatus(200);
    response.setMessage("Práctica obtenida exitosamente.");

    // Establecer la lista de estudiantes en la respuesta
    response.setEstudiantes(practica.getEstudiantes()); // No es necesario envolverlo en otra lista

    return ResponseEntity.ok().body(response);
  }

}
