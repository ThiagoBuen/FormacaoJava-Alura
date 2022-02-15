package br.com.alura.lojaJPA.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.lojaJPA.modelo.Produto;

public class ProdutoDAO {
	
	private EntityManager em;

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public Produto buscarPorId(Long id) {
		return this.em.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos(){
		
		String jpql = "SELECT p FROM Produto p";
		return this.em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public List<Produto> buscarPorNome(String nome){
		
		String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";  //or p.nome = :nome
		return this.em.createQuery(jpql, Produto.class)
				.setParameter(1, nome)		//or ("nome", nome)
				.getResultList();
	}
	
public List<Produto> buscarPorNomeDaCategoria(String nome){
		
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = ?1";  //or p.nome = :nome
		return this.em.createQuery(jpql, Produto.class)
				.setParameter(1, nome)		//or ("nome", nome)
				.getResultList();
	}

	public BigDecimal buscarPrecoDoProduto(String nome){
		
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = ?1";  //or p.nome = :nome
		return this.em.createQuery(jpql, BigDecimal.class)
				.setParameter(1, nome)		//or ("nome", nome)
				.getSingleResult();
	}

}
