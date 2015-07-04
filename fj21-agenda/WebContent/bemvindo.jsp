<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<%-- comentário em JSP aqui: nossa primeira página JSP --%>

	<%
		String mensagem = "Bem vindo ao sistema de agenda do FJ-21";
	%>
	<% out.println(mensagem); %>

	<br />

	<%
		String desenvolvido = "Desenvolvido por (Marco Antonio Ingrund Ferrari)";
	%>
	<%= desenvolvido %>

	<br />

	<%

		System.out.println("Tudo foi executado!");

	%>
</body>
</html>