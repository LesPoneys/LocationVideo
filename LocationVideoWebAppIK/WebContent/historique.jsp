<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="metier.Utilisateur"%>
<%@ page import="bean.LocVideoBean"%>
<%@ page import="java.util.List"%>
<%@ page import="metier.Video"%>
<%@ page import="metier.Location"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Comparator"%>
<%@ page import="java.text.DateFormat"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Historique</title>
<link rel="stylesheet" media="screen" href="STYLE/CSS/styleConnected.css">
<%
Utilisateur Uti = (Utilisateur)session.getAttribute("uti");
if (Uti == null)
{
	%> <jsp:forward page="/connexion.html" /> <%
}

List<Location> mesVideoLouer ;
mesVideoLouer = LocVideoBean.getInstance().getLocations(Uti.getId());

%>
</head>
<body>
<div id="header">
		<h1><% out.print("Poney Vidéos");%></h1>
		<h2><% out.print("Les vidéos qui envoient du poneys");%></h2>
</div>
<div id="titre">
	<h1><img src="STYLE/images/icone-connexion.png" />Historique</h1>
</div>

<div id="menu">
	<p>Bienvenue <% out.print(Uti.getLogin()+"<br>");%></p>
	<p><a href="acceuil.html" >Acceuil</a><br></p>
	<p><a href="derniereSortie.html" >Dernières Sorties</a><br></p>
	<p><a href="deconnexion.html" >Déconnexion</a><br></p>

</div>


<div id="conteneur">

	<% 
	if(mesVideoLouer != null && mesVideoLouer.size()>0)
	{
		Collections.sort(mesVideoLouer, new Comparator<Location>()
				{
					public int compare(Location first, Location second)
					{
						return second.getDateLocation().compareTo(first.getDateLocation());
					}
				});
		%>
		<table id="historique">
		<tr>
			<th align="left"><label>Affiche</label></th>
			<th align="left"><label>Film</label></th>
			<th align="left"><label>Date Location</label></th>
			<th align="left"><label>Date Retour</label></th>
		</tr>
		<%
		DateFormat formatDate = DateFormat.getDateInstance( DateFormat.MEDIUM ) ;
		for(int i = 0; i < mesVideoLouer.size(); i++)
		{
			Location maVideoLouer = mesVideoLouer.get(i);
			Video maVideo = maVideoLouer.getVideo();
			%>
			<tr>
			<td width = 77px><a href="detailVideo.html?id=<%out.print(maVideo.getId()); %>" ><img src="<%out.print(maVideo.getImage()); %>" width=75px height=105px/></a></td>
			<td><a href="detailVideo.html?id=<%out.print(maVideo.getId()); %>" ><label><%out.print(maVideo.getNom()); %></label></a></td>
			<td><label><%out.print(formatDate.format(maVideoLouer.getDateLocation())); %></label></td>
			<td><label><%out.print(formatDate.format(maVideoLouer.getDateLimiteRetour())); %></label></td>
		</tr>
	   <%}
		%></table><%
	}
	else
	{
		%><p><% out.print("Vous n'avez pas encore loué de vidéo");%></p><%
	}%>

</div>
</body>
</html>