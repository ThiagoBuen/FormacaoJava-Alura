package br.com.caelum.livraria.dominio;

import org.javamoney.moneta.Money;

public class Livro {
	
	private final String titulo;
	private final Autor autor;
	private final ISBN isbn;
	private final Money valor;
	
	public Livro(String titulo, Autor autor, ISBN isbn, Money valor) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.autor = autor;
		this.valor = valor;
	}
	
	public Money getValor() {
		return valor;
	}
	
	public String getValorFormatado() {
		return FormatadorUtils.getValorFormatado(valor);
	}
	
	public String getNome() {
		return titulo;
	}
	
	public String getISBN() {
		return isbn.toString();
	}
	
	public String getAutor() {
		return autor.getNome();
	}
	
	public String getUltimoSobrenomeDoAutor() {
		return autor.getUltimoSobrenomeDoAutor();
	}
	

}
