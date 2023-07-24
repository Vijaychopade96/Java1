<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	

     <% 
    String cabtype=(String)request.getAttribute("cabtype");
    double km=(double)request.getAttribute("km");
    double billAmt=(double)request.getAttribute("billAmt");
     %>
     
    	<center>
    	<h1>Thank You for using our Cab Service</h1>
    	<h1>Total Run of Cab = <%=km%></h1>
        <h1>Type of cab = <%=cabtype%></h1>
        <h1>Total Bill Amount = <%=billAmt%></h1>
    	</center>
    
</body>
</html>