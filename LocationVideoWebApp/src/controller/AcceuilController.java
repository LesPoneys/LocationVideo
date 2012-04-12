package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AcceuilController extends Controller {

	public AcceuilController(HttpServletRequest request,HttpServletResponse response) 
	{
		super(request, response);
	}
	
	public void process() throws ServletException, IOException
	{
		dispatch("acceuil.jsp");
	}

}
