<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Conseillers</title>
</head>
<body>
	<table cellspacing="0" cellpadding="6" border="1" width="60%">
		<tr bgcolor="grey" style="color: white;">
			<th>id</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Mdp</th>

		</tr>
		<c:forEach var="cons" items="${consListe}">
			<tr bgcolor="lightyellow">
				<td>${cons.id}</td>
				<td>${cons.nom}</td>
				<td>${cons.prenom}</td>
				<td>***********</td>
			</tr>

		</c:forEach>
</body>
</html>