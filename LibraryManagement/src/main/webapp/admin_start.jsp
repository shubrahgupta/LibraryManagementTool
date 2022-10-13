<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>
		Welcome Admin
	</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">


</head>

<body style="background-color:#d8dbe2;">


	<div class="wrapper">
		<header style="height: 100px; right:25px; width: 100%; background-color: #272932;">
		<div class="topnav">
		<div class="logo">
			<!--<img src="/26102.jpg"> --><br><br><br>
			<%-- <h1 style="color: white; font-size:40px">ONLINE LIBRARY MANAGEMENT SYSTEM</h1>--%>
			<h1 style="color: white; font-size:35px; height:25px; margin-left:10px">Welcome Admin!</h1><br><br><br>
		</div>
			<nav>
				<ul style="color: white; font-size:18px">
				
					<%--<li><a href="index.jsp">HOME</a></li>--%>
					<!-- <li><a href="books.html">BOOKS</a></li> -->
					<li><a href="index.jsp">LOG-OUT</a></li>
				</ul>
			</nav>
			</div>
		</header>
		<section>
		<div class="sec_img" >
			<br>		
			<br><br><br><br><br><br>
			<button  onclick="window.location.href = 'books.jsp';" style="width:500px;height:150px; font-size:30px;"><b>Add Book</b></button>
			<br>
			<br>
			<form name="login" action="AdminSeeTransaction" method="post">
        		<br><br>
        		<div class="login" align="center">  
                <button style="width:500px;height:150px; font-size:30px;"><b>See Transaction</b></button></div>
      </form>

		</div>
		</section>
		<footer>
	<p style="color:white;  text-align:center; font-size: 20px;font-family: 'Metropolis', sans-serif; width:100%;">
	<br>
	Email: 123456@genpact.com | Mobile: +91**********
	</p>
	</footer>

	</div>


</body>

</html>