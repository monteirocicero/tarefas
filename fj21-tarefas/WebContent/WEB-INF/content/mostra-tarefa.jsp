<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="util" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mostra Tarefa</title>
<link type="text/css" href="css/ui-lightness/jquery-ui.css"
	rel="stylesheet" />
<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>
</head>
<body>
	<h3>Alterar tarefa - ${tarefa.id}</h3>
	<form action="alteraTarefa" method="post">
	
		<input type="hidden" name="tarefa.id" value="${tarefa.id}">
		
		Descrição: <br />
		<textarea name="tarefa.descricao" rows="5" cols="100">
			${tarefa.descricao}
		</textarea>
		
		<br />
		
		Finalizado? <input type="checkbox" name="tarefa.finalizado"
			value="true" ${tarefa.finalizado?'checked':''}> <br />
		
		Data de finalização: <br />
		<util:campoData id="tarefa.dataFinalizacao" name="tarefa.dataFinalizacao" value="">
		</util:campoData>
				
		<br />
		
		<input type="submit" value="Alterar">
			
		
	</form>
</body>
</html>