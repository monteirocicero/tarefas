package br.com.cicero.tarefas.dao;

public class DAOException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void getException(Exception e) {
		
        System.out.println(e.getMessage());
        
	}

}
