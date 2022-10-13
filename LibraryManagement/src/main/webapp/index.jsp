<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>
		Online Library Management System
	</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">


</head>

<body style="background-color:#d8dbe2">


	<div class="topnav" >
		<div class="logo"><br><br><br>
			<h1 style="color: white; font-size:30px; height:25px; margin-left:10px">ONLINE LIBRARY MANAGEMENT SYSTEM</h1>
		</div>
		<div class="topnav-right">
			<nav>
				<ul style="color: white; font-size:18px">
					<li><a href="index.jsp">HOME</a></li>
					<!-- <li><a href="books.html">BOOKS</a></li> -->
					<li><a href="StudentLogin.jsp">STUDENT-LOGIN</a></li>
					<li><a href="adminLogin.jsp">ADMIN-LOGIN</a></li>
				</ul>
			</nav>
			</div></div>
			<br><br><br><br><br>
			
			<p align=center style="color:black; font-size:64px; font-style: bold; font-weight: bold; font-family: Open Sans, sans-serif;"> Welcome to Genpact Library </p>
			<p style="width: 50%; height: 2px;background-color:black;margin-bottom: 7px;margin-right: auto;margin-left: auto;margin-top: 35px;border-width: 4px;border-color: blue;" >
			</p>
			<p align=center style="color:black; margin-top: 25px; font-size:18px; font-family: Open Sans, sans-serif;">It always seems impossible until it's done. - Nelson Mandela </p>
			<img src="firstpage.png" alt="Library" align="right" width="630px" height="540px" style="margin-right:40px">
		<section style="text-align: center;">
		<div class="sec_img" >
			<br><br><br>
			<div class="box" style="text-align: center;">
				<br><br><br><br>
				<h1 style="text-align: center;font-size: 25px;font-family: Open Sans, sans-serif;">Opens at: 09:00 AM | Closes at: 05:00 PM</h1><br><br><br>
				<p style="width: 50%; height: 1px;background-color:white;margin-right: auto;margin-left: auto;border-width: 4px;border-color: blue;" >
			</p><br><br><br>
				<p style="text-align: center;font-size: 42px;font-family: Open Sans, sans-serif;"> Looking for a Book? </p>
				<br><br>
				<form name="search" action="searchServlet" method="post">  
				<h1 style="text-align: center; font-size: 20px; font-family: Open Sans, sans-serif;">Enter Book Name</h1><br> 
				
				
				<div class="login1" align="center">
				
          		<input type="text" name="BookName" placeholder="Please enter Book name" style="width:80%; border-radius: 10px;"> <br><br> 
          		
          		<input type="submit" value="Search" style="width:80%; border-radius: 10px;height:30px;">
				</div>
				</form>

			</div>
		</div>
		</section>
		<footer>
			<p style="color:white;  text-align: center; font-size: 20px;font-family: 'Metropolis', sans-serif; width:100%;">
				<br>
				Email: 123456@genpact.com | Mobile: +91**********
			</p>
		</footer>
	

</body>

</html>