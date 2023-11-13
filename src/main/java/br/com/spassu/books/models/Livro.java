package br.com.spassu.books.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Livro")
@NoArgsConstructor
@Getter @Setter
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Codl")
	private Integer codigo;
	
	@Column(name = "Titulo")
	private String titulo;
	
	@Column(name = "Editora")
	private String editora;

	@Column(name = "Edicao")
	private Integer edicao;
	
	@Column(name = "AnoPublicacao")
	private String anoPublicacao;
	
	@Column(name = "Valor")
	private BigDecimal valor;
	
	@OneToMany
	private List<Autor> autor;
	
	@OneToMany
	private List<Assunto> assunto;
	
}
