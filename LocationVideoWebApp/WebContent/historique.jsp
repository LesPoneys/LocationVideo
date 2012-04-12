<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="metier.Utilisateur"%>
<%@ page import="bean.LocVideoBean"%>
<%@ page import="java.util.List"%>
<%@ page import="metier.Video"%>
<%@ page import="metier.Historique"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Historique</title>
<link rel="stylesheet" media="screen" href="STYLE/CSS/style.css">
<%
Utilisateur Uti = (Utilisateur)session.getAttribute("uti");
System.out.print("mon Uti  : "+ Uti.getId());
if (Uti == null)
{
	%> <meta http-equiv="Refresh" content="0;url=/LocationVideoWebApp/connexion"> <%
}

List<Historique> mesVideoLouer ;
mesVideoLouer = LocVideoBean.getInstance().getHistorique(Uti.getId());


%>
</head>
<body>
<p> HISTORIQUEEEE</p>
</body>
</html>