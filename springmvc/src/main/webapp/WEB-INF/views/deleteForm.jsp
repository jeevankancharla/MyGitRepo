<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file="header.jsp" %>
    <% String msg = (String)request.getAttribute("msg") ;  
    String data = (String)request.getAttribute("data") ;
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Emp </title>
</head>
<body>
	
	<%if(data !=null && !data.isEmpty())  {
	%>
	<h1> <%= data %></h1>
	<% } %>
	
	<%if(msg !=null && !msg.isEmpty())  {
	%>
	<h1> <%= msg %></h1>
	<% } %>
	

<form action="./delete" method="get">
<label>Emp_id</label>
<label>:</label>
<input type = "text" name ="id" >

<input type = "submit" value = "Delete">

</form>

</body>
</html>