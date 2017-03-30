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
	<div class="container-fluid">
		<div class="row">
			<div class="container">
				<div class="row">

					<%@include file="/resources/template/Gerant/headerGerant.jsp"%>

					<%@include file="/resources/template/Gerant/MenuConseiller.jsp"%>
					<div class="col-md-9" id="Contenu">
						<form:form method="POST"
							action="${pageContext.request.contextPath}user/soumettreConseiller"
							commandName="command">
							<table>
								<tr>
									<td><form:label path="nom">Nom:</form:label></td>
									<td><form:input path="nom" /></td>
									<td><form:errors path="nom" cssStyle="color:red" /></td>
								</tr>
								<tr>
									<td><form:label path="prenom">Prenom:</form:label></td>
									<td><form:input path="prenom" /></td>
									<td><form:errors path="prenom" cssStyle="color:red" /></td>
								</tr>
								<tr>
									<td><form:label path="password">Mot de passe:</form:label></td>
									<td><form:input path="password" /></td>
									<td><form:errors path="password" cssStyle="color:red" /></td>
								</tr>
								<tr>
									<td><input type="submit" value="ajouter" /></td>
								</tr>
							</table>
						</form:form>
					</div>

					<%@include file="/resources/template/Footer.jsp"%>

				</div>
			</div>
		</div>
	</div>
</body>
</html>