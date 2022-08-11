package com.nit.durgasoft;
import java.io.*;
import java.sql.DriverManager;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.sql.*;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	
	
    /**
     * Default constructor. 
     */
    public SignupServlet() {
      System.out.println("signup constructor");  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String firstName=request.getParameter("first");
	String lastName=request.getParameter("last");
	String city=request.getParameter("city");
	String uname=request.getParameter("uname");
	String pwd=request.getParameter("pwd");
	int password=Integer.parseInt(pwd);
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	out.println("<center><h2 style=color:red>Welcome to sonu software solution</h2></center>");
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonudb","root","sonujhaSONU");
	PreparedStatement ps=cn.prepareStatement("insert into sonudb.Registration values(?,?,?,?,?)");
	ps.setString(1,firstName);
	ps.setString(2,lastName);
	ps.setString(3,city);
	ps.setString(4,uname);
	ps.setInt(5, password);
	int hh=ps.executeUpdate();
	out.println("<center><h2 style=color:green>thanks::"+firstName+":::your record registered successfully"+"</h2></center><br>");
	out.println("<center><h2 style=color:orange><a href=Login.html>Login</h2></center>");
	}
	catch(Exception e){
	out.println("signup failed please try again");
	
	}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
