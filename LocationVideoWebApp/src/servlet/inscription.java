package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Utilisateur;
import bean.LocVideoBean;

/**
 * Servlet implementation class Inscription
 */
public class inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscription() {
        super();
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
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(chercherErreur(request, response)==false)
		{
			Utilisateur Uti = this.inscrire(request); 
			request.setAttribute("uti", Uti);
			redirectTo(request, response, "acceuil.jsp");
		}
		
	}


	private void redirectTo(HttpServletRequest request,
			HttpServletResponse response, String MaJSP) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(MaJSP);
		dispatch.forward(request, response);
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
			request.setAttribute("uti", Uti);
			redirectTo(request, response, "inscription.jsp");
			return true;
			
		}
		
		if(checkExistenceLogin(request.getParameter("login"))==true)
		{
			request.setAttribute("erreur", "login");
			Utilisateur Uti = this.getCurrentUtilisateur(request);
			Uti.setMdp("");
			Uti.setLogin("");
			request.setAttribute("uti", Uti);
			redirectTo(request, response, "inscription.jsp");
			return true;
		}
		
		if (differenceMDP(request.getParameter("mdp"), request.getParameter("vmdp"))==true)
		{
			request.setAttribute("erreur", "mdp");
			Utilisateur Uti = this.getCurrentUtilisateur(request);
			Uti.setMdp("");
			request.setAttribute("uti", Uti);
			redirectTo(request, response, "inscription.jsp");
			return true;
		}
		return false;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
