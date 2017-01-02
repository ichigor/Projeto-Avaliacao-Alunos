<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
    
<!DOCTYPE html!">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CADASTRO DE ALUNOS</title>
</head>
<body>

<form action="AlunoServlet" method="post">
	<c:choose>
		<c:when test="${aluno.id != null }">
			<h1>Alterar Aluno</h1>
			<input type="hidden" name="opcao" value="alterar" />
			<input type="hidden" name="id" value="${aluno.id}" />
		</c:when>
		<c:otherwise>
			<h1>Adicionar Aluno</h1>
			<input type="hidden" name="opcao" value="inserir" />
		</c:otherwise>
	</c:choose>



	<label for="nome">Nome</label>
	<input name="nome" type="text" value="${aluno.nome}" />
	
	<label for="matricula">Matricula</label>
	<input name="matricula" type="text" value="${aluno.matricula }" />
	
	<label for="dataNasc">Data de Nascimento</label>
	<input name="dataNasc" type="date" />
	
	<label for="dataNasc">Usuario</label>
	<input name="usuario" type="text" />
	<label for="senha">Senha</label>
	<input name="senha" type="password" />
	
	<button type="submit">INSERIR</button>	
</form>
								
			<h2>ALUNOS CADASTRADOS</h2>
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Matricula</th>
					<th>Data Nasc</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Nome</th>
					<th>Matricula</th>
					<th>Data Nasc</th>
					<th>Ações</th>
				</tr>
			</tfoot>
			
			<c:forEach var="aluno" items="${alunos}">
				<tr>
					<td>${aluno.nome}</td>
					<td>${aluno.matricula}</td>
					<td>DATA</td>
					<!-- <td>${aluno.dataNasc}</td> -->
					<td>
					<a 
href="http://localhost:8080/SistemaDeVotacao/AlunoServlet?opcao=excluir&&id=${aluno.id}">
					Excluir</a>
					<a 
href="http://localhost:8080/SistemaDeVotacao/AlunoServlet?opcao=buscar&&id=${aluno.id}"
>Alterar</a>
					</td>
				</tr>
			</c:forEach>
						
			
				
		</table>

</body>
</html>