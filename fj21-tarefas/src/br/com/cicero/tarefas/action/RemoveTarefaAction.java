package br.com.cicero.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.cicero.tarefas.dao.TarefaDAO;
import br.com.cicero.tarefas.model.Tarefa;

public class RemoveTarefaAction {
	
	private Long id;
	
	@Action(value = "removeTarefa", results = {
			@Result(name = "ok", type = "httpheader",
					params = {"status", "200"})
	})
	public String execute() {
		
		new TarefaDAO().remove(id);
		return "ok";
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
