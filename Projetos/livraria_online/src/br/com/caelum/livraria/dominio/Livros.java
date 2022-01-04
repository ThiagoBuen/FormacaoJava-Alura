package br.com.caelum.livraria.dominio;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.javamoney.moneta.Money;

public class Livros implements Iterable<Livro> { 
	
	private final List<Livro> lista;
	
	public Livros(Livro ... livros) {
		this.lista = Arrays.stream(livros)
				.collect(Collectors.toList());
	}
	
	public Money getSubtotal() {		
		
		return lista
				.stream()
				.map(Livro::getValor)
				.reduce(Money.of(0, Livraria.reais), Money::add);
//		Money subTotal = Money.of(0, Livraria.reais);
			
//		for(Livro livro : lista) {
//			Money valorDoLivro = livro.getValor();
//			subTotal = subTotal.add(valorDoLivro);
//		}
//		return subTotal;
	}

	@Override
	public Iterator<Livro> iterator() {
		return lista.iterator();
	}

	public void adicionar(Livro livro) {
		this.lista.add(livro);
	}
}
