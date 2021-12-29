package mx.edu.uacm.progweb.listanombre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uacm.progweb.listanombre.dominio.Persona;
import mx.edu.uacm.progweb.listanombre.repository.PersonaRepository;
import mx.edu.uacm.progweb.listanombre.service.impl.PersonaServiceImpl;

@Service
public class PersonaService implements PersonaServiceImpl{

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		return (List<Persona>)personaRepository.findAll();
	}

	@Override
	public Optional<Persona> listarId(Long id) {
		// TODO Auto-generated method stub
		 
		return personaRepository.findById(id);
	}

	@Override
	public Long save(Persona p) {
		// TODO Auto-generated method stub
		Long respuesta = (long) 0;
		Persona persona = personaRepository.save(p);
		if (!persona.equals(null)) {
			respuesta=(long) 1;
		}
		return respuesta;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		personaRepository.deleteById(id);
		
	}

	
}
