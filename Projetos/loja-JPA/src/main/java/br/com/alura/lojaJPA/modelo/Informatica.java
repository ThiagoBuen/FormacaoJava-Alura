package br.com.alura.lojaJPA.modelo;

import javax.persistence.Entity;

@Entity
public class Informatica extends Produto{
	private String marca;
	private String modelo;
	
	public Informatica() {
		// TODO Auto-generated constructor stub
	}	
	
	public Informatica(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
