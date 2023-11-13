package br.com.spassu.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spassu.books.models.Report;
import br.com.spassu.books.models.ReportId;

@Repository
public interface ReportRepository extends JpaRepository<Report, ReportId> {

}
