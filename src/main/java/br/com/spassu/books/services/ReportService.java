package br.com.spassu.books.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spassu.books.models.Report;
import br.com.spassu.books.repositories.ReportRepository;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository repository;
	
	public List<Report> list() {
		return this.repository.findAll();
	}
}
