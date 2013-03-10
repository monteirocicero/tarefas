package br.com.cicero.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import br.com.cicero.tarefas.dao.TarefaDAO;

@ParentPackage("default")
public class FinalizaTarefaAction {
	
	private Long id;
	
	@Action(value = "finalizaTarefa", results = {
			@Result(name = "ok", type = "httpheader", params = {"status", "200"})
	}, interceptorRefs = {
			@InterceptorRef("seguranca")
	})
	public String execute() {
		
		new TarefaDAO().finaliza(id);
		return "ok";
		
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
}
