<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html !">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ALUNOS AVALIADOS</title>
</head>
<body>

<jsp:useBean id="dao" class="csi.dao.AlunoDAO"></jsp:useBean>

	<h2>ALUNOS CADASTRADOS</h2>
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
			
			<c:forEach var="aluno" items="${dao.alunos}">
				<tr>
					<td>${aluno.nome}</td>
					<td>${aluno.media}</td>
					 
					</td>
				</tr>
			</c:forEach>
						
			
				
		</table>


</body>
</html>