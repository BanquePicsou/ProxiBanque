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
<body background=<c:url value="/resources/img/374215-alexfas01.jpg"/>>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/resources/template/Banner.jsp"%>
			<div class="container">
				<div class="row">

					<%@include file="/resources/template/BigBoss/headerBigBoss.jsp"%>

					<%@include file="/resources/template/BigBoss/MenuAgence.jsp"%>

					<div class="col-md-9" id="Contenu">

						<h1>Liste des Agences</h1>
						<table class="table table-hover">
							<tr bgcolor="grey" style="color: white;">
								<th>Identifiant</th>
								<th>Date de Création</th>
								<th>Gérant</th>
								<th>Modifier</th>
								<th>Supprimer</th>

							</tr>
							<c:forEach var="agence" items="${agenceListe}">
								<tr bgcolor="lightyellow">
									<td>${agence.identifiant}</td>
									<td>${agence.datecreation}</td>
									<td>${agence.gerant.nom}</td>
									<td><a
										href="${pageContext.request.contextPath}/admin/agence/updateAgence/${agence.id}">Modifier
											</button>
									</a></td>
									<td><a
										href="${pageContext.request.contextPath}/admin/agence/deleteAgence/${agence.id}">Supprimer
											</button>
									</a></td>
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