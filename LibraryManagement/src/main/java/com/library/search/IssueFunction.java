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
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IssueFunction
 */
@WebServlet("/IssueFunction")
public class IssueFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueFunction() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void issue(ResultSet rs, ResultSet rs1) {
    	Connection con1 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/group3_project?useSSL=false","root","root");
			PreparedStatement pst2 = con1.prepareStatement("insert into transactions (transaction_id,member_id,book_id,date_of_issue,due_date,return_date,amount) values (?,?,?,?,?,?,?)");
			 String query = "select count(*) from transactions";
			 Statement stmt = con1.createStatement();
		      //Executing the query
		      ResultSet rs3 = stmt.executeQuery(query);
		      rs.next();
		      int count = rs3.getInt(1);
			
			pst2.setInt(1, count+1);
			pst2.setInt(2, rs1.getInt("member_id"));
			pst2.setInt(3, rs.getInt("book_id"));
			pst2.setDate(4, Date.valueOf(LocalDate.now()));
			pst2.setDate(5, Date.valueOf(LocalDate.now().plusDays(7)));
			//pst2.setString(6, pub);
			pst2.setInt(7, 35);
			int rowCount = pst2.executeUpdate();
			
			//minus 1 from available quantity
			PreparedStatement pst3= con1.prepareStatement("update books_info set available_quantity = available_quantity-1 where book_id = ?");
			pst3.setInt(1,rs.getInt("book_id"));
			pst3.executeLargeUpdate();
			
			
			
			PreparedStatement pst4= con1.prepareStatement("update member_records set number_of_books_issued = number_of_books_issued + 1 where member_id = ?");
			pst4.setInt(1,rs.getInt("member_id"));
			pst4.executeLargeUpdate();
			
			
    }catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			con1.close();
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
		String Id = request.getParameter("BookId");
		String uname = request.getParameter("Uname");
		
		
//		int bookID=0; //getbookId from ISSUE
//		String Id = request.getParameter("BookId");//get member_username from ISSUE page
//		String uname = request.getParameter("Uname");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group3_project?useSSL=false","root","root");
			PreparedStatement pst = con.prepareStatement("select * from book_info where book_id=?");
			pst.setString(1, Id);
			
	
			ResultSet rs = pst.executeQuery();
			
			PreparedStatement pst1= con.prepareStatement("select * from member_records where member_username=?");
			pst1.setString(1, uname);
			ResultSet rs1= pst1.executeQuery();
			//PrintWriter outputk = response.getWriter();
			out.print("Hello");
			
			if(rs.next()&& rs.getInt("available_Quantity")>0) {
				if(rs1.next()&& rs1.getInt("max_issue_limit")>rs.getInt("number_of_books_issued")) {
					issue(rs, rs1);
				}
				//session.setAttribute("name", rs.getString("uname"));
				//dispatcher = request.getRequestDispatcher("books.jsp");
			}else
			{
				request.setAttribute("status", "failed");
				//dispatcher = request.getRequestDispatcher("adminLogin.jsp");
			}
			
			
			
			//dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
	}

}
