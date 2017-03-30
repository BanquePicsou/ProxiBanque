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

	<form:form method="POST"
		action="${pageContext.request.contextPath}/simul/soumettreSimulClient"
		commandName="clientForm">

		<form:select path="id">
			<c:forEach items="${listeClient}" var="cl">
				<form:option value="${cl.id}">${cl.nom}</form:option>
			</c:forEach>
		</form:select>

<label for="montant">Montant du prêt</label>
		<input type="number" id="montant" name="pMontant" />
		
<label for="duree">Durée du prêt (en années)</label>
		<input type="number" id="duree" name="pDuree" />
		
		<label for="nbEch">Nombre d'échéances par an</label>
		<input type="number" id="nbEch" name="pNbEch" />
		
		<input type="submit" value="Valider" />
	</form:form>

</body>
</html>