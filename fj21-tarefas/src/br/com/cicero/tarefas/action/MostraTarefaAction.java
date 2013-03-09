package br.com.cicero.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.cicero.tarefas.dao.TarefaDAO;
import br.com.cicero.tarefas.model.Tarefa;

public class MostraTarefaAction {
	
	private Tarefa tarefa;
	
	@Action(value = "mostraTarefa", results = {
			@Result(name = "ok", location = "mostra-tarefa.jsp")			
	})
	public String execute() {
		
		TarefaDAO dao = new TarefaDAO();
		this.tarefa = dao.buscaPorId(this.tarefa.getId());
		
		return "ok";
		
	}
	
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public Tarefa getTarefa() {
		return tarefa;
	}

}
