package ipss.cl.registropracticas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ipss.cl.registropracticas.models.Estudiante;
import ipss.cl.registropracticas.responses.EstudianteResponse;
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
  public ResponseEntity<Object> create(@RequestBody Estudiante estudiante) {
    try {
      // Crear el estudiante usando el servicio y persistirlo
      Estudiante estudianteGuardado = estudianteService.create(estudiante);

      // Crear la respuesta con el estudiante guardado (que tiene el ID generado)
      EstudianteResponse estudianteResponse = new EstudianteResponse();
      estudianteResponse.setStatus(200);
      estudianteResponse.setMessage("Estudiante creado correctamente.");
      estudianteResponse.setEstudiante(estudianteGuardado); // Estudiante guardado con ID

      return ResponseEntity.ok().body(estudianteResponse); // Retornar el estudiante creado

    } catch (Exception e) {
      // Manejar excepciones y devolver un error con mensaje claro
      EstudianteResponse errorResponse = new EstudianteResponse();
      errorResponse.setStatus(500);
      errorResponse.setMessage("Error al crear el estudiante: " + e.getMessage());

      return ResponseEntity.status(500).body(errorResponse); // Retornar el error con la respuesta estándar
    }
  }

  @GetMapping(value = "getAll", produces = "application/json")
  public ResponseEntity<Object> getAll() {
    // Obtener la lista de estudiantes del servicio
    List<Estudiante> estudiantes = estudianteService.getAll();

    // Crear la respuesta con los estudiantes
    EstudianteResponse estudianteResponse = new EstudianteResponse();
    estudianteResponse.setStatus(200);
    estudianteResponse.setMessage("Estudiantes obtenidos correctamente.");
    estudianteResponse.setEstudiante(null);
    estudianteResponse.setEstudiantes(estudiantes); // Asignar la lista de estudiantes con las prácticas

    // Retornar la respuesta en formato JSON
    return ResponseEntity.ok().body(estudianteResponse); // Respuesta con el objeto EstudianteResponse
  }

  @GetMapping(value = "getById/{id}", produces = "application/json")
  public ResponseEntity<Object> getById(@PathVariable("id") String estudianteId) {
    Estudiante estudiante = estudianteService.getById(estudianteId);

    if (estudiante == null) {
      return ResponseEntity.status(404).body("Estudiante no encontrado");
    }

    EstudianteResponse estudianteResponse = new EstudianteResponse();
    estudianteResponse.setStatus(200);
    estudianteResponse.setMessage("Estudiante obtenido correctamente.");
    estudianteResponse.setEstudiante(estudiante);

    return ResponseEntity.ok().body(estudianteResponse);
  }

}
