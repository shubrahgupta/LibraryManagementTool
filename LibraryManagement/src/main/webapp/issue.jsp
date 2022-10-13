<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>
		Issue/Return
	</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">


</head>

<body style="background-color:#d8dbe2;">


 	<!--String Uname = <%= request.getAttribute("name")%>;  -->
	<div class="wrapper">
		<header style="height: 100px; right:25px; width: 100%; background-color: #272932;">
		<div class="topnav">
		<div class="logo">
			<!--<img src="/26102.jpg"> --><br><br><br>
			<h1 style="color: white; font-size:30px; height:25px; margin-left:10px">Welcome <%= request.getAttribute("name")%></h1><br><br><br>
		</div>
		<div class="topnav-right">
			<nav>
				<ul style="color: white; font-size:18px">
				
					<li><a href="index.jsp">HOME</a></li>
					<!-- <li><a href="books.html">BOOKS</a></li> -->
					<li><a href="StudentLogin.jsp">STUDENT-LOGIN</a></li>
				</ul>
			</nav>
			</div></div>
		</header>
		<section>
		<div class="sec_img">
			<br>				
			<div class="box2issue">
			
			        <div class = "issuebox" style=" float: left; border-color: green;"> 
			        		<br><br><h1 style="text-align: center; font-size: 32px; font-family: 'Metropolis', sans-serif;">ISSUE</h1><br>
			        		<hr style="background-color:green">
				        	
				        	<p style="color: white; padding-left: 10px;" align="center">
        <img src="search.png" alt="Library"  width="100px" height="100px" >
      </p>
				        	<form name="issue1" action="searchServletFinal" method="post" style="margin-top:10px">  
							<h1 style="text-align: center; font-size: 20px;">Search for the book</h1><br>
							
							
							<div class="login1" align="center">
							<input type="hidden" name="Uname"  value = <%= request.getAttribute("name")%>>
							
							
			          		<input type="text" name="BookName" placeholder="    Please enter Book name"  required="required" style="border-radius: 5px; width:350px;">
			          		
			          		<input type="submit" value="search"style="border-radius: 5px; width:350px; margin-top:15px;">
			          		
							</div>
							</form>
					</div></div>
					<div class="vertical" style="width: 1%;">
					
					</div>
					<div class="box2return" style="float:right">
			        <div class = "returnbox" style="border-color: green;"> 
			        		<br><br><h1 style="text-align: center; font-size: 32px; font-family: 'Metropolis', sans-serif;">RETURN</h1><br>
			        		<hr style="background-color:green">
			        		<br>
			        		<p style="color: white; padding-left: 10px;" align="center">
        <img src="return.png" alt="Library"  width="134px" height="74px" >
      </p>
			        		
				        	<form name="return1" action="FinalReturnQuery" method="post" style="margin-top:25px">  
							<h1 style="text-align: center; font-size: 20px;">Return the book</h1><br> 
							
							
							<div class="login1" align="center">
							<input type="hidden" name="Uname"  value = <%= request.getAttribute("name")%>>
			          		<input type="text" name="TransactionId" placeholder="    Please enter transaction id"  required="required" style="border-radius: 5px; width:350px;"> <br><br> 
			          		
			          		<input type="submit" value="Return" style="border-radius: 5px; width:350px;">
			          		
							</div>
							</form>
					</div></div>
								

			
				

				<%--<h1 style="text-align: center;font-size: 25px;">Opens at: 09:00 AM | Closes at: 05:00 PM</h1><br>--%>
				
				


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