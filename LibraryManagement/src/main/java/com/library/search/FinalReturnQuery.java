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



@WebServlet("/FinalReturnQuery")
public class FinalReturnQuery extends HttpServlet {
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
	//String Id = request.getParameter("BookId");
	String TId = request.getParameter("TransactionId");
	String uname = request.getParameter("Uname");
	//get transaction id from user
	//get member_id from the page
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group3_project?useSSL=false","root","root");
		
		PreparedStatement pst = con.prepareStatement("select * from transactions where  transaction_id =? ");
		pst.setString(1,TId);
		ResultSet rs = pst.executeQuery();	
		
		
		PreparedStatement pst1= con.prepareStatement("select * from member_records where member_username=?");
		pst1.setString(1, uname);
		ResultSet rs1= pst1.executeQuery();
//		PreparedStatement pst2 = con.prepareStatement("select * from books_info where  book_id =? ");
//		pst.setString(1,rs);
//		ResultSet rs2 = pst2.executeQuery();	
		//rs2.next();
		//rs.next();
		rs1.next();
		
		
		
		
		if(rs.next() ) {

				try {
					

					
					PreparedStatement pst2 = con.prepareStatement("select * from books_info where  book_id =? ");
					pst2.setInt(1,rs.getInt("book_id"));
					ResultSet rs2=pst2.executeQuery();	
					rs2.next();
					
					
					PreparedStatement pst5= con.prepareStatement("update transactions set return_date = CURDATE() where transaction_id = ? and member_id=?");
					pst5.setInt(1,rs.getInt(1));
					pst5.setInt(2,rs1.getInt(1));
					pst5.executeUpdate();
					
					
					//plus 1 from available quantity
					PreparedStatement pst3= con.prepareStatement("update books_info set available_quantity = available_quantity+1 where book_id = ?");
					pst3.setInt(1,rs2.getInt(1));
					pst3.executeUpdate();
					
					
					
					PreparedStatement pst4= con.prepareStatement("update member_records set number_of_books_issued = number_of_books_issued - 1 where member_id = ?");
					pst4.setInt(1,rs1.getInt(1));
					pst4.executeUpdate();
					
					
					PreparedStatement pst6= con.prepareStatement("update transactions set transaction_status=1 where transaction_id = ? and member_id=?");
					pst6.setInt(1,rs.getInt(1));
					pst6.setInt(2,rs1.getInt(1));
					pst6.executeUpdate();

					out.print("<h1> Congrats! Book Returned Successfully </h1>");
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

//		}
		else
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
