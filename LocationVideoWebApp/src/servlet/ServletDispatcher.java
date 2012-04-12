package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AcceuilController;
import controller.DetailVideoController;
import controller.HistoriqueController;
import controller.IndexController;
import controller.ConnexionController;
import controller.InscriptionController;
/**
 * Servlet implementation class ServletDisptcher
 */
public class ServletDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("2 : " + request.getServletPath());
		
		String path = request.getServletPath();
		
		if(path.equals("/index.html"))
		{
			IndexController index = new IndexController(request, response);
			index.process();
		}
		else if(path.equals("/connexion.html"))
		{
			ConnexionController connexion = new ConnexionController(request, response);
			connexion.process();
		}
		else if(path.equals("/acceuil.html"))
		{
			AcceuilController acceuil = new AcceuilController(request, response);
			acceuil.process();
		}
		else if(path.equals("/inscription.html"))
		{
			InscriptionController inscription = new InscriptionController(request, response);
			inscription.process();
		}
		else if(path.equals("/detailVideo.html"))
		{
			DetailVideoController detailVideo = new DetailVideoController(request, response);
			detailVideo.process();
		}
		else if(path.equals("/historique.html"))
		{
			HistoriqueController historique = new HistoriqueController(request, response);
			historique.process();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
