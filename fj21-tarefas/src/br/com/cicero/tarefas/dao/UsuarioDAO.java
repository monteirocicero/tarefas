package br.com.cicero.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.cicero.tarefas.conexao.ConnectionFactory;
import br.com.cicero.tarefas.model.Usuario;

public class UsuarioDAO {
	
	private Connection connection;
	private DAOException exception;
		
	public UsuarioDAO() {
		
		this.connection = ConnectionFactory.getConnection();
		
	}
	
	
	public boolean existeUsuario(Usuario usuario) {
		
		String sql = "SELECT * FROM usuarios WHERE login=?";
				
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				return true;
				
			}
						
		} catch (Exception e) {
			
			this.exception.getException(e);
			
		}
		
		return false;
				
	}

}
