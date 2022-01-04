package br.com.caelum.livraria.dominio;

public class ISBN {

	private final String numero;

	public ISBN(String isbn) {
		if(!validar(isbn)) 
			throw new IllegalArgumentException(String.format("ISBN inválido: %s", isbn));
		this.numero = isbn;
	}

	private boolean validar(String isbn) {
		return new ValidarISBN(isbn).validar();
	}
	
	@Override
	public String toString() {
		return numero;
	}
}
