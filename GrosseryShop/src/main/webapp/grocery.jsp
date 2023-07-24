<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% double bill=(double)request.getAttribute("bill"); %>
	<h1>Total Bill = <%=bill %></h1>
</body>
</html>