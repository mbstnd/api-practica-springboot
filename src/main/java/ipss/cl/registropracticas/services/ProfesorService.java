package ipss.cl.registropracticas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipss.cl.registropracticas.models.Profesor;
import ipss.cl.registropracticas.repositories.ProfesorRepository;

@Service
public class ProfesorService {

  @Autowired
  private ProfesorRepository profesorRepository;

  public List<Profesor> getAll() {
    List<Profesor> profesores = profesorRepository.findAll();
    return profesores;
  }

  public Optional<Profesor> getById(String id) {
    return profesorRepository.findById(id);

  }

  public Profesor create(Profesor profesor) {
    return profesorRepository.save(profesor);

  }

  public Profesor update(String id, Profesor profesor) {
    Optional<Profesor> existingProfesor = profesorRepository.findById(id);

    if (existingProfesor.isPresent()) {
      // Si el profesor existe, actualizamos sus datos
      Profesor updatedProfesor = existingProfesor.get();
      updatedProfesor.setNombre(profesor.getNombre());
      updatedProfesor.setEmail(profesor.getEmail());
      updatedProfesor.setTelefono(profesor.getTelefono());
      updatedProfesor.setPracticeIds(profesor.getPracticeIds());
      // Guardamos el profesor actualizado
      return profesorRepository.save(updatedProfesor);
    } else {
      // Si no se encuentra el profesor, lanzamos una excepción o retornamos null
      return null; // O podrías lanzar una excepción personalizada si lo prefieres
    }

  }

  public void delete(String id) {
    profesorRepository.deleteById(id);

  }

}
