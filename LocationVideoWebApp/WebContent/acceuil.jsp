<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="metier.Utilisateur"%>
<%@ page import="metier.Video"%>
<%@ page import="metier.Categorie"%>
<%@ page import="bean.LocVideoBean"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Comparator"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="metier.Support"%>     
           
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ACCEUIL</title>
 <link rel="stylesheet" media="screen" href="STYLE/CSS/styleAcceuil.css">
<%
Utilisateur Uti = (Utilisateur)session.getAttribute("uti") ;
if (Uti == null)
{
	%> <jsp:forward page="/connexion.html" />  <%
}

%>
</head>
<body>
<div id="header">
		<h1><% out.print("Poney Vidéos");%></h1>
		<h2><% out.print("Les vidéos qui envoient du poneys");%></h2>
	</div>

<div id="titre">
	<h1><img src="STYLE/images/icone-connexion.png" />Acceuil</h1>
</div>
<div id="utilisateur">
	<p>Bienvenue <% out.print(Uti.getLogin()+"<br>");%></p>
	<!-- trouver un moyen de mettre mon panier (liste des film sélectionné) -->
</div>

<div id="menu">
	<table>
	<tr>
		<a href="historique.html" >Mon Historique</a><br>
		<a href="index.html" >Déconnexion</a><br>
	</tr>
	<tr>
	<p> Trier :<br></p>
	<form name="connexion" action="acceuil.html" method="post">
		<table><tr>

	<select name="trie">
	<option value="Toutes les catégories">Toutes les catégories</option>
	<%
	List<Categorie> mesCat = (List<Categorie>)request.getAttribute("cats");
	String maCat = (String)request.getAttribute("trie");
	if(mesCat != null)
	{
		for(int i =0; i< mesCat.size(); i++)
		{
			Categorie cat = mesCat.get(i);
			String NomCat =cat.getNom(); 
			if(NomCat.equals(maCat))
			{
				%>	<option selected value="<%out.print(maCat); %>"><% out.print(maCat); %></option><%
			}
			else
			{
		%>	<option value="<%out.print(NomCat); %>"><% out.print(NomCat); %></option> <%
			}	
		}
	}
	%>
	
	</select> 
	 
	</tr><tr><input type="submit" name="Valider" value="Valider"/></tr>
	</table>
	</form>
	</tr>
	</table>
</div>

<div id="conteneur">
<p><b>
<table>

<% 
List<Video> mesVideo = (List<Video>)request.getAttribute("videos");
if(mesVideo != null)
{
	for(int i =0; i< mesVideo.size(); i++)
	{
		Video maVideo = mesVideo.get(i);%>
		<tr><td><a href="detailVideo.html?id=<%out.print(maVideo.getId()); %>" ><img src="<%out.print(maVideo.getImage()); %>" width=150px height=210px/></a></td>
		<td><a href="detailVideo.html?id=<%out.print(maVideo.getId()); %>" ><%out.print(maVideo.getNom()); %></a></td>
		<td><%out.print(maVideo.getDescription()); %></td>
		<td><%out.print(maVideo.getCategorie().getNom()); %></td>
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
		}%></td></tr>
		<%		
	}
}%>	
</table>
<br>
<br>
	</div>			
</body>  
</html>