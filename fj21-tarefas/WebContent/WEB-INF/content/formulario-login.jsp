<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link type="text/css" href="css/estilo.css" rel="stylesheet">
</head>
<body>
	<h2>Página de Login das Tarefas</h2>
	<form action="login" method="post">
		<label for="login">Login:</label> 
		<input id="login" type="text" name="usuario.login"><br />
		
		<label for="senha">Senha:</label> 
		<input id="senha" type="password" name="usuario.senha"><br />
		<input id="submitbutton" type="submit" value="Entrar nas tarefas">
	</form>
</body>
</html>