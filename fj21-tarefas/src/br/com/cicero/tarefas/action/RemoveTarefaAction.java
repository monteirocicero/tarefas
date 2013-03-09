package br.com.cicero.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.cicero.tarefas.dao.TarefaDAO;
import br.com.cicero.tarefas.model.Tarefa;

public class RemoveTarefaAction {
	
	private Tarefa tarefa;
	
	@Action(value = "removeTarefa", results = {
			@Result(name = "ok", type = "redirectAction",
					params = {"actionName", "listaTarefas"})
	})
	public String execute() {
		
		new TarefaDAO().remove(tarefa.getId());
		return "ok";
		
	}
	
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public Tarefa getTarefa() {
		return tarefa;
	}

}
