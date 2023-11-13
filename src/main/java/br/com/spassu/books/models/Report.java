package br.com.spassu.books.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "vw_report")
@NoArgsConstructor
@Getter @Setter
@IdClass(ReportId.class)
public class Report {
	
	@Id
	@Column(name = "codigo_autor")
	private Integer codigoAutor;
	
	@Column(name = "autor")
	private String autor;
	
	@Id
	@Column(name = "codigo_livro")
	private Integer codigoLivro;
	
	@Column(name = "titulo_livro")
	private String tituloLivro;
	
	@Column(name = "valor_livro")
	private BigDecimal valorLivro;

	@Column(name = "ano_livro")
	private Integer anoLivro;	
	
	@Id
	@Column(name = "codigo_assunto")
	private Integer codigoAssunto;
	
	@Column(name = "assunto")
	private String assunto;
	
}
