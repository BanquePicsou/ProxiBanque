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
<h2>Formulaire suppression</h2>

	<form:form method="POST" action="supprimerCompte"
	commandName="command">
		<table>
		
			<tr>
				<td><form:label path="id">Id compte:</form:label></td>
				<td><form:input path="id" /></td>
				<td><form:errors path="id" cssStyle="color:red" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="soummettre" /></td>

			</tr>
		</table>
	</form:form>
</body>
</html>