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
String monSupport = request.getParameter("support");
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Paiement</title>
<link rel="stylesheet" media="screen" href="STYLE/CSS/styleConnected.css">
</head>
<body>
<div id="header">
		<h1><% out.print("Poney Vidéos");%></h1>
		<h2><% out.print("Les vidéos qui envoient du poneys");%></h2>
	</div>

<div id="titre">
	<h1><img src="STYLE/images/icone-connexion.png" />Paiement</h1>
</div>

<div id="menu">
	<p>Bienvenue <% out.print(Uti.getLogin()+"<br>");%></p>
	<p><a href="acceuil.html" >Acceuil</a><br></p>
	<p><a href="derniereSortie.html" >Dernières Sorties</a><br></p>
	<p><a href="historique.html" >Mon Historique</a><br></p>
	<p><a href="deconnexion.html" >Déconnexion</a><br></p>

</div>

<div id="conteneur">
	
	<table>
		<tr>
			<tr><label ><%if (request.getAttribute("erreur")=="true") 
				out.print("Donnée de paiement manquante ");%></label></tr>
					<tr><td></td><tr>
			<td width = 152px><img src="<%out.print(maVideo.getImage()); %>" width=150px height=210px/></td>
			<td><label><% out.print(maVideo.getNom());%><br><br>
		
			Supports : <% out.print(monSupport);%><br><br>
			
			Prix : <% out.print(maVideo.getPrix());%><br><br>

			</label></td>
		</tr>
	</table>
	

	
	<table>
		<tr>
			<td class="gauche" width = 50%>
				<form name="paiementCB" action="location.html?id=<% out.print(maVideo.getId());%>" method="post">
				<input type="hidden" name="type" value="CB" />
				<table>
					<tr><td align="center"><img src="STYLE/images/visacb.jpg" width=70px/></td></tr>
					<tr><td class="cle"><label for="nom"><% out.print("Nom propriétaire de la carte :");%> </label></td></tr>
					<tr><td><input type="text" id="nom" name="nom" /></td></tr>
					
					<tr><td><label for="numCarte"><% out.print("N° de carte bancaire :");%> </label></td></tr>
					<tr><td><input type="text" id="numCarte" name="numCarte" /></td></tr>
		
					<tr><td class="cle"><label for="cle"><% out.print("Clé :");%> </label></td></tr>
					<tr><td><input type="text" id="cle" name="cle" /></td></tr>
							
					
					<tr><td class="cle"><label for="date"><% out.print("Date d'expiration :");%> </label></td></tr>
					<tr><td><input type="text" id="date" name="date" /></td></tr>
					
					<tr align="center"><td class="label"><input type="submit" name="Valider" value="Valider" /></td></tr>
				</table>
			</form>
			</td>
			<td>
				<form name="paiementCC" action="location.html?id=<% out.print(maVideo.getId());%>" method="post">
				<input type="hidden" name="type" value="CC" />
				<table>
					<tr><td align="center"><img src="STYLE/images/poney-card.png" width=70px/><td></tr>
			
					<tr><td><label for="numCarteC"><% out.print("N° de carte :");%> </label></td></tr>
					<tr><td  width =200><input type="text" id="numCarteC" name="numCarteC" /></td></tr>
		
					<tr><td class="label"><label for="mdp"><% out.print("Mot de passe :");%> </label></td></tr>
					<tr><td><input type="password" id="mdp" name="mdp" /></td></tr>
							
									
					<tr align="center"><td class="label"><input type="submit" name="Valider" value="Valider" /></td></tr>
				</table>
			</form>
				
			</td>
		</tr>
	
		
	</table>
	
	

	

</div>
</body>
</html>