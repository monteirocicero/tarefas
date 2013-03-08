package br.com.cicero.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class OlaMundoAction {

	@Action(value = "olaMundoStruts", results = { 
			@Result(location = "olaMundoStruts.jsp", name = "ok") 
	})
	public String execute() {
		
		System.out.println("Executando a lógica com Struts2");
		return "ok";
		
	}

}
