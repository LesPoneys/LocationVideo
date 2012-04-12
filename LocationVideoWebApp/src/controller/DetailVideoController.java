package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailVideoController extends Controller {

	public DetailVideoController(HttpServletRequest request, HttpServletResponse response) 
	{
		super(request, response);
	}
	
	public void process() throws ServletException, IOException
	{
		if(request.getParameter("id") != null)
		{
			dispatch("detailVideo.jsp");
		}
		else
		{
			dispatch("acceuil.html");
		}
	}

}
