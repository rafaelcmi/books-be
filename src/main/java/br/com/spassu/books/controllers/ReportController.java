package br.com.spassu.books.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.spassu.books.models.Report;
import br.com.spassu.books.services.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private ReportService service;
	
	@GetMapping
	public List<Report> listar() {
		return this.service.list();
	}
	
	@GetMapping("/{id}")
	public List<Report> obterReportByAutor(@PathVariable Integer id) {
		List<Report> reports = this.service.listByAutor(id);
		
		if (Objects.nonNull(reports)) {
			return reports;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum livro não encontrado para este autor");
		}
	}
}
