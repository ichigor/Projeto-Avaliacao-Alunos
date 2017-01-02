<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html !>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FAZER AVALIAÇÃO</title>
</head>
<body>
	<h2>Olá : ${logado.nome}</h2>
	<form action="AvaliacaoServlet" method="post">
	<label for="idAlunoAvaliado">Avaliar o aluno: </label>
	 <label for = "idAlunoAvaliado">${avaliar.nome}</label>
	 <input name="idAlunoAvaliado" type="hidden" value="${avaliar.id}" />
	<br>
	<label for="comentario">Comentário</label>
	<textarea rows="4" cols="50" name="comentario"></textarea>
	
	<label for="nota">Nota</label>
	<input name="nota" type="number" min="1" max="100" required="required" />
	
	
	<input name="idAlunoAvaliador" type="hidden" value="${logado.id}" />
	
	<button type="submit">AVALIAR</button>
		
	</form>

		<c:if test="${not empty msgDoServidor}">
			<h2> Não é permitido se auto-avaliar</h2>
		</c:if>
		<c:if test="${not empty msg}">
			<h2>Você já avaliou esse Aluno</h2>
		</c:if>

</body>
</html>