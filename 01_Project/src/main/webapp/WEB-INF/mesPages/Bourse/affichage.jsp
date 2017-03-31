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
	<div>
		<h1>Bourse</h1>
	</div>
	<div>
		<form>
			<div class="form-group">
				<select name="indice" id="indice" class="form-group" onChange="this.form.submit()" style="width: 250px">
					<c:forEach items="${listeIndices}" var="ind">
						<option value="${ind[0]}">${ind[1]}</option>
					</c:forEach>
				</select>
			</div>
		</form>
		Nom :
		<c:out value="${nom}"></c:out>
		<br /> Change Percent :
		<c:out value="${changePercent}"></c:out>
		<br /> Day High :
		<c:out value="${dayHigh}"></c:out>
		<br /> Day Low :
		<c:out value="${dayLow}"></c:out>
		<br /> Stock Change :
		<c:out value="${stockChange}"></c:out>
		<br /> Stock Volume :
		<c:out value="${stockVolume}"></c:out>
		<br />
	</div>

</body>
</html>