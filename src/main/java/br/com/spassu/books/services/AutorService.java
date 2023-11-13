package br.com.spassu.books.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spassu.books.models.Autor;
import br.com.spassu.books.repositories.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository repository;
	
	public List<Autor> list() {
		return this.repository.findAll();
	}
	
	public Autor getById(Integer id) {
		return this.repository.findById(id).orElse(null);
	}
	
	public Autor save(Autor autor) {
		return this.repository.save(autor);
	}
	
	public void delete(Integer id) {
		this.repository.deleteById(id);
	}
}
