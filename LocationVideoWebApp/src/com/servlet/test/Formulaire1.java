package com.servlet.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Formulaire1 extends HttpServlet {

	public void doGet(	HttpServletRequest request, 
						HttpServletResponse response)
						throws IOException, ServletException{
		
		request.getRequestDispatcher("forms.jsp").forward(request, response);		
	}

}
