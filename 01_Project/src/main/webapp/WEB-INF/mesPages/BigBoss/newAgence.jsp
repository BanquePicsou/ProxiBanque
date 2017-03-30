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
<body background="/resources/img/374215-alexfas01.jpg">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12" id="banner">
				<h1>Chaque centime est un pas vers le milliard</h1>
			</div>
			<div class="container">
				<div class="row">

					<%@include file="/resources/template/BigBoss/headerBigBoss.jsp"%>

					<%@include file="/resources/template/BigBoss/MenuAgence.jsp"%>

					<div class="col-md-9" id="Contenu">
						<h1>Ajout d'une agence</h1>
						<form:form method="POST"
							action="${pageContext.request.contextPath}/admin/agence/soumettreAjouterAgence"
							commandName="command">
							<table class="formAjout">

								<tr>
									<td><label>Identifiant :</label></td>
									<td><input name="identifiant" /></td>
								</tr>
								<!-- 								<tr> -->
								<!-- 									<td><label>date creation</label></td> -->
								<!-- 									<td><input type="date" name="datecreation"/></td> -->
								<!-- 								</tr> -->

								<tr>
									<td><label>Gérant : </label></td>
									<td><form:select name="gerant" path="gerant">
											<c:forEach items="${gerants}" var="g">
												<form:option value="${g}">${g.nom}</form:option>
											</c:forEach>
										</form:select></td>
								</tr>

							</table>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Ajout
									Agence</button>
							</div>

						</form:form>
					</div>

					<%@include file="/resources/template/Footer.jsp"%>

				</div>
			</div>
		</div>
	</div>
</body>
</html>