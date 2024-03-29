package mx.edu.uacm.progweb.listanombre.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.edu.uacm.progweb.listanombre.dominio.Persona;
import mx.edu.uacm.progweb.listanombre.service.impl.PersonaServiceImpl;

@Controller
@RequestMapping
public class PersonaControlador {
		
	@Autowired
	private PersonaServiceImpl implService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List <Persona> personas = implService.listar();
		model.addAttribute("personas", personas);
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona", new Persona());
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Valid Persona p, Model model) {
		implService.save(p);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Persona>persona = implService.listarId(id);
		model.addAttribute("persona", persona); 
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable Long id, Model model) {
		implService.delete(id);
		return "redirect:/listar";
	}

	
}
