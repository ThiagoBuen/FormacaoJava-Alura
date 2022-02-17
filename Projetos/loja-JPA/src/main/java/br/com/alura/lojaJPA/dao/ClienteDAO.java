package br.com.alura.lojaJPA.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.lojaJPA.modelo.Cliente;
import br.com.alura.lojaJPA.modelo.Pedido;
import br.com.alura.lojaJPA.modelo.Produto;

public class ClienteDAO {
	
	private EntityManager em;

	public ClienteDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public Cliente buscarPorId(Long id) {
		return this.em.find(Cliente.class, id);
	}
	

}
