<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div style="width:50%;margin:auto;text-align:center;">
		<p>Vous avez saisi : </p>
		<ul>
			<li>Nom : <%=request.getParameter("nom").toUpperCase() %></li>
			<li>Prénom : <%=request.getParameter("prenom").toUpperCase() %></li>
		</ul>
		
		<p>Pour retourner au formulaire, c'est <a href="form">par ici</a></p>
	</div>

</body>
</html>