<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.Enumeration, java.text.SimpleDateFormat, java.util.Date" %>
<html>
	<body>
		<% out.println("<h1>Nous sommes le : " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + "</h1>"); %>
		<h1>il est : <%=new SimpleDateFormat("HH:mm:ss").format(new Date()) %></h1>
		
		<%
		//Nous allons récupérer les en-têtes 
		Enumeration e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String element = e.nextElement().toString();
			out.println("<pre>" + element + " : " + request.getHeader(element) + "</pre>");	
		}
		%>
	</body>
</html>