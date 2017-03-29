<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<body background="/resources/img/374215-alexfas01.jpg">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12" id="banner">
				<h1>Chaque centime est un pas vers le milliard</h1>
			</div>
			<div class="container">
				<div class="row">

					<%@include file="/resources/template/BigBoss/headerBigBoss.jsp"%>

					<div class="col-md-2" id="Menu">
						<div></div>
						<h1>Je suis le Menu</h1>
					</div>

					<div class="col-md-9" id="Contenu">
						<h1>Je suis le Contenu</h1>
							<form:form method="POST"
								action="${pageContext.request.contextPath}/user/soumettreGerant"
								commandName="command">
							<table class="formAjout">

								<tr>
									<td><label> Nom </label></td>
									<td><input name="nom" /></td>
								</tr>
								<tr>
									<td><label>Prenom</label></td>
									<td><input name="prenom" /></td>
								</tr>
								<tr>
									<td><label>Password</label></td>
									<td><input name="password" /></td>
								</tr>
							</table>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Ajout
									Gerant</button>
							</div>

						</form:form>
					</div>

					<div class="col-md-12" id="Footer">
						<h1>Je suis le Footer</h1>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>