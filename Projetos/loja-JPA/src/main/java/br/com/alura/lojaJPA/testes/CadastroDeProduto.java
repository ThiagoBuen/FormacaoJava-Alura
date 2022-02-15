package br.com.alura.lojaJPA.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.lojaJPA.dao.CategoriaDAO;
import br.com.alura.lojaJPA.dao.ProdutoDAO;
import br.com.alura.lojaJPA.modelo.Categoria;
import br.com.alura.lojaJPA.modelo.Produto;
import br.com.alura.lojaJPA.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		
		cadastrarProduto();
		
		Long findThisId = 1l;
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		
		Produto foundProduct = produtoDao.buscarPorId(findThisId);
		System.out.println(foundProduct.getPreco());
		
		
		List<Produto> allProducts = produtoDao.buscarTodos();
		allProducts.forEach(p2 -> System.out.println(p2.getNome()));
		
		String filterName = "Xiaomi Redmi";
		List<Produto> foundByName = produtoDao.buscarPorNome(filterName);
		foundByName.forEach(p3 -> System.out.println(p3.getNome()));
		
		String filterCategoria = "CELULARES";
		List<Produto> foundByCategory = produtoDao.buscarPorNomeDaCategoria(filterCategoria);
		foundByCategory.forEach(p4 -> System.out.println(p4.getCategoria()));
		
		BigDecimal productPrice = produtoDao.buscarPrecoDoProduto(filterName);
		
		System.out.println("Preco do produto: " + productPrice);
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");		
		Produto celular = new Produto("Xiaomi Redmi", "Brabo", new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
				
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
//		
//		em.persist(celulares);
//		celulares.setNome("XPTO");
//		
//		em.flush();
//		em.clear();
//		
//		celulares= em.merge(celulares);
//		celulares.setNome("1234");
//
//		em.flush();
//		
//		em.remove(celulares);
//		em.flush();
	}
}
