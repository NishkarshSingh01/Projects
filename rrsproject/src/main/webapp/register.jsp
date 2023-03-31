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
  
	<link rel="stylesheet" href="css/register.css">
<title>Sign UP</title>

</head>
<body>

<div id="id01" class="modal">
  
  <form class="modal-content animate" action="controller" method="post">
    <div class="imgcontainer">

      <span style="margin-left:10px " class="glyphicon glyphicon-user space btwn"></span>
  <br>
    </div>
<h1 style="margin-left: 33%";>REGISTER YOURSELF</h1>
    <div class="container">
    <label><span class="glyphicon glyphicon-envelope space"></span></label>:
<input class="space btwn" type="email" name="email" placeholder="Email" required>
<label class="space">Name</label>:
<input class="space btwn" type="text"  name="name" placeholder="Name" required>

<br><label><span class="glyphicon glyphicon-phone-alt space"></span></label>:
<input class="space btwn" type="text" placeholder="Phone No" name="phoneno" required>
<label class="space">Nationality</label>:
<input class="space" type="text" placeholder="Nationality" name="nationality" required>

<br><label>Marital Status&nbsp</label>:&nbsp<select class="space btwn" name="marital" required>
<option value="">Status</option>
<option value="Married">Married</option>
<option value="Unmarried">Unmarried</option>
</select>
<label class="space">Age</label>:
<input class="space" type="number" placeholder="Age" name="age" required>



<br><label class="space">Gender:</label>
<input class="space btwn" type="radio" value="Male" name="gender" >Male
<input class="space btwn" type="radio" value="Female" name="gender" >Female
<input class="space btwn" type="radio" value="Transgender" name="gender" >Transgender
<label><span style="margin-left:10px " class="glyphicon glyphicon-user space btwn"></span></label>:
<select class="space left" name="type" required >
<option value="">Register As</option>
<option value="User">User</option>
<option value="Admin">Admin</option>
</select>


<br><label class="space" >Birth Date</label>:
<input class="space btwn"  name="dob" type="date" required>
<label class="space">Address</label>:
<input class="space" type="text" name="address" placeholder="Address" required>

<br><label class="space" >New Password</label>:
<input class="space" type="password" name="password" placeholder="Password" required>
<label class="space" >Confirm Password</label>:
<input class="space" type="password" name="cpassword" placeholder="Confirm Password" required>


<div style="margin-left: 42%;">
<button type="submit" id="box"  name="register"  class="btn btn-outline-success space top btwn">REGISTER</button>

</div></div>

    <div class="container" style="background-color:#f1f1f1; margin-left: 0px;">
      <button type="button" name="back" class="cancelbtn" onclick="location.href='index.jsp'">Back</button>
      <span class="psw"> If already have account? <a href="login.jsp">SIGN IN</a></span>
    </div>
  </form>
</div>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</body>
</html>