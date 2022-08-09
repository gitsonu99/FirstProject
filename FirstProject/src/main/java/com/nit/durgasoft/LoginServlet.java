package com.nit.durgasoft;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.sql.*;
public class LoginServlet extends GenericServlet  {
	static Connection cn ;
	static PreparedStatement ps;
	static ResultSet rs;
    public LoginServlet() {
        System.out.println("execution of constructor");
    }
    
    static {
    	try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonudb","root", "sonujhaSONU");
    ps=cn.prepareStatement("select count(*) from sonudb.student where student_id =? and student_name=?");
    	}
    	catch(Exception  exception) {
    		exception.printStackTrace();
    	}
    }
   
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("usr");
		String password=request.getParameter("pwd");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<center><h1 style=color:green>Welcome to sonu software solution </h1><center><br>")	;
		try {
			
		ps.setString(1,password );
		ps.setString(2,userName);
		rs=ps.executeQuery();
		rs.next();
		int id =rs.getInt(1);
		if(id!=0) {
		
		out.println("<center><h3 style=color:purple>hello::"+userName+"</h3></center><br>");
		out.println("<center><h3 style=color:orange>thanks for login</h3></center><br>");
		}
		else {
			out.println("<center><h3 style=color:green>please use valid username and password </h3><center><br>");
			out.println("<center><h3 style=color:green><a href=Login.html> Login </h3><center><br>");
		}
		}
		catch(Exception ee) {
		ee.printStackTrace();	
		}
		
		
	}

	
	

}
