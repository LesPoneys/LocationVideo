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
 <link rel="stylesheet" media="screen" href="STYLE/CSS/style.css">
<%
if (request.getAttribute("uti") == null)
{
	%> <meta http-equiv="Refresh" content="0;url=/LocationVideoWebApp/connexion"> <%
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
<div id="conteneur">
<p><b><%
	Utilisateur Uti = (Utilisateur)request.getAttribute("uti");
	out.print(Uti.getLogin()+"<br>");
	
	List<Video> mesVideo = LocVideoBean.getInstance().getVideos();
	Collections.sort(mesVideo, new Comparator<Video>()
	{
		public int compare(Video first, Video second)
		{
			return first.getNom().compareToIgnoreCase(second.getNom());
		}
	});
%>	<table>
<% for(int i =0; i< mesVideo.size(); i++)
	{
		Video maVideo = mesVideo.get(i);
%><tr><td><img src="<%out.print(maVideo.getImage()); %>" width=75px height=105px/></td>
	<td><%out.print(maVideo.getNom()); %></td>
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
	}	
	 %></td>
</tr><%		
	}
%>	</table>
<%
	List<Categorie> mesCat = LocVideoBean.getInstance().getCategories();
	Collections.sort(mesCat, new Comparator<Categorie>()
			{
				public int compare(Categorie first, Categorie second)
				{
					return first.getNom().compareToIgnoreCase(second.getNom());
				}
			});
	
	%><br><br>
	<select name="trie">
	<%
			
			for(int i =0; i< mesCat.size(); i++)
			{
				Categorie maCat = mesCat.get(i);
				String NomCat =maCat.getNom(); 
			
	%>
			<option value="<%out.print(NomCat); %>"><% out.print(NomCat); %></option>
				
	<%		}
	%>
	</select> 
	
			 
	</b></p>
	
	<input type="submit" name="Valider" value="Afficher"/>

	
	
	</div>			
</body>  
</html>