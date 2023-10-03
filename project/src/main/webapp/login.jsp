<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  
	<link rel="stylesheet" href="css/login.css">
<title>Sign In</title>

</head>
<body>


<div id="id01" class="modal">
  
  <form class="modal-content animate" action="controller" method="post">
    <div class="imgcontainer">

      <span style="margin-left:10px " class="glyphicon glyphicon-user space btwn"></span>
  <br>
    </div>
<h1 style="margin-left: 38%";>LOGIN PLEASE</h1>
    <div class="container">
      <label for="uname"><b>Username</b></label><br>
      <input type="email" placeholder="Enter Username" name="uname" required><br>

      <label for="psw"><b>Password</b></label><br>
      <input type="password" placeholder="Enter Password" name="psw" required><br>
        
<div style="margin-left: 32.5%;">
<button type="submit" id="box"  name="ulogin"  class="btn btn-outline-success space top btwn">USER LOGIN</button>
<button type="submit" id="box"  name="alogin"  class="btn btn-outline-success space top btwn">ADMIN LOGIN</button>

</div>      
      
    </div>

    <div class="container" style="background-color:#f1f1f1; margin-left: 0px;">
      <button type="button" name="back" class="cancelbtn" onclick="location.href='index.jsp'">Back</button>
      <span class="psw"> If don't have account?<a href="register.jsp">SIGN UP</a> &nbsp|&nbsp <a href="forgotpassword.jsp">Forgot password</a></span>
    </div>
  </form>
</div>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</body>
</html>
