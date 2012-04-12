<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="metier.Video"%>
<%@ page import="bean.LocVideoBean"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="metier.Support"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
String idVideo = request.getParameter("id");
Video maVideo = LocVideoBean.getInstance().getVideo(Integer.parseInt(idVideo));
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><% out.print(maVideo.getNom());%></title>
<link rel="stylesheet" media="screen" href="STYLE/CSS/style.css">
</head>
<body>
<div id="header">
		<h1><% out.print("Poney Vidéos");%></h1>
		<h2><% out.print("Les vidéos qui envoient du poneys");%></h2>
	</div>

<div id="titre">
	<h1><img src="STYLE/images/icone-connexion.png" /><% out.print(maVideo.getNom());%></h1>
</div>

<div id="conteneur">
	<form name="connexion" action="acceuil.jsp" method="post">
	<table><tr>
			<td><img src="<%out.print(maVideo.getImage()); %>" width=150px height=210px/></td>
			<td><% out.print(maVideo.getNom());%></td>
			<td><% out.print(maVideo.getDescription());%></td>
			<td><% out.print(maVideo.getCategorie().getNom());%></td>
			<td><%	
				if(maVideo.getSupports() != null)
				{
					String sups = new String();
					Iterator<Support> it= maVideo.getSupports().iterator();
					while (it.hasNext()) 
					{
						Support sup = (Support) it.next();
						sups += (sup.getLibelle() + ", ");
					}
					out.print(sups);
				}	%>
				</td>
		</tr></table>
	</form>
</div>
</body>
</html>