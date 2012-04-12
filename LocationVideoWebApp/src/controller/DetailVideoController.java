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
			dispatch("detailVideo.jsp");
	}
}
