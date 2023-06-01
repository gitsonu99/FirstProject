package com.nit.durgasoft;

import java.io.IOException;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	

    /**
     * Default constructor. 
     */
    public ControllerServlet() {
        // TODO Auto-generated constructor stub
    	System.out.println("default constructor");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String button =	request.getParameter("s");
	if( button.equals("SignUp")) {
	RequestDispatcher rd=	request.getRequestDispatcher("SignUp.html");
	rd.forward(request, response);
	}
	else {
		RequestDispatcher rd=	request.getRequestDispatcher("login");
		rd.forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
