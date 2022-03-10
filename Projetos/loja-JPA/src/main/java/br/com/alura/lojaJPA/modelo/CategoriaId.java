package br.com.alura.lojaJPA.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CategoriaId implements Serializable{
	private String nome;
	private String tipo;
	
	public CategoriaId() {
		// TODO Auto-generated constructor stub
	}

	public CategoriaId(String nome, String tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
}
