<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="dp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Altera Contatos</title>
<link href='<c:url value='/css/jquery-ui.min.css' />' rel="stylesheet">
<link href='<c:url value='/css/jquery-ui.structure.min.css' />' rel="stylesheet">
<link href='<c:url value='/css/jquery-ui.theme.min.css' />' rel="stylesheet">
<script src="<c:url value='/js/jquery.js'/>"></script>
<script src="<c:url value='/js/jquery-ui.min.js'/>"></script>
</head>
<body>

<c:import url="cabecalho.jsp" />



	<form action="alteraAdicionaContato">
		 <input type="hidden" name="id" value="${contatos.id}">
		Nome: <input type="text" name="nome" value="${contatos.nome }"/><br/>
		E-mail: <input type="text" name="email" value="${contatos.email }"/><br/>
		Endere&ccedil;o: <input type="text" name="endereco" value="${contatos.endereco }"/><br/>
		Data Nascimento: <input type="text" name="dataNascimento"  value="<fmt:formatDate value="${contatos.dataNascimento.time }" pattern="dd/MM/yyyy" />"/><br/>
		<input type="submit" value="Gravar"/>
	</form>



<c:import url="rodape.jsp" />
</body>
</html>