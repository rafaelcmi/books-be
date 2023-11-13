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

import br.com.spassu.books.models.Livro;
import br.com.spassu.books.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroService service;
	
	@GetMapping
	public List<Livro> listar() {
		return this.service.list();
	}
	
	@GetMapping("/{id}")
	public Livro obterLivro(@PathVariable Integer id) {
		Livro livroExistente = this.service.getById(id);
		
		if (Objects.nonNull(livroExistente)) {
			return livroExistente;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");
		}
	}
	
	@PostMapping
	public Livro criarLivro(@RequestBody Livro livro) {
		return this.service.save(livro);
	}
	
	@PutMapping("/{id}")
	public Livro atualizarLivro(@PathVariable Integer id, @RequestBody Livro livro) {
		Livro livroExistente = this.service.getById(id);
		
		if (Objects.nonNull(livroExistente)) {
			livro.setCodigo(id);
			return this.service.save(livro);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");
		}
	}
	
	@DeleteMapping("/{id}")
	public void removerLivro(@PathVariable Integer id) {
		this.service.delete(id);
	}
}
