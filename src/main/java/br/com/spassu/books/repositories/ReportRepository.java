package br.com.spassu.books.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spassu.books.models.Report;
import br.com.spassu.books.models.ReportId;

@Repository
public interface ReportRepository extends JpaRepository<Report, ReportId> {
	
	public List<Report> findByCodigoAutor(Integer codigoAutor);
}
