<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="metier.Utilisateur" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="fr">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title></title>

  <link rel="stylesheet" media="screen" href="STYLE/CSS/style.css">
</head>
<body>

<div id="header">
		<h1><% out.print("Poney Vidéos");%></h1>
		<h2><% out.print("Les vidéos qui envoient du poneys");%></h2>
	</div>

<div id="titre">
	<h1><img src="STYLE/images/icone-connexion.png" />Inscription</h1>
</div>
<%
Utilisateur Uti=null;
if (request.getAttribute("uti")!=null)
{
	Uti = (Utilisateur)request.getAttribute("uti");
}


%>
<div id="conteneur">

	<form name="firstForm" action="inscription.do" method="post">
		<table>
		<tr><td><label><%if (request.getAttribute("erreur")=="login") 
				out.print("Login déja utilisé ");%></label></td></tr>
		<tr><td><label><%if (request.getAttribute("erreur")=="mdp") 
				out.print("Mot de passe non identique ");%></label></td></tr>
		<tr><td><label><%if (request.getAttribute("erreur")=="champ vide") 
				out.print("Vous n'avez pas renseigné tout les champs ");%></label></td></tr>
			
			<tr><td class="label"><label for="nom">Nom : </label></td></tr>
			<tr><td><input type="text" id="nom" name="nom" value="<%out.print((Uti != null) ? Uti.getNom() : "");%>" /></td></tr>

			<tr><td class="label"><label for="prenom">Prénom : </label></td></tr>
			<tr><td><input type="text" id="prenom" name="prenom" value="<%out.print((Uti != null) ? Uti.getPrenom() : "");%>"/></td></tr>
		
			<tr><td class="label"><label for="login">Login : </label></td></tr>
			<tr><td><input type="text" id="login" name="login" value="<%out.print((Uti != null) ? Uti.getLogin() : "");%>"/></td></tr>

			<tr><td class="label"><label for="mdp">Mot de passe : </label></td></tr>
			<tr><td><input type="password" id="mdp" name="mdp" value="<%out.print((Uti != null) ? Uti.getMdp() : "");%>"/></td></tr>
		
			<tr><td><label for="vmdp">Validez votre mot de passe : </label></tr>
			<tr><td><input type="password" id="vmdp" name="vmdp" /></td></tr>
	
			<tr><td class="label"><label for="mail">E-mail : </label></td></tr>
			<tr><td><input type="text" id="mail" name="mail" value="<%out.print((Uti != null) ? Uti.getEmail() : "");%>"/></td></tr>
		
			<tr><td class="label"><input type="submit" name="inscription" value="inscription" /></td></tr>
		</table>
	</form>
</div>

</body>
</html>