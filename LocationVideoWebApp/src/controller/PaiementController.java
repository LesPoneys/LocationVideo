package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaiementController extends Controller {

	public PaiementController(HttpServletRequest request, HttpServletResponse response) 
	{
		super(request, response);
	}
	
	public void process() throws ServletException, IOException
	{
		String SupportChoisit = request.getParameter("support");
		String IdVideo = request.getParameter("id");
		if (SupportChoisit!=null && !SupportChoisit.isEmpty() && IdVideo!=null && !IdVideo.isEmpty() )
		{
			request.setAttribute("support", SupportChoisit);
			request.setAttribute("id", IdVideo);
			dispatch("paiement.jsp");
		}
		else
		{
			dispatch("acceuil.html");
		}
			
	}
}
