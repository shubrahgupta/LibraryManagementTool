package com.library.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		
//		ArrayList<BooksValue> BL = new ArrayList<BooksValue>();
//		
//		String Bname = request.getParameter("BookName");
//		Connection con = null;
//		try {
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group3_project?useSSL=false","root","Yogesh@1234");
//			PreparedStatement pst = con.prepareStatement("select * from books_info where  book_name =? ");
//			PreparedStatement pst1 = con.prepareStatement("SET SQL_SAFE_UPDATES = 0 UPDATE group3_project.books_info SET total_quantity = total_quantity -1 WHERE book_name = ? SET SQL_SAFE_UPDATES = 1 ");
//					
//			pst.setString(1,Bname);
//			pst1.setString(1,Bname);
//			
//			out.print("<table width= 75% border=1>");
//			out.print("<h2 style=\"text-align: center;\">Book Storage</h2>");
//	
//			ResultSet rs = pst.executeQuery();
//		
//			
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int totalColumn =  rsmd.getColumnCount();
//			out.print("<tr>");
//			for(int i = 1;i<=totalColumn;i++)
//			{
//				out.print("<th bgcolor=\"#87CEFA\">"+rsmd.getColumnName(i)+"</th>");
//				
//			}
//			
//		
//			int temp = 0;
//			
//			
//			
//			out.print("<tr>");
//			
//			
//			while(rs.next()) {
//				temp++;
//				out.print("<tr bgcolor=\"#90EE90\" ><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td><button onclick=\"window.location.href = 'StudentLogin.jsp';\"><b>ISSUE</b></button></td></tr>");
//			}
//			
//			
//			
//			
//			if(temp<=0)
//			{
//				out.print("<br>");
//				out.print("<tr bgcolor=\"red\" ><td><h4>No Record Found</h4></td><td><h4>No Record Found</h4></td><td><h4>No Record Found</h4></td><td><h4>No Record Found</h4></td><td><h4>No Record Found</h4></td><td><h4>No Record Found</h4></td><td><h4>No Record Found</h4></td></tr>");
//			}
//			out.print("</table>");
//			
//			
//			ResultSet rs1 = pst.executeQuery();
//			while(rs1.next()) {
//				BooksValue bk = new BooksValue();
//				bk.setId(rs1.getInt(1));
//				bk.setAuthor(rs1.getString(2));
//				bk.setName(rs1.getString(3));
//				bk.setPrice(rs1.getInt(4));
//				bk.setCat(rs1.getString(5));
//				bk.setPubName(rs1.getString(6));
//				bk.setQuantity(rs1.getInt(7));
//				BL.add(bk);
//			}
//			request.setAttribute("Data",BL);
//			request.getRequestDispatcher("issue.jsp");
//			
//			
//			
//		}catch(Exception e)
//		{
//			out.print(e);
//		}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ArrayList<BooksValue> BL = new ArrayList<BooksValue>();
		
		String Bname = request.getParameter("BookName");
		Connection con = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/group3_project?useSSL=false","root","root");
			PreparedStatement pst = con.prepareStatement("select * from books_info where  book_name LIKE ?");
			pst.setString(1, "%" + Bname + "%");
			
			ResultSet rs = pst.executeQuery();
			
			request.setAttribute("book", rs);
			RequestDispatcher rd=request.getRequestDispatcher("bookIssue.jsp");
			rd.forward(request, response);
			
			ResultSet rs1 = pst.executeQuery();
			while(rs1.next()) {
				BooksValue bk = new BooksValue();
				bk.setId(rs1.getInt(1));
				bk.setAuthor(rs1.getString(2));
				bk.setName(rs1.getString(3));
				bk.setPrice(rs1.getInt(4));
				bk.setCat(rs1.getString(5));
				bk.setPubName(rs1.getString(6));
				bk.setQuantity(rs1.getInt(7));
				BL.add(bk);
			}
			request.setAttribute("Data",BL);
			request.getRequestDispatcher("issue.jsp");
			
			
		}catch(Exception e)
		{
			out.print(e);
		}
		
		
	}
		
		
	

}
