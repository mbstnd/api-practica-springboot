package ipss.cl.registropracticas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ipss.cl.registropracticas.models.Estudiante;
import ipss.cl.registropracticas.responses.EstudianteResponse;
import ipss.cl.registropracticas.services.EstudianteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("api")
public class EstudianteController {

  @Autowired
  private EstudianteService estudianteService;

  @PostMapping(value = "create", produces = "application/json")
  public ResponseEntity<Object> create(@RequestBody Estudiante estudiante) {
    estudianteService.create(estudiante);

    EstudianteResponse estudianteResponse = new EstudianteResponse();
    estudianteResponse.setStatus(200);
    estudianteResponse.setMessage("Estudiante creado correctamente.");
    estudianteResponse.setEstudiante(estudiante);

    return ResponseEntity.ok()
        .body(estudianteResponse);
  }

}
