<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${dojo.name}</title>
</head>
<body>
	<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dojo.ninjas }" var="ninja">
				<tr>
					<td><c:out value="${ninja.firstName }"/></td>
					<td><c:out value="${ninja.lastName }"/></td>
					<td><c:out value="${ninja.age }"/></td>

					
				</tr>
			</c:forEach>
		</tbody>	
	</table>
<br>
<br>
<br>

<p><a href="/">Go Back</a> || <a href="/ninjas/new">New Ninja</a></p>

</body>
</html>