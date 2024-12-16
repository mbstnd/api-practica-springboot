package ipss.cl.registropracticas.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

import ipss.cl.registropracticas.models.Estudiante;
import ipss.cl.registropracticas.models.Practica;
import ipss.cl.registropracticas.repositories.EstudianteRepository;
import ipss.cl.registropracticas.repositories.PracticaRepository;
import ipss.cl.registropracticas.responses.PracticaResponse;

@Controller
@RequestMapping("api/practicas")
public class PracticasController {

  @Autowired
  private PracticaRepository practicaRepository;

  @Autowired
  private EstudianteRepository estudianteRepository;

  // Endpoint para agregar una práctica para un estudiante
  @PostMapping(value = "create", produces = "application/json")
  public ResponseEntity<Practica> addPractica(@RequestBody Practica practica) {
    // Si la práctica ya tiene estudiantes asignados, agregar el ID de un estudiante
    // a la lista
    if (practica.getStudentIds() != null && !practica.getStudentIds().isEmpty()) {
      // El ID del primer estudiante de la lista, o el ID de un estudiante específico
      String studentId = practica.getStudentIds().get(0);

      // Obtener el estudiante de la base de datos utilizando su ID
      Estudiante estudiante = estudianteRepository.findById(studentId).orElse(null);

      if (estudiante != null) {
        // Agregar el ID de la práctica al estudiante
        estudiante.getPracticaIds().add(practica.getId());

        // Actualizar el estudiante con la nueva práctica asociada
        estudianteRepository.save(estudiante);
      } else {
        // Si el estudiante no se encuentra en la base de datos
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } else {
      // Si no se ha proporcionado ningún estudiante, creamos uno nuevo
      Estudiante nuevoEstudiante = new Estudiante();
      nuevoEstudiante.setId(UUID.randomUUID().toString()); // Asignamos un ID único
      estudianteRepository.save(nuevoEstudiante);

      // Asignamos el ID de este nuevo estudiante a la práctica
      practica.setStudentIds(Collections.singletonList(nuevoEstudiante.getId()));
    }

    // Guardamos la práctica con los estudiantes asociados
    Practica savedPractica = practicaRepository.save(practica);

    return new ResponseEntity<>(savedPractica, HttpStatus.CREATED);
  }

  // Endpoint para obtener todas las prácticas
  @GetMapping(value = "getAll", produces = "application/json")
  public ResponseEntity<List<Practica>> getAllPracticas() {
    List<Practica> practicas = practicaRepository.findAll(); // Obtener todas las prácticas
    return new ResponseEntity<>(practicas, HttpStatus.OK);
  }

  // Endpoint para obtener una práctica por su ID
  @GetMapping(value = "getById/{id}", produces = "application/json")
  public ResponseEntity<PracticaResponse> findPracticaById(@PathVariable String id) {
    // Intentamos obtener la práctica de la base de datos
    return practicaRepository.findById(id)
        .map(practica -> {
          // Crear una respuesta con la práctica encontrada
          PracticaResponse practicaResponse = new PracticaResponse();
          practicaResponse.setStatus(200);
          practicaResponse.setMessage("Práctica encontrada");
          practicaResponse.setPractica(practica);
          return ResponseEntity.ok(practicaResponse); // Retorna el objeto encontrado
        })
        .orElseGet(() -> {
          // Si no se encuentra la práctica, retorno una respuesta 404 con un mensaje
          // detallado
          PracticaResponse errorResponse = new PracticaResponse();
          errorResponse.setStatus(404);
          errorResponse.setMessage("Práctica no encontrada");
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        });
  }

  // Endpoint para actualizar una práctica
  @PutMapping(value = "update/{id}", produces = "application/json")
  public ResponseEntity<Practica> updatePractica(@PathVariable("id") String id, @RequestBody Practica updatedPractica) {
    // Buscar la práctica por ID
    Optional<Practica> practicaOptional = practicaRepository.findById(id);

    if (practicaOptional.isPresent()) {
      Practica practica = practicaOptional.get();

      // Actualizar los campos de la práctica
      practica.setDescripcion(updatedPractica.getDescripcion());
      practica.setEstado(updatedPractica.getEstado());
      practica.setFechaInicio(updatedPractica.getFechaInicio());
      practica.setFechaTermino(updatedPractica.getFechaTermino());
      practica.setEmpresa(updatedPractica.getEmpresa());
      practica.setJefeDirecto(updatedPractica.getJefeDirecto());
      practica.setProfesorSupervisor(updatedPractica.getProfesorSupervisor());

      // Guardar la práctica actualizada
      practicaRepository.save(practica);
      return new ResponseEntity<>(practica, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Endpoint para eliminar una práctica
  @DeleteMapping(value = "delete/{id}", produces = "application/json")
  public ResponseEntity<String> deletePractica(@PathVariable("id") String id) {
    // Buscar la práctica por ID
    Optional<Practica> practicaOptional = practicaRepository.findById(id);

    if (practicaOptional.isPresent()) {
      Practica practica = practicaOptional.get();
      practicaRepository.delete(practica);
      return new ResponseEntity<>("Práctica eliminada correctamente", HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
