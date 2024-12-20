package ipss.cl.registropracticas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipss.cl.registropracticas.models.Profesor;
import ipss.cl.registropracticas.repositories.ProfesorRepository;

@Service
public class ProfesorService {
  @Autowired
  private ProfesorRepository profesorRepository;

  // Obtener todos los profesores
  public List<Profesor> findAll() {
    return profesorRepository.findAll();
  }

  // Buscar un profesor por su ID
  public Profesor findById(String id) {
    return profesorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
  }

  // Guardar o actualizar un profesor
  public Profesor save(Profesor profesor) {
    return profesorRepository.save(profesor);
  }

  // Buscar un profesor por nombre completo
  public List<Profesor> findByNombreCompleto(String nombreCompleto) {
    return profesorRepository.findByNombreCompleto(nombreCompleto);
  }

  // Eliminar un profesor
  public void delete(Profesor profesor) {
    profesorRepository.delete(profesor);
  }

}
