<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
    
<!DOCTYPE html!">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Professor</title>
</head>
<body>
	<form action="ProfessorServlet" method="post">									
			<h2>ALUNOS NAO AVALIADOS</h2>
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Matricula</th>
					<th>Opcao</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Nome</th>
					<th>Matricula</th>
					<th>Opcao</th>
				</tr>
			</tfoot>
			
			<c:forEach var="aluno" items="${alunosNaoAvaliados}">
				<tr>
					<td>${aluno.nome}</td>
					<td>${aluno.matricula}</td>
					<td><button type="submit" name="alunoAvaliado" value="${aluno.id}">INSERIR</button></td>
				</tr>
			</c:forEach>
			<input type="radio" name="avaliacao" value="liberado"> Liberadas<br>
	  		<input type="radio" name="avaliacao" value="fechado"> Fechadas<br>
		</table>
			
	</form>
		<h2>Media Alunos</h2>
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Média</th>
										
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Nome</th>
					<th>Média</th>	
				</tr>
			</tfoot>
			
			<c:forEach var="aluno" items="${alunos}">
				<tr>
					<td>${aluno.nome}</td>
					<td>${aluno.media}</td> 

				</tr>
			</c:forEach>
						
			
				
		</table>

</body>
</html>