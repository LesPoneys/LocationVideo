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
<%@ page import="helper.TriParCategorie"%> 
           
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ACCEUIL</title>
 <link rel="stylesheet" media="screen" href="STYLE/CSS/styleAcceuil.css">
<%
Utilisateur Uti=null ;
if (session.getAttribute("uti") == null)
{
	%> <meta http-equiv="Refresh" content="0;url=/LocationVideoWebApp/connexion"> <%
}
else
{
	Uti = (Utilisateur)session.getAttribute("uti");
}
List<Video> mesVideo ;
mesVideo = LocVideoBean.getInstance().getVideos();
String maCat = request.getParameter("trie");
if ( maCat==null || maCat.isEmpty() )
{
	maCat ="Toutes les cat�gories";
}
TriParCategorie leTri = new TriParCategorie();
mesVideo = leTri.getVideosWithCategorie(maCat, mesVideo);


%>

</head>
<body>
<div id="header">
		<h1><% out.print("Poney Vid�os");%></h1>
		<h2><% out.print("Les vid�os qui envoient du poneys");%></h2>
	</div>

<div id="titre">
	<h1><img src="STYLE/images/icone-connexion.png" />Acceuil</h1>
</div>
<div id="utilisateur">
</div>

<div id="menu">
	<form name="connexion" action="acceuil.jsp" method="post">
		<table><tr>
	<%
	List<Categorie> mesCat = LocVideoBean.getInstance().getCategories();
	Collections.sort(mesCat, new Comparator<Categorie>()
			{
				public int compare(Categorie first, Categorie second)
				{
					return first.getNom().compareToIgnoreCase(second.getNom());
				}
			});
	
	%>
	<select name="trie">
	<%
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
	%>
	</select> 
	 
	</tr><tr><input type="submit" name="Valider" value="Valider"/></tr>
	</table>
	</form>

</div>

<div id="conteneur">
<p><b><%
	 
	//(Utilisateur)request.getAttribute("uti");
	out.print(Uti.getLogin()+"<br>");
	
	
	Collections.sort(mesVideo, new Comparator<Video>()
	{
		public int compare(Video first, Video second)
		{
			return first.getNom().compareToIgnoreCase(second.getNom());
		}
	});
	
%>
<form name="detailVideo" action="detailVideo.jsp" method="post">	
<table>
<% for(int i =0; i< mesVideo.size(); i++)
	{
		Video maVideo = mesVideo.get(i);
%><tr><td><a href="detailVideo.jsp" ><img src="<%out.print(maVideo.getImage()); %>" width=150px height=210px/></a></td>
	<td><a href="detailVideo.jsp" ><%out.print(maVideo.getNom()); %></a></td>
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
	</form>
<br>
<br>
	
	
	</div>			
</body>  
</html>