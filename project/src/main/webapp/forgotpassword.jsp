<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
<link rel="stylesheet" href="css/forgotpassword.css">

<title>Forgot Password</title>
<%--<%
 response.setHeader("Cache-Control"," no-store, no-cache");
 response.setHeader("Pragma","no-cache"); 
	response.setDateHeader ("Expires", -1);
 if(session.getAttribute("username")==null)
 {
	response.sendRedirect("index.jsp");
		
	/* RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	rd.forward(request, response); */
 }
%>--%>
</head>
<body>


 <div id="id01" class="modal">
  
  <form class="modal-content animate" action="controller" method="post">
    <div class="imgcontainer">

      
  <br>
    </div>
<h1 style="margin-left: 35%";>FORGOT PASSWORD</h1>
    <div class="container">
<h3 style="margin-left: 15%; margin-top:20px;">Enter the email to send the 6 digit OTP to be used as password.</h3>



    &nbsp<label class="space" >Email</label><br>
<input class="space btwn" type="email" name="email" placeholder="Email" required>

  
<div style="margin-left: 42%;">
<button type="submit" id="box"  name="send"  class="btn btn-outline-success space top btwn">SEND</button>

</div>         
    </div>

    <div class="container" style="background-color:#f1f1f1; margin-left: 0px;">
      <button type="button" name="back" class="cancelbtn" onclick="location.href='login.jsp'">Back</button>
    </div>
  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>



</body>
</html>
