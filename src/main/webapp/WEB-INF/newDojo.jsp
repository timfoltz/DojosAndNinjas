<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dojos }" var="dojo">
				<tr>
					<td><c:out value="${dojo.id }"/></td>
					<td><a href="/dojos/${dojo.id}"><c:out value="${dojo.name }"/></a></td>

					
				</tr>
			</c:forEach>
		</tbody>	
	</table>
<h1>New Dojo</h1>
<form:form action="/dojos" method="post" modelAttribute="dojo">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input required="true" path="name"/>
    </p>

    <input type="submit" value="Submit"/>
</form:form>
<a href="/ninjas/new">New Ninja</a>
</body>
</html>