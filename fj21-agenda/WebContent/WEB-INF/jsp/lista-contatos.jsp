<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="disp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="cabecalho.jsp"></c:import>

	<disp:table  name="${contatos}">
		<disp:column property="id" />
	    <disp:column property="nome" />
	    <disp:column property="email" />
	    <disp:column property="endereco" />
	    <disp:column property="dataNascimento.time" format="{0,date,dd/MM/yyyy}" />
	</disp:table>

<table>
		<c:forEach var="contato" items="${contatos}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
					<td>${contato.nome }</td>
					<td>
					<!--
						<c:if test="${not empty contato.email }">
							<a href="mailto:${contato.email }">${contato.email }</a>
						</c:if>
					 -->
						<c:choose>
							<c:when test="${not empty contato.email }">
								<a href="mailto:${contato.email }">
									${contato.email }
								</a>
							</c:when>
							<c:otherwise>
								Email não informado
							</c:otherwise>
						</c:choose>
					</td>
					<td>${contato.endereco }</td>
					<td><fmt:formatDate value="${contato.dataNascimento.time }" pattern="dd/MM/yyyy" /></td>
					<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id }">Remover</a></td>
					<td><a href="mvc?logica=PreparaAlteraLogic&id=${contato.id }">Alterar</a></td>
				</tr>
		</c:forEach>
</table>
<c:import url="rodape.jsp"></c:import>
</body>
</html>