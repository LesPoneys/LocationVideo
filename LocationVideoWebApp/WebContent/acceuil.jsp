<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="metier.Utilisateur"%>
<%@ page import="metier.Video"%>
<%@ page import="metier.Categorie"%>
<%@ page import="bean.LocVideoBean"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Comparator"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ACCEUIL</title>
<%
if (request.getAttribute("uti") == null)
{
	%> <meta http-equiv="Refresh" content="0;url=/LocationVideoWebApp/connexion"> <%
}
%>

</head>
<body>
<p><b><%
	Utilisateur Uti = (Utilisateur)request.getAttribute("uti");
	out.println(Uti.getLogin()+"<br>");
	
	List<Video> mesVideo = LocVideoBean.getInstance().getVideos();
	Collections.sort(mesVideo, new Comparator<Video>()
	{
		public int compare(Video first, Video second)
		{
			return first.getNom().compareToIgnoreCase(second.getNom());
		}
	});
	
	for(int i =0; i< mesVideo.size(); i++)
	{
		Video maVideo = mesVideo.get(i);
		out.println(maVideo.getNom()+" - "+maVideo.getCategorie().getNom()+"<br>");
		
	}
	
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
			<option value="<%out.println(NomCat); %>"><% out.println(NomCat); %></option>
				
	<%		}
	%>
	</select> 
	
			 
	</b></p>
	
	<input type="submit" name="Valider" value="Afficher"/>

	
	
				
</body>  
</html>