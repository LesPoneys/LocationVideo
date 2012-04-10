package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormulaireAction extends HttpServlet {

	public void doGet(	HttpServletRequest request, 
				HttpServletResponse response)
				throws IOException, ServletException{
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
                //On récupère la liste des noms de paramètres
		Enumeration<String> e = request.getParameterNames();
		List<String> prog = new ArrayList<String>();
		
                //On parcours cette liste
		while(e.hasMoreElements()){
			String key = e.nextElement();
			
                        //On vérifie les valeurs des checkbox : 'on' signifie que la checkbox est cochée
			if(request.getParameter(key).equals("on")){
				prog.add(key);
			}
			else{
				out.println("<p><strong>" + key + " : </strong>" + request.getParameter(key) + "</p>");
			}
		}

                //Si nous avons au moins un langage de programmation
		if(prog.size() > 0)
			out.println("<p><strong>Je programme en : </strong>");
		
		out.println("<ul>");
		
		for(String str : prog)
			out.println("<li>" + str + "</li>");
		
		out.println("</ul>");
		
		//On n'utilise plus notre JSP...
		//request.getRequestDispatcher("formResult.jsp").forward(request, response);		
	}
	
	public void doPost(	HttpServletRequest request, 
			HttpServletResponse response)
			throws IOException, ServletException{
                //Nous invoquons la méthode doGet avec les paramètres reçu par la méthode doPost
		doGet(request, response);		
	}	
}