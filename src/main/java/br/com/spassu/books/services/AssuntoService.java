package br.com.spassu.books.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spassu.books.models.Assunto;
import br.com.spassu.books.repositories.AssuntoRepository;

@Service
public class AssuntoService {
	
	@Autowired
	private AssuntoRepository repository;

	public List<Assunto> list() {
		return this.repository.findAll();
	}
	
	public Assunto getById(Integer id) {
		return this.repository.findById(id).orElse(null);
	}
	
	public Assunto save(Assunto assunto) {
		if (assunto.getCodigo() != null) {
			Assunto assuntoRecuperado = this.repository.findById(assunto.getCodigo()).orElseGet(null);
			assuntoRecuperado.setDescricao(assunto.getDescricao());
			assunto = assuntoRecuperado;
		}
		return this.repository.save(assunto);
	}
	
	public void delete(Integer id) {
		this.repository.deleteById(id);
	}
}
