package mx.edu.uacm.progweb.listanombre.service.impl;

import java.util.List;
import java.util.Optional;

import mx.edu.uacm.progweb.listanombre.dominio.Persona;

public interface PersonaServiceImpl {
	
	public List<Persona> listar();
	public Optional<Persona> listarId(Long id);
	public Long save(Persona p);
	public void delete(Long id);

}
