<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
String name =(String) request.getAttribute("name");
int pwd = (int) request.getAttribute("pwd");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<h1>
Name : <%= name %>
<br>
<hr>
</h1>

<h1>
passowrd : <%= pwd %>

</h1>

</body>
</html>