<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Person</title>
</head>
<body>
<h1>New Person</h1>
<form:form action="/ninjas" method="post" modelAttribute="ninja">
	<form:select path="dojo">
	        <c:forEach items="${dojos }" var="dojo">
					<form:option value="${dojo}">
						<c:out value="${dojo.name}"/> 
							
					</form:option>
				</c:forEach>
        </form:select>
    <p>
        <form:label path="firstName">First Name</form:label>
        <form:errors path="firstName"/>
        <form:input required="true" path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:input required="true" path="lastName"/>
    </p>
    <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age"/>
        <form:input required="true" path="age"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>