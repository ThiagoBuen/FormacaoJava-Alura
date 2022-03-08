package br.com.alura.lojaJPA.testes;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

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
import br.com.alura.lojaJPA.vo.RelatorioDeVendasVo;

public class CadastroDePedido {

	public static void main(String[] args) {
		popularBancoDeDados();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);
		
		Produto produto = produtoDao.buscarPorId(1l);
		Produto produto2 = produtoDao.buscarPorId(2l);
		Produto produto3 = produtoDao.buscarPorId(3l);
		Cliente cliente = clienteDao.buscarPorId(1l);
				
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		pedido.adicionarItem(new ItemPedido(40, pedido, produto2));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(2, pedido, produto3));
		
		PedidoDAO pedidoDao = new PedidoDAO(em);
		pedidoDao.cadastrar(pedido);
		pedidoDao.cadastrar(pedido2);

		
		
		em.getTransaction().commit();
		
		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println("Valor total: " + totalVendido);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
		relatorio.forEach(System.out::println);
		
		PedidoDAO pedidoDao2 = new PedidoDAO(em);
		Pedido pedido3 = pedidoDao2.buscarPedidoComCliente(1l);
		em.close();
		System.out.println(pedido3.getCliente().getNome());
		
	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");	
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi Redmi", "Brabo", new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("4000"), videogames);
		Produto macbook= new Produto("Macbook", "Macbook Pro", new BigDecimal("40000"), informatica);
		
		Cliente cliente = new Cliente("Rodrigo", "12345");
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);
				
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		categoriaDao.cadastrar(videogames);
		produtoDao.cadastrar(videogame);
		categoriaDao.cadastrar(informatica);
		produtoDao.cadastrar(macbook);
		clienteDao.cadastrar(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
}
