<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--     Ajout d ela taglib form de spring -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC >
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:p="http://primefaces.org/ui"
	xmlns:ui="http://java.sun.com/jsf/facelets">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="<c:url value="resources/js/jquery-3.2.0.min.js" />"></script>
<script src="<c:url value="resources/js/bootstrap.js" />"></script>
<link href="<c:url value="resources/css/MonStyleSheet.css" />"
	rel="stylesheet">
<link href="<c:url value="resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css">

</head>

<body>
	<c:out value="${client}"></c:out>
	<c:out value="${montant}"></c:out>
	<table>
		<thead>
			<tr>
				<td>Intérêts</td>
				<td>Capital remboursé</td>
				<td>Capital restant à rembourser</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${resulatSimul}" var="ligne">
				<tr>
					<c:forEach items="${ligne}" var="col">
						<td><c:out value="${col}"></c:out></td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>