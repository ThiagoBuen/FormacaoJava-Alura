package br.com.alura.loja;

import java.math.BigDecimal;

public class Produto {
	String nome;
	BigDecimal preco;
	
	public Produto(String name, BigDecimal preco) {
		this.nome = name;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
}
