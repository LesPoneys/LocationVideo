package servlet;

import java.io.IOException;

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
        // TODO Auto-generated constructor stub
    }
    public Utilisateur inscrire (String Login, String mdp, String email)
    {
    	Utilisateur Uti = new Utilisateur();
    
    	Uti.setEmail(email);
    	Uti.setIsAdmin(false);
    	Uti.setLogin(Login);
    	Uti.setMdp(mdp);
    	return LocVideoBean.getInstance().ajoutUtilisateur(Uti);
   
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Utilisateur Uti = this.inscrire(request.getParameter("login"),request.getParameter("mdp"),request.getParameter("mail")); 
	
		request.setAttribute("uti", Uti);
		RequestDispatcher dispatch = request.getRequestDispatcher("acceuil.jsp");
		dispatch.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
