<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="metier.Utilisateur"%>
<%@ page import="bean.LocVideoBean"%>
<%@ page import="java.util.List"%>
<%@ page import="metier.Video"%>
<%@ page import="metier.Historique"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Historique</title>
<link rel="stylesheet" media="screen" href="STYLE/CSS/style.css">
<%
Utilisateur Uti = (Utilisateur)session.getAttribute("uti");
if (Uti == null)
{
	%> <jsp:forward page="/connexion.html" /> <%
}

List<Historique> mesVideoLouer ;
mesVideoLouer = LocVideoBean.getInstance().getHistorique(Uti.getId());

%>
</head>
<body>
<div id="header">
		<h1><% out.print("Poney Vidéos");%></h1>
		<h2><% out.print("Les vidéos qui envoient du poneys");%></h2>
</div>
<p> HISTORIQUEEEE</p>
<table>
	<tr>
		<th>Date</th>
		<th>Film</th>
	</tr>
	<% 
	if(mesVideoLouer != null)
	{
		for(int i = 0; i < mesVideoLouer.size(); i++)
		{
			Historique maVideo = mesVideoLouer.get(i);%>
			<tr>
			<td><%out.print(maVideo.getdateVisu()); %></td>
			<td><a href="detailVideo.html?id=<%out.print(maVideo.getid()); %>" ><%out.print(maVideo.getVideo()); %></a></td>
		</tr>
		<% }	
	}%>
</table>
</body>
</html>