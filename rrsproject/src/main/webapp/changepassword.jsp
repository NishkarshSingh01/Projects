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
    
<link rel="stylesheet" href="css/changepassword.css">

<title>Change Password</title>
</head>
<body>

 <div id="id01" class="modal">
  
  <form class="modal-content animate" action="controller" method="post">
    <div class="imgcontainer">

      
  <br>
    </div>
<h1 style="margin-left: 35%";>CHANGE PASSWORD</h1>
    <div class="container">

    &nbsp<label class="space" >New Password</label>
<input class="space btwn" type="password" name="password" placeholder="Password" >
<label class="space" >Confirm Password</label>
<input class="space" type="password" name="cpassword" placeholder="Confirm Password" >

   
<div style="margin-left: 40%;">
<button type="submit" id="box"  name="changep"  class="btn btn-outline-success space top btwn">CHANGE PASSWORD</button>

</div>         
    </div>

    <div class="container" style="background-color:#f1f1f1; margin-left: 0px;">
      <button type="submit" name="back" class="cancelbtn">Back</button>
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