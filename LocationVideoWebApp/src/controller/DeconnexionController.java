package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeconnexionController extends Controller {

	public DeconnexionController(HttpServletRequest request, HttpServletResponse response) 
	{
		super(request, response);
	}
	
	public void process() throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		session.invalidate();
		
		dispatch("index.html");
	}

}
