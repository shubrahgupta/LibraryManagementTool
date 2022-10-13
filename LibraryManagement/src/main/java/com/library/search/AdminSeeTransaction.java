package com.library.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminSeeTransaction
 */
@WebServlet("/AdminSeeTransaction")
public class AdminSeeTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection con = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group3_project?useSSL=false","root","root");
			PreparedStatement pst = con.prepareStatement("select * from transactions");
			
			ResultSet rs = pst.executeQuery();
			
			request.setAttribute("list", rs);
			RequestDispatcher rd=request.getRequestDispatcher("adminSeeTransaction.jsp");
			rd.forward(request, response);
				
		}catch(Exception e)
		{
			out.print(e);
		}
		
		
	}
		
		
	

}
