<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="metier.Video"%>
<%@ page import="bean.LocVideoBean"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="metier.Support"%>
<%@ page import="metier.Utilisateur"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
Utilisateur Uti = (Utilisateur)session.getAttribute("uti") ;
if (Uti == null)
{
	%> <jsp:forward page="/connexion.html" />  <%
}

%>
<% 
String idVideo = request.getParameter("id");
Video maVideo = LocVideoBean.getInstance().getVideo(Integer.parseInt(idVideo));
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><% out.print(maVideo.getNom());%></title>
<link rel="stylesheet" media="screen" href="STYLE/CSS/styleConnected.css">
</head>
<body>
<div id="header">
		<h1><% out.print("Poney Vidéos");%></h1>
		<h2><% out.print("Les vidéos qui envoient du poneys");%></h2>
	</div>

<div id="titre">
	<h1><img src="STYLE/images/icone-connexion.png" /><% out.print(maVideo.getNom());%></h1>
</div>

<div id="menu">
	<p>Bienvenue <% out.print(Uti.getLogin()+"<br>");%></p>
	<p><a href="acceuil.html" >Acceuil</a><br></p>
	<p><a href="historique.html" >Mon Historique</a><br></p>
	<p><a href="deconnexion.html" >Déconnexion</a><br></p>

</div>


<div id="conteneur">
	<form name="location" action="location.html?id=<%out.print(maVideo.getId()); %>" method="post">
	<table><tr>
			<td><img src="<%out.print(maVideo.getImage()); %>" width=150px height=210px/></td>
			<td><label><% out.print(maVideo.getDescription());%><br><br>
			<% out.print(maVideo.getCategorie().getNom());%><br>
			<%	
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
				</label></td>
		</tr></table>
		
		<input type="submit" name="Louer" value="Valider"/>
	</form>
</div>
</body>
</html>