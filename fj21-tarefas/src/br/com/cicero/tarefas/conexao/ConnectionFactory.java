package br.com.cicero.tarefas.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Fábrica de conexões
 * 
 * @author leandro
 * 
 */
public class ConnectionFactory {

	public static Connection getConnection() {

		System.out.println("Conectando ao banco");

		try {

			Class.forName("com.mysql.jdbc.Driver");

			return DriverManager.getConnection("jdbc:mysql://localhost/fj21",
					"root", "root");

		} catch (SQLException e) {

			throw new RuntimeException(e);

		} catch (ClassNotFoundException e) {

			throw new RuntimeException(e);

		}

	}

}
