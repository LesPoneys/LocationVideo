package controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Location;
import metier.Utilisateur;
import metier.Video;
import bean.LocVideoBean;

public class LocationController extends Controller {

	public LocationController(HttpServletRequest request,HttpServletResponse response) 
	{
		super(request, response);
	}

	public void process() throws ServletException, IOException
	{
		if (request.getParameter("type")!=null && !request.getParameter("type").isEmpty())
		{
			if(request.getParameter("type").equals("CB"))
			{	
				if (request.getParameter("numCarte")!=null && !request.getParameter("numCarte").isEmpty()
						&& request.getParameter("cle")!=null && !request.getParameter("cle").isEmpty()
						&& request.getParameter("nom")!=null && !request.getParameter("nom").isEmpty()
						&& request.getParameter("date")!=null && !request.getParameter("date").isEmpty())
				{
					ValiderLocation();
				}
				else
				{
					RedirectSiErreur();
				}
			}
			else if(request.getParameter("type").equals("CC"))
			{
				if (request.getParameter("numCarteC")!=null && !request.getParameter("numCarteC").isEmpty()
						&& request.getParameter("mdp")!=null && !request.getParameter("mdp").isEmpty())
				{
					ValiderLocation();
				}
				else
				{
					RedirectSiErreur();
				}
			}
		}
		else
		{
			RedirectSiErreur();
		}
		
	}

	private void RedirectSiErreur() throws ServletException, IOException {
		int idVideo = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", idVideo);
		request.setAttribute("erreur","true");
		dispatch("paiement.jsp");
	}

	private void ValiderLocation() throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur Uti = (Utilisateur)session.getAttribute("uti") ;
		if(Uti != null)
		{
			Location location = new Location();
			location.setDateLocation(new Date());
			
			GregorianCalendar calendar = new java.util.GregorianCalendar(); 
			calendar.setTime( new Date() ); 
			calendar.add (Calendar.DATE, 14);
			
			location.setDateLimiteRetour(calendar.getTime());

			
			int idVideo = Integer.parseInt(request.getParameter("id"));
			Video maVideo = LocVideoBean.getInstance().getVideo(idVideo);
			
			location.setVideo(maVideo);
			location.setUtilisateur(Uti);
			
			LocVideoBean.getInstance().ajoutHistorique(location);
			
			request.setAttribute("location", maVideo.getNom());
			
			dispatch("acceuil.html");
		}
		else
		{
			dispatch("acceuil.html");
		}
	}
}
