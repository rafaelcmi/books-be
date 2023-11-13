package br.com.spassu.books.models;

import java.io.Serializable;

public class ReportId implements Serializable {
	private static final long serialVersionUID = -8260056427717360356L;
	private Integer codigoAutor;
	private Integer codigoAssunto;
	private Integer codigoLivro;
	
	public ReportId() {
		super();
	}
	
	public ReportId(Integer codigoAutor, Integer codigoAssunto, Integer codigoLivro) {
		super();
		this.codigoAutor = codigoAutor;
		this.codigoAssunto = codigoAssunto;
		this.codigoLivro = codigoLivro;
	}

	public Integer getCodigoAutor() {
		return codigoAutor;
	}

	public void setCodigoAutor(Integer codigoAutor) {
		this.codigoAutor = codigoAutor;
	}

	public Integer getCodigoAssunto() {
		return codigoAssunto;
	}

	public void setCodigoAssunto(Integer codigoAssunto) {
		this.codigoAssunto = codigoAssunto;
	}

	public Integer getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(Integer codigoLivro) {
		this.codigoLivro = codigoLivro;
	}
}
