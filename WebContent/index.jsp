<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	
		<header> Sistema de Votação </header>
		
		<section>
		
			<form action="LoginServlet" method="post">
				<label for="usuario">Aluno</label>				
				<input type="text" name="usuario">
				<label for="senha">Senha</label>
				<input type="password" name="senha">
				<button type="submit">Autenticar</button>
			</form>	
			
		<c:if test="${not empty msgDoServidor}">
			<h2> Usuário ou Senha não cadastrado</h2>
		</c:if>
		
		</section>
		
		
		<br><br>
		<section>
		
			<form action="AdminServlet" method="post">
				<label for="usuario">Professor Admin</label>				
				<input type="text" name="usuario">
				<label for="senha">Senha</label>
				<input type="password" name="senha">
				<button type="submit">Autenticar</button>
			</form>	
			
		<c:if test="${not empty msgDoServidor}">
			<h2> Usuário ou Senha não cadastrado</h2>
		</c:if>
		
		</section>
		<a href="alunosAvaliados.jsp">VER AVALIAÇÕES</a>
		
		<footer>@Projeto Exemplo em Aula</footer>
	
	</body>
</html>