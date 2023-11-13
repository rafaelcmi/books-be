package br.com.spassu.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spassu.books.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
