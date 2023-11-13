package br.com.spassu.books.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spassu.books.models.Livro;
import br.com.spassu.books.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	public List<Livro> list() {
		return this.repository.findAll();
	}
	
	public Livro getById(Integer id) {
		return this.repository.findById(id).orElse(null);
	}
	
	public Livro save(Livro livro) {
		return this.repository.save(livro);
	}
		
	public void delete(Integer id) {
		this.repository.deleteById(id);
	}
}
