package br.com.alura.lojaVirtual.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.lojaVirtual.dao.CategoriaDAO;
import br.com.alura.lojaVirtual.dao.ProdutoDAO;
import br.com.alura.lojaVirtual.model.Categoria;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);			
			List<Categoria> listaCategorias = categoriaDAO.listarComProdutos();
			listaCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				for(Produto produto: ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}
			});
		}
	}
}
