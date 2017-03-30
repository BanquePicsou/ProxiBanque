<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--     Ajout d ela taglib form de spring -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:p="http://primefaces.org/ui"
	xmlns:ui="http://java.sun.com/jsf/facelets">
<head>
<title>Login</title>
<link href="<c:url value="/resources/css/MonStyleSheet.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.2.0.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</head>

<body>
	<div
		style="width: 60%; margin-left: 20%; margin-top: 70px; border: solid #888888 3px; border-radius: 15px; padding: 10px;">
		<div class="container">
			<div>
				<table>
					<tr>
						<td style="width: 100%">
							<h1>Espace sécurisé</h1>
							<h2>Veuillez vous identifier</h2>
						</td>
						<td>
							<img alt="logoSecure" src="resources/img/secure.png"
							width="80px" />
						</td>
					</tr>
				</table>
			</div>

			<br />
			<div class="col-sm-12">
				<form class="form-horizontal" action="j_spring_security_check"
					method="POST">
					<div class="form-group">
						<label for="nom" class="col-sm-2 control-label">Nom</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="nom"
								placeholder="Nom" name="j_username">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="inputPassword3"
								placeholder="Password" name="j_password" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<a href="${pageContext.request.contextPath}"><button
									type="button" class="btn btn-default">Retour</button></a>
							<button type="submit" class="btn btn-default">Connexion</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>