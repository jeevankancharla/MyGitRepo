<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg =(String) request.getAttribute("errmsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	

		<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1> <%= msg %> </h1>	
		
		<%
		}
		%>




<fieldset>
<legend>Login</legend>
<form action="./empLogin"  method="post">

<label>Emp_id</label>
<label>:</label>
<input type = "text" name ="id" >

<br>

<label>Emp_pwd</label>
<label>:</label>
<input type = "password" name ="pwd" >

<br>

<label>Submit</label>
<input type = "submit" value = "Login">



</form>

</fieldset>

</body>
</html>