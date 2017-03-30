<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Liste des comptes courants</h1>
<table cellspacing="0" cellpadding="6" border="1" width="60%">
<tr bgcolor="grey" style="color: white;">
<th>numero</th>
<th>decouvert</th>
<th>solde</th>
<th>datecreation</th>
<th>Supp/Edit</th>

</tr>
<c:forEach var="emp" items="${ccListe}">
<tr bgcolor="lightyellow">
<td>${emp.numero}</td>
<td>${emp.decouvert}</td>
<td>${emp.solde}</td>
<td>${emp.datecreation}</td>
<td><a href="supprimerCC?id_param=${emp.id}">supp</a>|<a href="afficherModifCC?id_param=${emp.id}">Edit</a></td>
</tr>

</c:forEach>

</table>
</body>
</html>