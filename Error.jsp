<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Error</title>
</head>
<body>
	<center>
		<h1><strong>Error: Something Went Wrong!</strong></h1><br>
		<h2>You caused a <strong><%=exception.getMessage() %>></strong> on the server.<br></h2>
	</center>	
</body>
</html>