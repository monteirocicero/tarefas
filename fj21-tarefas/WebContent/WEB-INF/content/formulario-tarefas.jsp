<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tarefas</title>
</head>
<body>

	<h3>Adicionar Tarefas</h3>
	<s:fielderror fieldName = "tarefa.descricao" />
	<form action="adicionaTarefa" method="post">
		Descrição: <br />
		<textarea name="tarefa.descricao" rows="5" cols="100"></textarea> <br />
		<input type="submit" value="Adicionar">
	</form>

</body>
</html>