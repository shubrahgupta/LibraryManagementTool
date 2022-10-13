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



@WebServlet("/FinalQuery")
public class FinalQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	 public void issue(ResultSet rs, ResultSet rs1) {
//		 
//		 
//	    	Connection con1 = null;
//			try {
//				
//				Connection con = null;
//				 String query = "select count(*) from transactions";
//			      //Executing the query
//				 Statement stmt = con.createStatement();
//			      ResultSet rs2 = stmt.executeQuery(query);
//			      //Retrieving the result
//			      rs2.next();
//			      int count = rs2.getInt(1);
//			      
////			      int ggs=rs1.getInt(1);
////			     System.out.println(ggs);
//				out.print("<h2>uname<h2>");
//				PreparedStatement pst2 = con.prepareStatement("insert into transactions(transaction_id,member_id,book_id,date_of_issue,due_date,return_date,amount) values(?,?,?,?,?,?,?) ");
//				pst2.setInt(1, count+1);
//				pst2.setInt(3, rs.getInt(1));
//				pst2.setInt(2, rs1.getInt(1));
//				//pst2.setInt(3, rs.getInt(1));
//				pst2.setDate(4, Date.valueOf(LocalDate.now()));
//				pst2.setDate(5, Date.valueOf(LocalDate.now().plusDays(7)));
//				//pst2.setDate(6, Date.valueOf(LocalDate.now().plusDays(7)));
//				pst2.setInt(7, 35);
//					
//				int rowCount = pst2.executeUpdate();
//				
//				
//				
//				
//				
//				//minus 1 from available quantity
//				PreparedStatement pst3= con1.prepareStatement("update books_info set available_quantity = available_quantity-1 where book_id = ?");
//				pst3.setInt(1,rs.getInt(1));
//				pst3.executeUpdate();
//				
//				
//				
//				PreparedStatement pst4= con1.prepareStatement("update member_records set number_of_books_issued = number_of_books_issued + 1 where member_id = ?");
//				pst4.setInt(1,rs.getInt(1));
//				pst4.executeUpdate();
//				
//				out.print("<h1> Congrats! Book Issued Successfully </h1>");
//				out.print("<button onclick=\"window.location.href = 'index.jsp';\"><b>Return to home page</b></button>");
//						
//				
//				
//				
//				
//			
//				
//				
//	    }catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				con1.close();
//			}catch(SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	RequestDispatcher dispatcher = null;
	Connection con = null;
	String Id = request.getParameter("BookId");
	String uname = request.getParameter("Uname");
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group3_project?useSSL=false","root","root");
		
		PreparedStatement pst = con.prepareStatement("select * from books_info where  book_id =? ");
		pst.setString(1,Id);
		ResultSet rs = pst.executeQuery();	
		
		PreparedStatement pst1= con.prepareStatement("select * from member_records where member_username=?");
		pst1.setString(1, uname);
		ResultSet rs1= pst1.executeQuery();
		rs.next();
		rs1.next();
		
		
		
		if( rs.getInt("available_Quantity")>0) {
			if(rs1.getInt("max_issue_limit")>rs1.getInt("number_of_books_issued")) {
				//issue(rs, rs1,);

		    	//Connection con1 = null;
				try {
					
					//Connection con = null;
					 String query = "select count(*) from transactions";
				      //Executing the query
					 Statement stmt = con.createStatement();
				      ResultSet rs2 = stmt.executeQuery(query);
				      //Retrieving the result
				      rs2.next();
				      int count = rs2.getInt(1);
				      
//				      int ggs=rs1.getInt(1);
//				     System.out.println(ggs);
					//PreparedStatement pst2 = con.prepareStatement("insert into transactions(transaction_id,member_id,book_id,date_of_issue,due_date,return_date,amount) values(?,?,?,?,?,?,?) ");
				      PreparedStatement pst2 = con.prepareStatement("insert into transactions(transaction_id,member_id,book_id,date_of_issue,due_date,return_date,amount,transaction_status) values(?,?,?,?,?,?,?,?) ");
				      pst2.setInt(1, count+1);
					pst2.setInt(3, rs.getInt(1));
					pst2.setInt(2, rs1.getInt(1));
					//pst2.setInt(3, rs.getInt(1));
					pst2.setDate(4, Date.valueOf(LocalDate.now()));
					pst2.setDate(5, Date.valueOf(LocalDate.now().plusDays(7)));
					pst2.setDate(6, Date.valueOf(LocalDate.now().plusDays(7)));
					pst2.setInt(7, 35);
					pst2.setInt(8,0);
						
					int rowCount = pst2.executeUpdate();
					
					
					
					
					
					//minus 1 from available quantity
					PreparedStatement pst3= con.prepareStatement("update books_info set available_quantity = available_quantity-1 where book_id = ?");
					pst3.setInt(1,rs.getInt(1));
					pst3.executeUpdate();
					
					
					
					PreparedStatement pst4= con.prepareStatement("update member_records set number_of_books_issued = number_of_books_issued + 1 where member_id = ?");
					pst4.setInt(1,rs1.getInt(1));
					pst4.executeUpdate();
					
					out.print("<h1> Congrats! Book Issued Successfully </h1>");
					out.print("<button onclick=\"window.location.href = 'index.jsp';\"><b>Return to home page</b></button>");
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
			else {
				out.print("<h2>Maximum issue limit reached</h2>");
			}
			//session.setAttribute("name", rs.getString("uname"));
			//dispatcher = request.getRequestDispatcher("books.jsp");
		}else
		{
			out.print("<h2>No available quantity left</h2>");
			request.setAttribute("status", "failed");
			//dispatcher = request.getRequestDispatcher("adminLogin.jsp");
		}
		
		
		
		
//		 String query = "select count(*) from transactions";
//	      //Executing the query
//		 Statement stmt = con.createStatement();
//	      ResultSet rs2 = stmt.executeQuery(query);
//	      //Retrieving the result
//	      rs2.next();
//	      int count = rs2.getInt(1);
////	      int ggs=rs1.getInt(1);
////	     System.out.println(ggs);
//		out.print("<h2>uname<h2>");
//		PreparedStatement pst2 = con.prepareStatement("insert into transactions(transaction_id,member_id,book_id,date_of_issue,due_date,return_date,amount) values(?,?,?,?,?,?,?) ");
//		pst2.setInt(1, count+1);
//		pst2.setInt(3, rs.getInt(1));
//		pst2.setInt(2, rs1.getInt(1));
//		pst2.setInt(3, rs.getInt(1));
//		pst2.setDate(4, Date.valueOf(LocalDate.now()));
//		pst2.setDate(5, Date.valueOf(LocalDate.now().plusDays(7)));
//		pst2.setDate(6, Date.valueOf(LocalDate.now().plusDays(7)));
//		pst2.setInt(7, 35);
//			
//		int rowCount = pst2.executeUpdate();
//		
//		out.print("<h1> Congrats! Book Issued Successfully </h1>");
//		out.print("<button onclick=\"window.location.href = 'index.jsp';\"><b>Return to home page</b></button>");
					
		
	}catch(Exception e)
	{
		out.print(e);
	}
	}
}
