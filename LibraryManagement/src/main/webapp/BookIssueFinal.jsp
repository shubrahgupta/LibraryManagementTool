<%@page import ="java.sql.*"%>
<%@page import ="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Issue</title>
</head>
<body>
<div class="bg">
<input type="hidden" id ="status" value="<%= request.getAttribute("status") %>">
<% 
	ResultSet rs= (ResultSet)request.getAttribute("book");
	ResultSetMetaData rsmd = rs.getMetaData();
			int totalColumn =  rsmd.getColumnCount();
		      ArrayList<String> col_name = new ArrayList<String>();
		      col_name.add("Book ID");
		      col_name.add("Book Name");
		      col_name.add("Author");
		      col_name.add("Price");
		      col_name.add("Category");
		      col_name.add("Publisher");
		      col_name.add("Total Quantity");
		      col_name.add("Available Quantity");
			%>
			
			<h2 style="text-align:center">Book Result: </h2>
			<div class="pragya" style="    margin: 10px;
    /*width: 80%;*/
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
			<%=rsmd.getColumnName(i)
			%>
			
			</th>
			<% 	
			//out.print("<th>"+rsmd.getColumnName(i)+"</th>");
				
			}
			int temp=0;
		
			%>
			</tr>
			<tr>
			<%
			//out.print("<tr>");
			
			
			
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
				<%
			}
		

			%>
			</table>
			</div>
			<br>
			
			
	
					<form name="login" action="FinalQuery" method="post">
					<div style="text-align:center">
					<h3> Book id: </h3> <input type="number" name="BookId">
					</div>
					<input type="hidden" name="Uname"  value = <%= request.getAttribute("name")%>>
					<button style="margin-left: 740px; text-align:center; margin-top:20px"> Issue</button>
					</form>
					
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">


<script type = "text/javascript">
	var status = document.getElementById("status").value;
	if(status == "success"){
		swal("Congrats","Book Added Successfully");
	}
</script>
</div>
</body>
</html>