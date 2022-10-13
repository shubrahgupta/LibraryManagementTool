<%@page import ="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Search</title>
</head>
<body>
<% 
	ResultSet rs= (ResultSet)request.getAttribute("book");
	ResultSetMetaData rsmd = rs.getMetaData();
			int totalColumn =  rsmd.getColumnCount();
			%>
			<h2 style="text-align:center">Book Result: </h2>
			<div class="pragya" style="    margin: 10px;
    /* align-items: center; */
    text-align: center;
    margin-left: 100px;
    margin-right: 100px;
    margin-top:40px">
    
			<table class="styled-table" style="border=1; font-family: Open Sans, sans-serif;">
				
				<thead>
					<tr bgcolor="black" style="color:white;">
					<% 
					//out.print("<tr>");
					
					//<h2 style="text-align: center;">Book Storage</h2>
					
					for(int i = 1;i<=totalColumn;i++)
					{
					%>
						<th>
						<%= rsmd.getColumnName(i) %>
						
						</th>
					<% 	
					//out.print("<th>"+rsmd.getColumnName(i)+"</th>");
						
					}
					int temp=0;
				
					%>
					</tr>
				</thead>
				<tbody>
					<tr>
					<%				
					
					while(rs.next()) {
						temp++;
						%>
						<tr bgcolor="#90EE90">
							<td><%=rs.getInt(1)%></td>
							<td><%= rs.getString(2)%></td>
							<td><%=rs.getString(3) %></td>
							<td><%=rs.getString(4) %></td>
							<td><%=rs.getString(5) %></td>
							<td><%=rs.getString(6) %></td>
							<td><%=rs.getString(7) %></td>
							<td><%=rs.getString(8) %></td>
		
						</tr>	
						<%
						}
					if(temp<=0)
					{
						%>
						
						<tr bgcolor="red">
							<td><h4>No Record Found</h4></td>
							<td><h4>No Record Found</h4></td>
							<td><h4>No Record Found</h4></td>
							<td><h4>No Record Found</h4></td>
							<td><h4>No Record Found</h4></td>
							<td><h4>No Record Found</h4></td>
							<td><h4>No Record Found</h4></td>
							<td><h4>No Record Found</h4></td>
						</tr>
						
						</table>
					<br>
					<h3> No book found, go back! </h3>
			<button onclick="window.location.href = 'index.jsp';"><b>Back</b></button>
						<%
					}
					else{%>
						</table>
						<br>
						<h3> Please Sign in to issue book </h3>
				<button onclick="window.location.href = 'StudentLogin.jsp';"><b>Sign In</b></button>
				<%
					}
				

					%>
</body>
</html>