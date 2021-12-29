package mx.edu.uacm.progweb.listanombre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.edu.uacm.progweb.listanombre.dominio.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{

}
