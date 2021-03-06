package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Utilisateur;
import bean.LocVideoBean;

public class InscriptionController extends Controller {

	public InscriptionController(HttpServletRequest request, HttpServletResponse response)
	{
		super(request, response);
	}
	
	public void process() throws ServletException, IOException
	{
		if(request.getParameter("login") == null)
		{
			dispatch("inscription.jsp");
		}
		else if(chercherErreur(request, response)==false)
		{
			Utilisateur Uti = this.inscrire(request); 
			HttpSession session = request.getSession(true);
			session.setAttribute("uti", Uti);
			dispatch("acceuil.html");
		}
	}
	
	public Utilisateur inscrire (HttpServletRequest request)
    {
    	Utilisateur Uti = getCurrentUtilisateur(request);
    	return LocVideoBean.getInstance().ajoutUtilisateur(Uti);
    	
    }
    
    public Utilisateur getCurrentUtilisateur(HttpServletRequest request)
    {
    	Utilisateur Uti = new Utilisateur(request.getParameter("login"),request.getParameter("mdp"),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("mail"));
    	return Uti;
    }

	public boolean checkExistenceLogin(String login)
	{
		Utilisateur MonUti = LocVideoBean.getInstance().getUtilisateurbyLogin(login);
		if(MonUti!= null)
		{
			return true;
		}
		return false;
	}
	
	public boolean differenceMDP(String mdp, String validationmdp)
	{
		if (!mdp.equals(validationmdp))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean checkSiChampsVide(String login,String mdp, String nom,String prenom,String email)
	{
		if((login.isEmpty())||(mdp.isEmpty())||(nom.isEmpty())||(prenom.isEmpty())||(email.isEmpty()))
		{
			return true;
		}
		return false;
	}
	
	public boolean chercherErreur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if (checkSiChampsVide(request.getParameter("login"),request.getParameter("mdp"),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("mail"))==true)
		{
			request.setAttribute("erreur", "champ vide");
			Utilisateur Uti = this.getCurrentUtilisateur(request);
			Uti.setMdp("");
			HttpSession session = request.getSession(true);
			session.setAttribute("uti", Uti);
			dispatch("inscription.jsp");
			return true;
			
		}
		
		if(checkExistenceLogin(request.getParameter("login"))==true)
		{
			request.setAttribute("erreur", "login");
			Utilisateur Uti = this.getCurrentUtilisateur(request);
			Uti.setMdp("");
			Uti.setLogin("");
			HttpSession session = request.getSession(true);
			session.setAttribute("uti", Uti);
			dispatch("inscription.jsp");
			return true;
		}
		
		if (differenceMDP(request.getParameter("mdp"), request.getParameter("vmdp"))==true)
		{
			request.setAttribute("erreur", "mdp");
			Utilisateur Uti = this.getCurrentUtilisateur(request);
			Uti.setMdp("");
			HttpSession session = request.getSession(true);
			session.setAttribute("uti", Uti);
			dispatch("inscription.jsp");
			return true;
		}
		return false;
	}
}
