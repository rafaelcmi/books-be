package br.com.spassu.books.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Assunto")
@NoArgsConstructor
@Getter @Setter
public class Assunto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codAs")
	private Integer codigo;
	
	@Column(name = "Descricao")
	private String descricao;	
}
