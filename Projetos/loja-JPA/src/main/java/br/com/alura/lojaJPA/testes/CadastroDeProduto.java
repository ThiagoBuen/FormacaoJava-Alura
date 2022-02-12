package br.com.alura.lojaJPA.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.lojaJPA.dao.CategoriaDAO;
import br.com.alura.lojaJPA.dao.ProdutoDAO;
import br.com.alura.lojaJPA.modelo.Categoria;
import br.com.alura.lojaJPA.modelo.Produto;
import br.com.alura.lojaJPA.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		
		Categoria celulares = new Categoria("CELULARES");		
		Produto celular = new Produto("Xiaomi Redmi", "Brabo", new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		em.getTransaction().begin();
		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
		
	}
}
