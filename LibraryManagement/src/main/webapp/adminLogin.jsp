<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

  <title>Admin Login</title>
  <link rel="stylesheet" type="text/css" href="style.css">
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
	<li><a href="index.jsp">HOME</a></li>
	<!-- <li><a href="">BOOKS</a></li> -->
	<li><a href="StudentLogin.jsp">STUDENT-LOGIN</a></li>
	<!-- <li><a href="">FEEDBACK</a></li> -->
	</ul>
</nav>
</div></div>
</header>
<section>
  <div class="log_img_admin">
    <br>
       <p style="color: white; padding-left: 10px;" align="center">
        <img src="adminlogin.png" alt="Library" align="right" width="600px" height="580px" style="margin-right:150px">
      </p>
    <div class="box1" style="margin-top:60px;">
        <h1 style="text-align: center; font-size: 45px; color:white; text-align:center; margin-left:0px; margin-top:25px; font-family: Open Sans, sans-serif;">Welcome</h1><br><br>
        <h1 style="text-align: center; font-size: 25px; color:white; text-align:center; margin-left:0px; font-family: Open Sans, sans-serif;">Admin Login</h1>
      <form name="login" action="AdminLog" method="post">
        <br><br>
        <div class="login" align="left">
        <b style="color:white; font-family: 'Metropolis', sans-serif; font-style:Thin;">Username:</b>
          <input type="text" name="username" placeholder="Username" required="" style="height: 30px; width:380px; border-radius: 15px; margin-left:20;"> <br><br><br>
          <b style="color:white; font-family: 'Metropolis', sans-serif; font-style:Thin;">Password:</b>
          <input type="password" name="password" placeholder="Password" required="" style="height: 30px; width:380px; border-radius: 15px; margin-left:20;"> <br><br><br>
          <button onclick="window.location.href = 'books.html';" style="height:40px; width:380px; align:center; margin-left:2px; border-radius: 15px;">Login</button>
        </div>
      </form>
    </div>
  </div>
</section>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">


<script type = "text/javascript">
	var status = document.getElementById("status").value;
	if(status == "failed"){
		swal("Sorry","Wrong Username or Password");
	}
	if(status == "invalidEmail"){
		swal("Sorry","Please provide Username");
	}
	if(status == "InvalidPwd"){
		swal("Sorry","Please provide Password");
	}
	
</script>

<footer>
	<p style="color:white;  text-align:center; font-size: 20px;font-family: 'Metropolis', sans-serif; width:100%;">
	<br>
	Email: 123456@genpact.com | Mobile: +91**********
	</p>
	</footer>

</body>
</html>