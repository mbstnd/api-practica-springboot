package ipss.cl.registropracticas.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ipss.cl.registropracticas.models.Estudiante;
import ipss.cl.registropracticas.responses.EstudiantesResponse;
import ipss.cl.registropracticas.services.EstudianteService;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("api/estudiantes")
public class EstudianteController {
  @Autowired
  private EstudianteService estudianteService;

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

  @GetMapping(value = "getAll", produces = "application/json")
  public ResponseEntity<EstudiantesResponse> getAllEstudiantes() {
    List<Estudiante> estudiantes = estudianteService.getAllEstudiantes();
    EstudiantesResponse estudiantesResponse = new EstudiantesResponse();
    estudiantesResponse.setStatus(200);
    estudiantesResponse.setMessage("Lista de estudiantes obtenida exitosamente");
    estudiantesResponse.setEstudiantes(estudiantes); // Asegúrate de que esto esté bien configurado

    return new ResponseEntity<>(estudiantesResponse, HttpStatus.OK);
  }

  @GetMapping(value = "getById/{id}", produces = "application/json")
  public ResponseEntity<Object> getByIdEstudiante(@PathVariable String id) {
    EstudiantesResponse estudiantesResponse = new EstudiantesResponse();
    estudiantesResponse.setStatus(200);
    estudiantesResponse.setMessage("El estudiante fue encontrado exitosamente");

    // Aquí debes invocar el servicio para obtener al estudiante por su ID
    Estudiante estudiante = estudianteService.obtenerEstudiante(id);

    // Establecer el estudiante encontrado en la respuesta
    estudiantesResponse.setEstudiantes(List.of(estudiante));

    return ResponseEntity.ok().body(estudiantesResponse);
  }

}
