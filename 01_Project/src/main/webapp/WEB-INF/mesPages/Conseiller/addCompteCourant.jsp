<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Formulaire ajouter compte courant</h2>
	<form:form method="POST" action="${pageContext.request.contextPath}/compte/ajoutCompteCourant"
		commandName="command">
		<table>
			<tr>
				<td>${id}</td>
				<td><form:input path="id" type="hidden" /></td>

			</tr>
			<tr>
				<td><form:label path="numero">numero:</form:label></td>
				<td><form:input path="numero" /></td>
				<td><form:errors path="numero" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="decouvert">decouvert:</form:label></td>
				<td><form:input path="decouvert" /></td>
				<td><form:errors path="decouvert" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td><form:label path="solde">solde:</form:label></td>
				<td><form:input path="solde" /></td>
				<td><form:errors path="solde" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="datecreation">datecreation</form:label></td>
				<td><form:input path="datecreation" /></td>
				<td><form:errors path="datecreation" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="typecompte">type compte</form:label></td>
				<td><form:input path="typecompte" /></td>
				<td><form:errors path="typecompte" cssStyle="color:red" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="soummettre" /></td>

			</tr>
		</table>
	</form:form>


</body>
</html>