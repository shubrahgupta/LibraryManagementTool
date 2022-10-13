package com.library.registration;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int member_id= request.getParameter("member_id");
		String fname = request.getParameter("first");
		String lname = request.getParameter("last");
		String uname = request.getParameter("username");
		String psd = request.getParameter("password");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group3_project?useSSL=false","root","root");
			Statement stmt = con.createStatement();
		      //Query to get the number of rows in a table
		      String query = "select count(*) from member_records";
		      //Executing the query
		      ResultSet rs = stmt.executeQuery(query);
		      //Retrieving the result
		      rs.next();
		      int count = rs.getInt(1);
			PreparedStatement pst = con.prepareStatement("insert into member_records(member_id, member_type,date_of_membership,number_of_books_issued,max_issue_limit,member_name,member_email,member_contact,member_username,member_password) values(?,?,?,?,?,?,?,?,?,?); ");
			//PreparedStatement count = con.prepareStatement("SELECT COUNT(*) FROM  member_records");
			
			
			
			
			pst.setInt(1, 10001+count);
			pst.setString(6, (fname+" "+lname));
			//pst.setString(2, lname);
			pst.setString(9, uname);
			pst.setString(10, psd);
			pst.setString(8, contact);
			pst.setString(7, email);
			//pst.set
			pst.setDate(3, Date.valueOf(java.time.LocalDate.now()));
			pst.setString(2, "Regular");
			pst.setInt(4,0);
			pst.setInt(5,3);
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			if(rowCount > 0)
			{
				request.setAttribute("status", "success");
			}else
			{
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}