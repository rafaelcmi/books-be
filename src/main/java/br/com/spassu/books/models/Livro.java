package br.com.spassu.books.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

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
	
	@ManyToMany
	@JoinTable(name = "livro_assunto", joinColumns = @JoinColumn(name = "Livro_Codl", table = "livro"), 
		inverseJoinColumns = @JoinColumn(name = "Assunto_codAs", table = "assunto"), 
		uniqueConstraints = { @UniqueConstraint(columnNames = {"Livro_Codl", "Assunto_codAs"})
	})
	private List<Assunto> assunto;
	
	@ManyToMany
	@JoinTable(name = "livro_autor", joinColumns = @JoinColumn(name = "Livro_Codl", table = "livro"), 
		inverseJoinColumns = @JoinColumn(name = "Autor_CodAu", table = "autor"), 
		uniqueConstraints = { @UniqueConstraint(columnNames = {"Livro_Codl", "Autor_CodAu"})
	})
	private List<Autor> autor;
	
	
}
