package br.com.alura.lojaJPA.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	@EmbeddedId
	private CategoriaId id;
	
	public Categoria() {
		
	}
	
	public Categoria(String nome) {
		this.id = new CategoriaId(nome, "xpto");
	}

	public String getNome() {
		return this.id.getNome();
	}

	public void setNome(String nome) {
		this.id.setNome(nome);
	}
	
	
	
}
