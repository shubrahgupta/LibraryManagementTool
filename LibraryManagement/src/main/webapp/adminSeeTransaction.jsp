<%@page import ="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction</title>
</head>
<body>
<input type="hidden" id ="status" value="<%= request.getAttribute("status") %>">
<% 
	ResultSet rs= (ResultSet)request.getAttribute("list");
	ResultSetMetaData rsmd = rs.getMetaData();
			int totalColumn =  rsmd.getColumnCount();
			%>
						<h2 style="text-align:center">Transactions Details: </h2>
			<div class="pragya" style="    margin: 10px;
    /* align-items: center; */
    text-align: center;
    margin-left: 253px;
    margin-right: 253px;
    margin-top:40px">
    
			<table class="styled-table" style="border=1; font-family: Open Sans, sans-serif;">
			

			<thead>
			<tr bgcolor="black" style="color:white;">
			<% 
			
			for(int i = 1;i<=totalColumn;i++)
			{
			%>
			<th style="padding:10px;">
			<%= rsmd.getColumnName(i) %>
			
			</th>
			<% 	
			
				
			}
			int temp=0;
		
			%>
			</tr>
				</thead>
				<tbody>
			<tr>
			<%
			//out.print("<tr>");
			
			
			
			while(rs.next()) {
				temp++;
				%>
				<tr bgcolor="#90EE90">
					<td style="padding:5px;"><%=rs.getInt(1)%></td>
					<td style="padding:5px;"><%= rs.getInt(2)%></td>
					<td style="padding:5px;"><%=rs.getInt(3) %></td>
					<td style="padding:5px;"><%=rs.getDate(4) %></td>
					<td style="padding:5px;"><%=rs.getDate(5) %></td>
					<td style="padding:5px;"><%=rs.getDate(6) %></td>
					<td style="padding:5px;"><%=rs.getInt(7) %></td>
					<td style="padding:5px;"><%=rs.getInt(8) %></td>
				</tr>	
			<%
			}
			
			%>
							</tbody>
			</table>
			</div>
			<button style="margin-left: 700px; text-align:center" onclick="window.location.href = 'admin_start.jsp';"><b>Back</b></button>

			<br>
			
			
	
					
</body>
</html>