<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%--- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> ---%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Spring 4 MVC -HelloWorld</title>
	
	<spring:url value="/resources/js/helloworld.js" var="mainJs" />
	<script src="${mainJs}"></script>
	 
</head>
<body>
	<center>
		<h1>Index </h1>
		<form>
			<input name="q" class="index-field index-input" type="text"/>
			<input class="index-btn index-input" type="submit" value="Index"/>
		</form>
	</center>
</body>
</html>