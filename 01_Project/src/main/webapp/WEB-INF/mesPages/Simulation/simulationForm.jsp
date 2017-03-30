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
<script src="<c:url value="/resources/js/jquery-3.2.0.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<link href="<c:url value="/resources/css/MonStyleSheet.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css">

</head>

<body>

	<form:form method="POST"
		action="${pageContext.request.contextPath}/simul/soumettreSimulClient"
		commandName="clientForm" cssStyle="form-horizontal">

		<div class="form-group">
			<label for="inputNom" class="col-sm-2 control-label">Nom</label>
			<div class="col-sm-10">
				<form:select path="id" id="inputNom">
					<c:forEach items="${listeClient}" var="cl">
						<form:option value="${cl.id}">${cl.nom}</form:option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="form-group">
			<label for="montant" class="col-sm-2 control-label">Montant
				du prêt</label>
			<div class="col-sm-10">
				<input type="number" id="montant" name="pMontant" />
			</div>
		</div>
		<div class="form-group">
			<label for="duree" class="col-sm-2 control-label">Durée du
				prêt (en années)</label>
			<div class="col-sm-10">
				<input type="number" id="duree" name="pDuree" />
			</div>
		</div>
		<div class="form-group">
			<label for="nbEch" class="col-sm-2 control-label">Nombre
				d'échéances par an</label>
			<div class="col-sm-10">
				<input type="number" id="nbEch" name="pNbEch" />
			</div>
		</div>
		<input type="submit" value="Valider" />
	</form:form>

</body>
</html>