<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>

  <title>Add Books</title>
  <link rel="stylesheet" type="text/css" href="style.css">
  <link rel="stylesheet" href="alert/dist/sweetalert.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  
</head>
<body style="background-color:#d8dbe2;">
<input type="hidden" id ="status" value="<%= request.getAttribute("status") %>"> 
<header style="height: 100px; right:25px; width: 100%; background-color: #272932;">
 
<div class="topnav">
<div class="logo">
<br><br><br>
      <h1 style="color: white; font-size:30px; height:25px; margin-left:10px">ONLINE LIBRARY MANAGEMENT SYSTEM</h1>
</div>
	<div class="topnav-right">
      <nav>
        <ul style="color: white; font-size:18px">
          <li><a href="admin_start.jsp">Back</a></li>
          <!-- <li><a href="books.html">BOOKS</a></li>
          <li><a href="student_login.html">STUDENT-LOGIN</a></li>
          <li><a href="admin_login.html">ADMIN_LOGIN</a></li>
          <li><a href="">FEEDBACK</a></li> -->
        </ul>
      </nav>
      </div>
</div>
</header>
<section>
<p style="color: white; padding-left: 10px;" align="center">
        <img src="addbook.webp" alt="Library" align="right" width="639px" height="450px" style="margin-right:100px; margin-top:150px;">
      </p>
    <br> <br><br>
    <div class="box33" align="left">
    <br><br>
        <h1 style="text-align: center; font-size: 40px; color:white; margin-left:0px; font-family: Open Sans, sans-serif;">Add a new book</h1><br>
        <h1 style="text-align: center; font-size: 15px; color:white; font-family: 'Metropolis', sans-serif; font-style:Thin;">(All the fields are required.)</h1>
      <form name="login" action="BookServlet" method="post">
        <br><br>
        <div class="login" align="left">

         
	          
          <b style="color:white;">Book name:&nbsp;&nbsp;&nbsp;&nbsp;</b>
          <input type="text" name="Book_Name" placeholder="     Book Name" required style="border-radius: 15px;margin:10px;" > <br><br>	  
		  <b style="color:white;">Author:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
          <input type="text" name="Author" placeholder="     Author" required style="border-radius: 15px;margin:10px;" > <br><br>

		  
		  <b style="color:white;">Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
          <input type="text" name="Price" placeholder="     Price" required style="border-radius: 15px;margin:10px;"> <br><br>
		  
		  <b style="color:white;">Category:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
          <input type="text" name="Category" placeholder="     Category" required style="border-radius: 15px;margin:10px;"> <br><br>
          
          <b style="color:white;">Publication:&nbsp;&nbsp;&nbsp;</b>
          <input type="text" name="Publication" placeholder="     Publication" required style="border-radius: 15px;margin:10px;"> <br><br>
          
          <b style="color:white;">Quantity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
          <input type="text" name="Quantity" placeholder="     Quantiy" required style="border-radius: 15px;margin:10px;"> <br><br>
          
          </div>
          <button style="width: 50%;
    border-radius: 10px;
    height: 30px;
    margin-left: 150px;
    margin-top: 7px;"
 id="myBtn">Add Book</button>
          
      </form>
      
    </div>
</section>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	


<script type = "text/javascript">
	var status = document.getElementById("status").value;
	if(status == "success"){
		swal("Congrats","Book Added Successfully");
	}
</script>
<br><br><br><br><br><br><br>
<footer>
	<p style="color:white;  text-align:center; font-size: 20px;font-family: 'Metropolis', sans-serif; width:100%;">
	<br>
	Email: 123456@genpact.com | Mobile: +91**********
	</p>
	</footer>
</body>
</html>