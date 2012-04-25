package controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Historique;
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
		HttpSession session = request.getSession();
		Utilisateur Uti = (Utilisateur)session.getAttribute("uti") ;
		if(Uti != null)
		{
			Historique historique = new Historique();
			historique.setdateVisu(new Date());
			
			int idVideo = Integer.valueOf(request.getParameter("id"));
			Video maVideo = LocVideoBean.getInstance().getVideo(idVideo);
			
			historique.setVideo(maVideo);
			historique.setUtilisateur(Uti);
			
			LocVideoBean.getInstance().ajoutHistorique(historique);
			
			dispatch("acceuil.html");
		}
		else
		{
			dispatch("acceuil.html");
		}
		
	}
}
