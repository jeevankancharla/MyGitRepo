<%@page import="com.te.springmvc.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file="header.jsp" %>
    <%String msg =(String) request.getAttribute("msg");
    EmployeeBean bean = (EmployeeBean)request.getAttribute("data");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Form</title>
</head>
<body>

<%if(msg !=null && !msg.isEmpty())  {
	%>
	<h1> <%= msg %></h1>
	<%} %>

<form action="./search" method="get">
<label>Emp_id</label>
<label>:</label>
<input type = "text" name = "id"> 
<input type = "submit" value ="search" >
</form>

<%if(bean != null) { %>
<h3>name : <%= bean.getName()  %></h3>
<h3>Id : <%= bean.getId() %></h3>
<h3> DOB : <%= bean.getDob() %></h3>
<%} %>

</body>
</html>