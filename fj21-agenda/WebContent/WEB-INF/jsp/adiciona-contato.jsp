<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="dp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Adiciona Contatos</title>
<link href='<c:url value='/css/jquery-ui.min.css' />' rel="stylesheet">
<link href='<c:url value='/css/jquery-ui.structure.min.css' />' rel="stylesheet">
<link href='<c:url value='/css/jquery-ui.theme.min.css' />' rel="stylesheet">
<script src="<c:url value='/js/jquery.js'/>"></script>
<script src="<c:url value='/js/jquery-ui.min.js'/>"></script>
</head>
<body>
<c:import url="cabecalho.jsp" />
	<form action="alteraAdicionaContato">
		<input type="hidden" nome="logica" value="AdicionaAlteraLogic" >
		Nome: <input type="text" name="nome" /><br/>
		E-mail: <input type="text" name="email" /><br/>
		Endere&ccedil;o: <input type="text" name="endereco" /><br/>
		Data Nascimento: <dp:campoData id="dataNascimento" /><br/>

		<input type="submit" value="Gravar"/>
	</form>
<c:import url="rodape.jsp" />
</body>
</html>