<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.Enumeration, java.text.SimpleDateFormat, java.util.Date" %>
<html lang="fr">
	<head>
	  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	  <title></title>
		
	   <link rel="stylesheet" media="screen" type="text/css" title="Exemple" href="./STYLE/CSS/style.css" />
	</head>
	<body>
	<div id="header">
		<h1><% out.println("Poney Vidéos");%></h1>
		<h2><% out.println("Les vidéos qui envoient du poneys");%></h2>
	</div>

		<div id="titre">
			<h1><img src="./STYLE/images/icone-connexion.png" /><% out.println("Zone de Connexion");%></h1>
		</div>
		
		<div id="conteneur">
			<form>
				<table>
					<tr><td><label for="login"><% out.println("Login :");%> </label></td></tr>
					<tr><td><input type="text" id="login" name="login" /></td></tr>
		
					<tr><td class="label"><label for="mdp"><% out.println("Mot de passe :");%> </label></td></tr>
					<tr><td><input type="password" id="mdp" name="mdp" /></td></tr>
		
					<tr><td class="label"><input type="submit" name="envoyer" value="Connexion" /></td></tr>
				</table>
			</form>
			<p><% out.println("Pas encore inscrit ?"); %><a href="inscription.jsp" ><% out.println("S'inscrire"); %></a></p>
		</div>
	
		

	</body>
</html>




