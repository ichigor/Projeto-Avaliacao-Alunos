<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Página principal</h1>
	<h2>Olá : ${logado.nome}</h2>
	<ul>
		<li>
			<a href="principalServlet?opcao=aluno">Aluno</a>
		</li>
		<li>
			<a href="principalServlet?opcao=avaliacao">Avaliacao</a>
		</li>
		<li>
			<a href="alunosAvaliados.jsp">VER AVALIAÇÕES</a>
		</li>
		<li>
			<a href="principalServlet?opcao=logout">LOGOUT</a>
		</li>
	</ul>		
	<h2>Média : ${logado.media}</h2>
	<h2>AVALIAÇÕES</h2>
		<table>
			<thead>
				<tr>
					<th>NOTA</th>
					<th>COMENTÁRIO</th>					
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>NOTA</th>
					<th>COMENTÁRIO</th>		
				</tr>
			</tfoot>
			
			<c:forEach var="avaliacao" items="${logado.avaliado}">
				<tr>
					<td>${avaliacao.nota}</td>
					<td>${avaliacao.comentario}</td>					 
					</td>
				</tr>
			</c:forEach>											
		</table>
</body>
</html>