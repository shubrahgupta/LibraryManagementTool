package com.library.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudenLogin
 */
@WebServlet("/StudenLog")
public class StudenLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		 
		
		if(uname == null || uname.equals("")) {
			request.setAttribute("status","invalidEmail");
			dispatcher = request.getRequestDispatcher("StudentLogin.jsp");
			dispatcher.forward(request, response);
		}
		if(pass == null || pass.equals("")) {
			request.setAttribute("status","InvalidPwd");
			dispatcher = request.getRequestDispatcher("StudentLogin.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group3_project?useSSL=false","root","root");
			PreparedStatement pst = con.prepareStatement("select * from member_records where member_username = ? and member_password = ?");
			pst.setString(1, uname);
			pst.setString(2, pass);
	
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				request.setAttribute("name", uname);
				
				dispatcher = request.getRequestDispatcher("issue.jsp");
			}else
			{
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("StudentLogin.jsp");
			}
			
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
