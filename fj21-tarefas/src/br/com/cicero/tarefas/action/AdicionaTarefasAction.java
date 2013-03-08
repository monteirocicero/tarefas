package br.com.cicero.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.cicero.tarefas.dao.TarefaDAO;
import br.com.cicero.tarefas.model.Tarefa;

public class AdicionaTarefasAction {
	
	private Tarefa tarefa;
	
	@Action(value = "adicionaTarefa", results = {
			@Result(name = "ok", location = "tarefa-adicionada.jsp")
	})
	public String execute() {
		
		new TarefaDAO().adiciona(tarefa);
		
		return "ok";
		
	}
	
	public Tarefa getTarefa() {
		return tarefa;
	}
	
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

}
