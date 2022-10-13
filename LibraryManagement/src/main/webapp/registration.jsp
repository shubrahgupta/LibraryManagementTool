<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>

  <title>Student Registration</title>
  <link rel="stylesheet" type="text/css" href="style.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	function letters_numbers_spaces_dashes(str) {
		return /^[A-Za-z0-9 -]+$/.test(str);
	}
	
	function letters_numbers_special(str) {
		return /^[A-Za-z0-9!@]+$/.test(str);
	}
	
	function letters_numbers(str) {
		return /^[A-Za-z0-9]+$/.test(str);
	}
	
	function letters(str) {
		return /^[A-Za-z]+$/.test(str);
	}
	
	function validate()
    {
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var first_name = document.getElementById("firstName").value;
		var last_name = document.getElementById("lastName").value;
		
		//var current_date = new Date();
		//var temp = document.getElementById("dob").value;
		//var dob = new Date(temp);
		//var difference = current_date - dob;
		//var difference_in_years = Math.floor(difference / (1000 * 60 * 60 * 24 * 365.25));
		
        var valid = true;
        if(letters_numbers(username) == false) {
        	alert("Username : Only numbers and Alphabets permitted");
        	valid = false;
        }
        if(letters_numbers_special(password) == false) {
        	alert("Password : Only numbers, alphabets, ! and @ permitted");
        	valid = false;
        }
        if(letters(first_name) == false) {
        	alert("First Name : Only alphabets permitted");
        	valid = false;
        }
        if(letters(last_name) == false) {
        	alert("Last Name : Only alphabets permitted");
        	valid = false;
        }
        
        
        return valid;
    };
</script>

  
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
<br><br><br>
<p style="width: 50%; height: 1px;background-color:black;margin-bottom: 7px;margin-right: auto;margin-left: auto;margin-top: 35px;border-width: 4px;border-color: blue;" >
			</p>
<p align=center style="color:black; margin-top: 25px; font-size:36px; font-family: Open Sans, sans-serif;">Today a Reader, Tomorrow a Leader.  </p><br>
<p style="width: 50%; height: 1px;background-color:black;margin-top: 7px;margin-right: auto;margin-left: auto;margin-bottom: 7px;border-width: 1px;border-color: blue;" >
			</p>
<section>
<p style="color: white; padding-left: 10px;" align="center">
        <img src="register.png" alt="Library" align="right" width="591px" height="422px" style="margin-right:100px">
      </p>
    <div class="box2">
        <br>
        <h1 style="text-align: center; font-size: 32px; color:white; margin-left:0px; font-family: Open Sans, sans-serif;">User Registration Form</h1><br><br>
        <h2 style="text-align: center; font-size: 15px; color:white; font-family: 'Metropolis', sans-serif; font-style:Thin;"> New User? Register Here</h2>
      <form name="Registration" action="RegistrationServlet" method="post"  onsubmit="return validate();">
        <br><br>
        <div class="login"  align="center">
         <b style="color:white; font-family: 'Metropolis', sans-serif; font-style:Thin;">First Name:</b>
          <input id="firstName" type="text" name="first" placeholder="First Name"  pattern="[A-Za-z]{1,32}" required style="height: 30px; width:380px; border-radius: 15px;"> <br><br>
          <b style="color:white; font-family: 'Metropolis', sans-serif; font-style:Thin;">Last Name:</b>
          <input id="lastName" type="text" name="last" placeholder="Last Name" pattern="[A-Za-z]{1,32}" required style="height: 30px; width:380px; border-radius: 15px; margin-left:20;"> <br><br>
          <b style="color:white; font-family: 'Metropolis', sans-serif; font-style:Thin;">Username:</b>
          <input id="username" type="text" name="username" placeholder="Username" pattern="^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$" required style="height: 30px; width:380px; border-radius: 15px; margin-left:20;"> <br><br>
          <b style="color:white; font-family: 'Metropolis', sans-serif; font-style:Thin;">Password:</b>
          <input type="password" name="password" placeholder="Password" required style="height: 30px; width:380px; border-radius: 15px; margin-left:20;"> <br><br>
          <b style="color:white; font-family: 'Metropolis', sans-serif; font-style:Thin;">Contact:</b>
           <input id="phone"type="tel" name="contact" placeholder="Contact"  pattern="[0-9]{10}" required style="height: 30px; width:380px; border-radius: 15px; margin-left:20;margin:1px;"><br><br>
			<b style="color:white; font-family: 'Metropolis', sans-serif; font-style:Thin;">Email:</b>
          <input id="email" type="email" name="email" placeholder="Email" required style="height: 30px; width:380px; border-radius: 15px; margin-left:20;margin:11px;"><br><br>
          

          <input id="submit" type="submit" name="" value="Sign Up" style="height: 43px;
    width: 300px;
    border-radius: 12px;"></div>
      </form>
     
    </div>
</section>
<br><br>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">


<script type = "text/javascript">
	var status = document.getElementById("status").value;
	if(status == "success"){
		swal("Congrats","Member Added Successfully");
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