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
<h2>Formulaire ajouter compte epargne</h2>
	<form:form method="POST" action="${pageContext.request.contextPath}/compte/ajoutCompteEpargne"
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
				<td><form:label path="datecreation">datecreation</form:label></td>
				<td><form:input path="datecreation" type="date"/></td>
				<td><form:errors path="datecreation" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="soummettre" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>