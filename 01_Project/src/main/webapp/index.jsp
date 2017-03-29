<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC >
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:p="http://primefaces.org/ui"
	xmlns:ui="http://java.sun.com/jsf/facelets">
	
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="<c:url value="resources/js/jquery-3.2.0.min.js" />"></script>
<script src="<c:url value="resources/js/bootstrap.js" />"></script>
<link href="<c:url value="resources/css/MonStyleSheet.css" />" rel="stylesheet" >
<link href="<c:url value="resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css">
	
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="container" style="background-color: red;">
				<div class="row">
					<div class="col-md-12" id="Header">
					<h1>Ceci est le Header</h1>
					</div>
					
					<div class="col-md-4" id="Menu"> <h1>Je suis le Menu</h1></div>
					
					<div class="col-md-6" id="Contenu"> <h1>Je suis le Contenu</h1></div>
					
					<div class="col-md-12" id="Footer"> <h1>Je suis le Footer</h1> </div>
					
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>