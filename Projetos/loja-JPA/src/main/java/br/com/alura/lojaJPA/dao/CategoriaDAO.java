package br.com.alura.lojaJPA.dao;

import javax.persistence.EntityManager;

import br.com.alura.lojaJPA.modelo.Categoria;

public class CategoriaDAO {
	
	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	
}
