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
 <link rel="stylesheet" media="screen" href="STYLE/CSS/styleConnected.css">
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

<div id="menu">
	<p>Bienvenue <% out.print(Uti.getLogin()+"<br>");%></p>
	<p><a href="derniereSortie.html" >Dernières Sorties</a><br></p>
	<p><a href="historique.html" >Mon Historique</a><br></p>
	<p><a href="deconnexion.html" >Déconnexion</a><br></p>
</div>

<div id="conteneur">

<% 
List<Video> mesVideo = (List<Video>)request.getAttribute("videos");
if(request.getAttribute("location") != null)
{
	%><p><%out.print("Confirmation de la réservation de " + request.getAttribute("location"));%></p><%
}
%>
<form name="connexion" action="acceuil.html" method="post">
<label>Catégories : </label>
<select name="catégorie">
<option value="Toutes les catégories">Toutes les catégories</option>
<%
List<Categorie> mesCat = (List<Categorie>)request.getAttribute("cats");
String maCat = (String)request.getAttribute("catégorie");
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
<label>Trie : </label>

<select name="trie">
	<%
	String monTrie = (String)request.getAttribute("trie");
	if(monTrie.equals("az")){%>
	 <option selected value="az">A-Z</option><%}
	else{%>
	 <option value="az">A-Z</option><%}
	if(monTrie.equals("za")){%>
	 <option selected value="za">Z-A</option><%}
	else{%>
	 <option value="za">Z-A</option><%}
	if(monTrie.equals("pcroissant")){%>
	 <option selected value="pcroissant">Prix croissant</option><%}
	else{%>
	 <option value="pcroissant">Prix croissant</option><%}
	if(monTrie.equals("pdecroissant")){%>
	 <option selected value="pdecroissant">Prix décroissant</option><%}
	else{%>
	 <option value="pdecroissant">Prix décroissant</option><%}%>
</select> 
		 
<input type="submit" name="Valider" value="Afficher"/>

</form>
<%
if(mesVideo != null && mesVideo.size() > 0)
{
	%><table><%
	for(int i =0; i< mesVideo.size(); i++)
	{
		Video maVideo = mesVideo.get(i);%>
		<tr><td width = 152px><a href="detailVideo.html?id=<%out.print(maVideo.getId()); %>" ><img src="<%out.print(maVideo.getImage()); %>" width=150px height=210px/></a></td>
		<td><titrelabel><a href="detailVideo.html?id=<%out.print(maVideo.getId()); %>" ><%out.print(maVideo.getNom()); %></a></titrelabel><br><br>
		<label ><%out.print(maVideo.getDescription()); %><br><br>
		Catégorie : <%out.print(maVideo.getCategorie().getNom()); %><br>
		Supports : <%
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
		}%>
		<br><br>
		Prix :  <%out.print(maVideo.getPrix()); %> euros <br>
		</label></td></tr><tr></tr>
		<%		
	}
	%></table><%
}
else
{
	%><p><%out.print("Aucune vidéo trouvée");%></p><%
}%>	

</div>			
</body>  
</html>