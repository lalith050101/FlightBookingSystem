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
	response.setHeader("cache-control", "no-cache,no-store,must-revalidate"); ///works after: HTTP 1.1   
	
	response.setHeader("pragma","no-cache"); //HTTP 1.0
	
	response.setHeader("Expires","0"); //Proxies
	
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("home.jsp");
	}
%>
Welcome user! ${username}
<form action="logout">
	<input type="submit" value="Logout">
</form>
</body>
</html>