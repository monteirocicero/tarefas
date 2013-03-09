<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Tarefas</title>
<script type="text/javascript" src="<c:url value="js/jquery.js"/>"></script>
<script type="text/javascript">
	function finalizaAgora(id) {
		$.post("finalizaTarefa", {'id': id}, function(){
			$("#tarefa_"+id).html("Tarefa finalizada");
		});
	}
</script>
</head>
<body>

	<a href="tarefaForm">Criar nova tarefa</a>

	<br />
	<br />

	<table>
		<tr>
			<th>ID</th>
			<th>Descrição</th>
			<th>Finalizado?</th>
			<th>Data de finalização</th>
			<th>Ação</th>
		</tr>
		<c:forEach items="${tarefas}" var="tarefa">
			<tr>
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
				<c:if test="${tarefa.finalizado eq false}">
					<td id="tarefa_${tarefa.id}">
						<a href="#" onclick="finalizaAgora(${tarefa.id})">
							Finaliza agora!
						</a>
					</td>
				</c:if>
				<c:if test="${tarefa.finalizado eq true}">
					<td>Finalizado</td>
				</c:if>
				<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="removeTarefa?tarefa.id=${tarefa.id}">Remover</a> |
					<a href="mostraTarefa?tarefa.id=${tarefa.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>