package com.library.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String bookid = request.getParameter("BookId");
		String authName = request.getParameter("Author");
		String bname = request.getParameter("Book_Name");
		String price = request.getParameter("Price");
		String cat = request.getParameter("Category");
		String pub = request.getParameter("Publication");
		String quan = request.getParameter("Quantity");
		RequestDispatcher dispatcher = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group3_project?useSSL=false","root","root");
			PreparedStatement pst = con.prepareStatement("insert into books_info(book_id,book_author,book_name,book_price,book_category,publisher_name,total_quantity,available_quantity) values(?,?,?,?,?,?,?,?) ");
			
			Statement stmt = (Statement) con.createStatement();
			String query = "select count(*) from books_info";
		      //Executing the query
		      ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
		      //Retrieving the result
		      rs.next();
		      int count = rs.getInt(1);
		      
			pst.setInt(1, count+1);
			pst.setString(2, authName);
			pst.setString(3, bname);
			pst.setString(4, price);
			pst.setString(5, cat);
			pst.setString(6, pub);
			pst.setString(7, quan);
			pst.setString(8, quan);
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("books.jsp");
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
