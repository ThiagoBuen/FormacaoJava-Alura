package br.com.alura.lojaVirtual.model;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.lojaVirtual.teste.Produto;

public class Categoria {
	
	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Integer getId() {
		return id;
	}

	public void adicionar(Produto produto) {
		produtos.add(produto);
		
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
}
