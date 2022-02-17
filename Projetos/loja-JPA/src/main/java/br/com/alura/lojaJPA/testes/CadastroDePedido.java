package br.com.alura.lojaJPA.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.lojaJPA.dao.CategoriaDAO;
import br.com.alura.lojaJPA.dao.ClienteDAO;
import br.com.alura.lojaJPA.dao.PedidoDAO;
import br.com.alura.lojaJPA.dao.ProdutoDAO;
import br.com.alura.lojaJPA.modelo.Categoria;
import br.com.alura.lojaJPA.modelo.Cliente;
import br.com.alura.lojaJPA.modelo.ItemPedido;
import br.com.alura.lojaJPA.modelo.Pedido;
import br.com.alura.lojaJPA.modelo.Produto;
import br.com.alura.lojaJPA.util.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {
		popularBancoDeDados();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);
		
		Produto produto = produtoDao.buscarPorId(1l);
		Cliente cliente = clienteDao.buscarPorId(1l);
				
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		
		PedidoDAO pedidoDao = new PedidoDAO(em);
		pedidoDao.cadastrar(pedido);

		em.getTransaction().commit();
	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");		
		Produto celular = new Produto("Xiaomi Redmi", "Brabo", new BigDecimal("800"), celulares);
		Cliente cliente = new Cliente("Rodrigo", "12345");
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);
				
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		clienteDao.cadastrar(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
}
