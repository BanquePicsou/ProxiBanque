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
	<form:form method="POST"
		action="${pageContext.request.contextPath}/user/updateConseiller"
		commandName="command">
		<table>
			<tr>
				<td><form:label path="id">Id:</form:label></td>
				<td><form:input path="id" /></td>
				<td><form:errors path="id" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="nom">Nom:</form:label></td>
				<td><form:input path="nom" /></td>
				<td><form:errors path="nom" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="prenom">Prenom:</form:label></td>
				<td><form:input path="prenom" /></td>
				<td><form:errors path="prenom" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="mdp">Mot de passe:</form:label></td>
				<td><form:input path="mdp" /></td>
				<td><form:errors path="mdp" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Mettre � jour les donn�es" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>