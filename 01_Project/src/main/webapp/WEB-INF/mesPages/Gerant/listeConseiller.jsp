<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC >
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:p="http://primefaces.org/ui"
	xmlns:ui="http://java.sun.com/jsf/facelets">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Conseillers</title>
<script src="<c:url value="/resources/js/jquery-3.2.0.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<link href="<c:url value="/resources/css/MonStyleSheet.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css">

</head>
<body background=<c:url value="/resources/img/374215-alexfas01.jpg"/>>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/resources/template/Banner.jsp"%>
			<div class="container">
				<div class="row">

					<%@include file="/resources/template/Gerant/headerGerant.jsp"%>

					<%@include file="/resources/template/Gerant/MenuConseiller.jsp"%>

					<div class="col-md-9" id="Contenu">

						<h1>Liste des conseillers</h1>
						<table cellspacing="0" cellpadding="6" border="1" width="60%">
							<tr bgcolor="grey" style="color: white;">
								<th>id</th>
								<th>Nom</th>
								<th>Prenom</th>
								<th>Mdp</th>

							</tr>
							<c:forEach var="cons" items="${liste}">
								<tr bgcolor="lightyellow">
									<td>${cons.id}</td>
									<td>${cons.nom}</td>
									<td>${cons.prenom}</td>
									<td>***********</td>
								</tr>

							</c:forEach>
						</table>
					</div>
					<%@include file="/resources/template/Footer.jsp"%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>