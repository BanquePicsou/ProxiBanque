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

<body background= <c:url value="/resources/img/374215-alexfas01.jpg"/> >
	<div class="container-fluid">
		<div class="row">
		
			<%@include file="/resources/template/Banner.jsp"%>
		
			<div class="container">
				<div class="row">
				
					<%@include file="/resources/template/Conseiller/headerConseiller.jsp"%> 
					
				
					<%@include
							file="/resources/template/Conseiller/MenuCompteEpargne.jsp"%>
					

					<div class="col-md-9" id="Contenu">
							<h2>Formulaire ajouter compte epargne</h2>
	<form:form method="POST" action="${pageContext.request.contextPath}/compte/soumettreCompteEpargne"
		commandName="command">
		<table>
			<tr>
				<td>${command.id}</td>
				<td><form:input path="id" type="hidden" /></td>
			</tr>
			<tr>
				<td><form:label path="numero">numero:</form:label></td>
				<td><form:input path="numero" /></td>
				<td><form:errors path="numero" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="taux">taux:</form:label></td>
				<td><form:input path="taux" /></td>
				<td><form:errors path="taux" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td><form:label path="solde">solde:</form:label></td>
				<td><form:input path="solde" /></td>
				<td><form:errors path="solde" cssStyle="color:red" /></td>
			</tr>
		<tr>
				<td><form:label path="client">client:</form:label></td>
				<form:select path="client.id" id="client">
					<c:forEach var="c" items="${clientListe}">
					<form:option value="${c.id}">${c.nom}</form:option>
					</c:forEach>
				</form:select>
				<td><form:errors path="client" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="soummettre" /></td>
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
