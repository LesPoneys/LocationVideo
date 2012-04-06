package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Utilisateur;

import bean.LocVideoBean;

public class DoConnexion extends HttpServlet {
	
	public void doGet(	HttpServletRequest request, 
				HttpServletResponse response)
				throws IOException, ServletException{
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Utilisateur Uti;
		//List<Utilisateur> MesUti =LocVideoBean.getInstance().getLesUtilisateurs(); 
		Uti = LocVideoBean.getInstance().IdentificationUtilisateur(request.getParameter("login"), request.getParameter("mdp"));
		
		if (Uti != null)
		{
			request.setAttribute("uti", Uti);
			RequestDispatcher dispatch = request.getRequestDispatcher("acceuil.jsp");
			dispatch.forward(request, response);

		}else
		{	
			request.setAttribute("statut", "ECHEC");
			RequestDispatcher dispatch = request.getRequestDispatcher("connexion.jsp");
			dispatch.forward(request, response);
		}  
		
	}
	
	public void doPost(	HttpServletRequest request, 
			HttpServletResponse response)
			throws IOException, ServletException{
                //Nous invoquons la méthode doGet avec les paramètres reçu par la méthode doPost
		doGet(request, response);		
	}	
}