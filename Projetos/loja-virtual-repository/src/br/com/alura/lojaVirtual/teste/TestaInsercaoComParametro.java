package br.com.alura.lojaVirtual.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperarConexao()) {
			connection.setAutoCommit(false);

//		String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES ('" + nome + "', '" + descricao +"')";
//				

//		System.out.println(sql);

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
				adiconarVariavel("SmartTV", "45 polegadas", stm);
				adiconarVariavel("Radio", "Radio de bateria", stm);

				connection.commit();

//			stm.close();
//			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback Executado");
				connection.rollback();
			}
//		connection.close();

		}

	}

	private static void adiconarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		if (nome.equals("Radio")) {
			throw new RuntimeException("Não foi possível adicionar o produto");
		}

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {

			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi " + id);
			}
		}
//		rst.close();
	}
}
