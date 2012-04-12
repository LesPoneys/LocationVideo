package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Utilisateur;

public class IndexController extends Controller
{
	public IndexController(HttpServletRequest request, HttpServletResponse response)
	{
		super(request,response);
	}
	
	public void process() throws ServletException, IOException
	{
		HttpSession session = request.getSession(true);
		Utilisateur user = (Utilisateur) session.getAttribute("uti");
		if(user != null)
		{
			dispatch("acceuil.html");
		}
		else
		{
			dispatch("connexion.html");
		}
	}

}


