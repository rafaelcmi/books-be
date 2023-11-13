package br.com.spassu.books.controllers;

import java.util.List;
import java.util.Objects;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.spassu.books.models.Autor;
import br.com.spassu.books.services.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorService service;
	
	@GetMapping
	public List<Autor> listar() {
		return this.service.list();
	}
	
	@GetMapping("/{id}")
	public Autor obterAutor(@PathVariable Integer id) {
		return this.service.getById(id);
	}
	
	@PostMapping
	public Autor criarAutor(@RequestBody Autor autor) {
		return this.service.save(autor);
	}
	
	@PutMapping("/{id}")
	public Autor atualizarAutor(@PathVariable Integer id, @RequestBody Autor autor) {
		Autor autorExistente = this.service.getById(id);
		
		if (Objects.nonNull(autorExistente)) {
			autor.setCodigo(id);
			return this.service.save(autor);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado");
		}
	}
	
	@DeleteMapping("/{id}")
	public void removerAutor(@PathVariable Integer id) {
		try {
			this.service.delete(id);			
		} catch (ConstraintViolationException e) {
			throw new ConstraintViolationException(e.getMessage(), null, null);
		}
	}
}
