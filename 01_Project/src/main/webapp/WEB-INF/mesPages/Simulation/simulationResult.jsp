<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--     Ajout de la taglib form de spring -->
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

<body background="./../resources/img/374215-alexfas01.jpg">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12" id="banner">
				<h1>Chaque centime est un pas vers le milliard</h1>
			</div>
			<img src="./../resources/img/1947-balthazar-picsou-00.png"
				id=Portrait>
			<div class="container">
				<div class="row">

					<%@include
						file="/resources/template/Conseiller/headerConseiller.jsp"%>

					<div class="col-md-2" id="Menu">

						<h1>Je suis le Menu</h1>




					</div>

					<div class="col-md-9" id="Contenu">
						<div>
							Emprunt pour M./Mme
							<c:out value="${client.nom}"></c:out>
							<br /> d'un montant de
							<c:out value="${montant}"></c:out>
							€<br />
							<c:out value="${nbEch}"></c:out>
							échéances par an pendant
							<c:out value="${duree}"></c:out>
							ans
						</div><br/><a href="${pageContext.request.contextPath}/simul/simulClient"><button
						type="button" class="btn btn-primary" data-whatever="@mdo">Nouvelle simulation</button></a><br/>
						<div>
							<table class="table">
								<thead>
									<tr>
										<td>#</td>
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
						</div>
					</div>

					<%@include file="/resources/template/Footer.jsp"%>

				</div>
			</div>
		</div>
	</div>

</body>
</html>
