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

					<div class="col-md-12" id="Header">
						<a href="${pageContext.request.contextPath}"><button
								type="button" class="btn btn-primary" data-whatever="@mdo"
								style="width: 20%">Accueil</button></a>
					</div>
					
					<div class="col-md-2" id="Menu"></div>

					<div class="col-md-9" id="Contenu">

						<c:out value="${resultEmail}" />

					</div>

					<%@include file="/resources/template/Footer.jsp"%>

				</div>
			</div>
		</div>
	</div>
</body>
</html>