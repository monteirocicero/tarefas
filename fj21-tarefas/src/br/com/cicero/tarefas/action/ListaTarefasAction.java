package br.com.cicero.tarefas.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.cicero.tarefas.dao.TarefaDAO;
import br.com.cicero.tarefas.model.Tarefa;

public class ListaTarefasAction {
	
	private List<Tarefa> tarefas;
	
	@Action(value = "listaTarefas", results = {
			@Result(name = "ok", location = "lista-tarefas.jsp")
	})
	public String execute() {
		
		this.tarefas = new TarefaDAO().getLista();
		
		return "ok";
		
	}
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	
}
