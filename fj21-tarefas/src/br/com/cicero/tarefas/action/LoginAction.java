package br.com.cicero.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

import br.com.cicero.tarefas.dao.UsuarioDAO;
import br.com.cicero.tarefas.model.Usuario;

public class LoginAction {
	
	private Usuario usuario;
	
	@Action(value = "login", results = {
			@Result(name = "ok", location="menu.jsp"),
			@Result(name = "invalido", location="formulario-login.jsp")
	})
	public String login() {
		
		if (new UsuarioDAO().existeUsuario(usuario)) {
			
			ActionContext.getContext().getSession().put("usuarioLogado", usuario);
			return "ok";
			
		}
		
		return "invalido";
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
