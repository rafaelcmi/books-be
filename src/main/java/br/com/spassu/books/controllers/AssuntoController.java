package br.com.spassu.books.controllers;

import java.util.List;
import java.util.Objects;

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

import br.com.spassu.books.models.Assunto;
import br.com.spassu.books.services.AssuntoService;

@RestController
@RequestMapping("/assuntos")
public class AssuntoController {
	
	@Autowired
	private AssuntoService service;
	
	@GetMapping
	public List<Assunto> listar() {
		return this.service.list();
	}
	
	@GetMapping("/{id}")
	public Assunto obterAssunto(@PathVariable Integer id) {
		return this.service.getById(id);
	}
	
	@PostMapping
	public Assunto criarAssunto(@RequestBody Assunto assunto) {
		return this.service.save(assunto);
	}
	
	@PutMapping("/{id}")
	public Assunto atualizarAssunto(@PathVariable Integer id, @RequestBody Assunto assunto) {
		Assunto assuntoExistente = this.service.getById(id);
		
		if (Objects.nonNull(assuntoExistente)) {
			assunto.setCodigo(id);
			return this.service.save(assunto);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Assunto não encontrado");
		}
	}
	
	@DeleteMapping("/{id}")
	public void removerAssunto(@PathVariable Integer id) {
		this.service.delete(id);
	}
}
