package br.com.cicero.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.cicero.tarefas.conexao.ConnectionFactory;
import br.com.cicero.tarefas.model.Tarefa;

public class TarefaDAO {

	private Connection connection;
	private DAOException exception;

	public TarefaDAO() {
		
		this.connection = ConnectionFactory.getConnection();
	}

	public void adiciona(Tarefa tarefa) {
				
		String sql = "INSERT INTO tarefas (descricao) VALUES (?)";
		
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.execute();
			stmt.close();
					
		} catch (SQLException e) {
			
			this.exception.getException(e);
					
		}
	}

	public List<Tarefa> getLista() {
		
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		try {
			
			PreparedStatement stmt = this.connection
					.prepareStatement("SELECT * FROM tarefas ORDER BY id");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto de tarefa
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));

				if (rs.getDate("dataFinalizacao") != null) {
					
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataFinalizacao"));
					tarefa.setDataFinalizacao(data);
					
				}

				// Adiciona tarefas a lista
				tarefas.add(tarefa);
				
			}
			
			rs.close();
			stmt.close();
			
			
		} catch (SQLException e) {
			
			this.exception.getException(e);
						
		}
		
		return tarefas;
		
	}

	public void altera(Tarefa tarefa) {
		
		String sql = "UPDATE tarefas SET " + "descricao = ?,"
				+ "finalizado = ?," + "dataFinalizacao = ? " + "WHERE id = ?";
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao()
					.getTimeInMillis()));
			stmt.setLong(4, tarefa.getId());
			stmt.execute();
			stmt.close();
			
			
		} catch (SQLException e) {
			
			this.exception.getException(e);
						
		}
	}

	public void remove(Long id) {
		
		try {
			
			PreparedStatement stmt = this.connection
					.prepareStatement("DELETE FROM tarefas WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
						
		} catch (SQLException e) {
			
			this.exception.getException(e);
			
		}
	}

	public Tarefa buscaPorId(Long id) {
		
		Tarefa tarefa = new Tarefa();
		
		try {
			
			PreparedStatement stmt = this.connection
					.prepareStatement("SELECT * FROM tarefas WHERE id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto de Tarefa
				// Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));

				
				Calendar data = Calendar.getInstance();
				
				if (rs.getDate("dataFinalizacao") == null) {
					
					data.setTime((java.util.Date)new Date(Long.MIN_VALUE));
					
				} else {
					
					data.setTime(rs.getDate("dataFinalizacao"));
					
				}
								
				tarefa.setDataFinalizacao(data);
							
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			
			this.exception.getException(e);
			
		}
		
		return tarefa;
	}

	public void finaliza(Long id) {
		
		String sql = "UPDATE tarefas SET " + "finalizado = true,"
				+ "dataFinalizacao=? " + "WHERE id = ?";
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setDate(1, (java.sql.Date) new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setLong(2, id);
			stmt.execute();
			stmt.close();
			
			
		} catch (SQLException e) {
			
			this.exception.getException(e);
			
		}
	}

}
