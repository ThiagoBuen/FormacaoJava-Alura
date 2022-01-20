package br.com.alura.lojaVirtual.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.lojaVirtual.dao.ProdutoDAO;

public class TestaInsercaoEListagemProdutos {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Comoda", "Comoda Vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
			System.out.println("-------------");
			List<Produto> listaProdutos =  produtoDao.listar();
			listaProdutos.stream().forEach(lp -> System.out.println(lp));
		}
		
		//System.out.println(comoda);


	}

}
