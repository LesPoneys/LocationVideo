package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Utilisateur;
import bean.LocVideoBean;

public class ConnexionController extends Controller
{
	public ConnexionController(HttpServletRequest request, HttpServletResponse response)
	{
		super(request,response);
	}
	
	public void process() throws ServletException, IOException
	{
		if(request.getParameter("login") != null)
		{
			connectUser();
		}
		else
		{
			dispatch("connexion.jsp");
		}
	}
	
	public void connectUser() throws ServletException, IOException
	{
		Utilisateur Uti = LocVideoBean.getInstance().IdentificationUtilisateur(request.getParameter("login"), request.getParameter("mdp"));
		
		if (Uti != null)
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("uti", Uti);
			dispatch("acceuil.html");

		}else
		{	
			request.setAttribute("statut", "ECHEC");
			dispatch("connexion.jsp");
		}  
	}
	
}
