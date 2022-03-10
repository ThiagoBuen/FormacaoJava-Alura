package br.com.alura.lojaJPA.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.lojaJPA.dao.CategoriaDAO;
import br.com.alura.lojaJPA.dao.ClienteDAO;
import br.com.alura.lojaJPA.dao.ProdutoDAO;
import br.com.alura.lojaJPA.modelo.Categoria;
import br.com.alura.lojaJPA.modelo.Cliente;
import br.com.alura.lojaJPA.modelo.Produto;
import br.com.alura.lojaJPA.util.JPAUtil;

public class testeCriteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		popularBD();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		
		List<Produto> foundProducts = produtoDao.buscarPorParametrosComCriteria("PS5", null, LocalDate.now());
		for (Produto produto : foundProducts) {
			System.out.println("Produto encontrado: " + produto.getNome());
		}
	}
	
	private static void popularBD() {
		Categoria celulares = new Categoria("CELULARES");	
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi Redmi", "Brabo", new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("4000"), videogames);
		Produto macbook= new Produto("Macbook", "Macbook Pro", new BigDecimal("40000"), informatica);
	
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		categoriaDao.cadastrar(videogames);
		produtoDao.cadastrar(videogame);
		categoriaDao.cadastrar(informatica);
		produtoDao.cadastrar(macbook);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
