<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<link rel="stylesheet" href="css/loggedin.css">

<title>Admin Logged IN</title>
<%
 response.setHeader("Cache-Control"," no-store, no-cache");
 response.setHeader("Pragma","no-cache"); 
	response.setDateHeader ("Expires", -1);
 if(session.getAttribute("username")==null)
 {
	response.sendRedirect("index.jsp");
		
	/* RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	rd.forward(request, response); */
 }
%>
</head>
<body background="white">

<div class="topnav">
  <button onclick="location.href='index.jsp'"><i class="fa fa-fw fa-home"></i>RRS</button>
	<button class="modal-button" href="#myModal1">About Us</button>
  <button class="modal-button" href="#myModal2">Help</button>
  
 
</div>
  
 
<div class="dropdown"  style="float:right;">
  <button id="btn1" class="btn" class="dropbtn"><span class="glyphicon glyphicon-user space btwn"></span><%=session.getAttribute("username") %> ☰ </button>
  <div class="dropdown-content">
    <h6>Admin</h6>
   <form action="controller" method="post">
  <button id="btn1" type="submit" name="profileview" class="btn"><%=session.getAttribute("username") %></button>
  </form>
  <a href="updateprofile.jsp">Update Profile</a>
  <a href="changepassword.jsp">Change Password</a>
  <form action="controller" method="post">
  <button id="btn1" type="submit" name="signout" class="btn">SIGN OUT</button>
  </form>
  </div>
</div>



<div class="form">
<h1 style="margin-left:25%;margin-top: 0.5%;" >WELCOME</h1>

<form action="controller" method="post">
<label class="space">Name</label>:
<input class="space btwn" type="text" placeholder="Name" name="name" >
<label class="space">Age</label>:
<input class="space " type="number" placeholder="Age" name="age" >

<br><span class="glyphicon glyphicon-phone-alt space"></span>:
<input class="space btwn" type="text" placeholder="Phone No" name="phoneno" >
<label class="space">Nationality</label>:
<input class="space" type="text" placeholder="Nationality" name="nationality" >

<br><label class="space">Gender:</label>
<input class="space btwn" type="radio" value="Male" name="gender">Male
<input class="space btwn" type="radio" value="Female" name="gender">Female
<input class="space btwn" type="radio" value="Transgender" name="gender">Transgender

<hr class="hr"><label class="space">Train Name</label>:
<input class="space btwn" type="text" placeholder="train name" name="tname" >
<label class="space">Train Number</label>:
<input class="space " type="number" placeholder="train no" name="tno" >

<br><span class="glyphicon glyphicon-send space"></span>:
<input class="space btwn" type="text" name="from" placeholder="From" >
<label class="space" >Date</label>:
<input class="space" type="date" name="date" >

<br><span class="glyphicon glyphicon-map-marker space"></span>:
<input class="space btwn" type="text" name="to" placeholder="To" >

<br><span class="glyphicon glyphicon-th-large space "></span>:&nbsp
<select class="space bwtn" name="category" >
<option value=""><b>Category</b></option>
<option value="General">General</option>
<option value="Tatkal">Tatkal</option>
<option value="Ladies">Ladies</option>
<option value="Old citizen">Old Citizen</option>
</select>
<span class="glyphicon glyphicon-briefcase space"></span>&nbsp:
<select class="space" name="class" >
<option value="">Classes</option>
<option value="2S">2S</option>
<option value="SL">SL</option>
<option value="AC">AC</option>
</select>

<div style="margin-left:5%;">
<button type="submit" id="box"  name="search"  class="btn btn-outline-success space ">SEARCH</button>
<button type="submit" id="box"  name="reserve"  class="btn btn-outline-success space ">RESERVE</button>
<button type="submit" id="box"  name="reserved"  class="btn btn-outline-success space ">RESERVED INFO</button>
<button type="submit" id="box"  name="modify"  class="btn btn-outline-success space ">MODIFY</button>
</div>
</form>
</div>




<!-- The Modal for about us -->
<div id="myModal1" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
     
    </div>
    <div class="modal-body">
    	<center> <h2>About Us</h2></center>
      <p>Jay Shree Krishna</p>
      <p>I am Udit Narayan Ray and I am a backend developer and use JAVA to make projects.</p>
      <p>This is just a simple working model of railway reservation system made by implementing jersey RESTful web services of maven project which is designed using HTML, CSS, JSP in frontend and Java, Servlet, JDBC in backend.</p>
      <p>This is the project i have chosen for the Software Engineering lab and completed it to some extent.</p>
    </div>
    <div class="modal-footer">
      <h3>Thank You</h3>
    </div>
  </div>

</div>


<!-- The Modal for about us -->
<div id="myModal2" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
    
    </div>
    <div class="modal-body">
     <center> <h2>Help</h2></center>
      <p>Jay Shree Krishna</p>
     <p>For any help assistance please give your queries through the contact share below.</p>
      <p><span class="glyphicon glyphicon-envelope"></span> &nbsp:&nbsp xxx@gmail.com</p>
      <p><span class="glyphicon glyphicon-phone-alt"></span>&nbsp:&nbsp  +91 xxx674</p>
    </div>
    <div class="modal-footer">
      <h3>Thank You</h3>
    </div>
  </div>

</div>



<script>
// Get the modal
var modals = document.querySelectorAll('.modal');


// Get the button that opens the modal
var btn = document.querySelectorAll("button.modal-button");


// Get the <span> element that closes the modal
var spans = document.getElementsByClassName("close");

//var span= document.getElementsByClassName("close1")[1];

// When the user clicks the button, open the modal 
for (var i = 0; i < btn.length; i++) {
 btn[i].onclick = function(e) {
    e.preventDefault();
    modal = document.querySelector(e.target.getAttribute("href"));
    modal.style.display = "block";
 }
}
//btn1.onclick = function() {
//	  modal1.style.display = "block";
	//}

// When the user clicks on <span> (x), close the modal
for (var i = 0; i < spans.length; i++) {
 spans[i].onclick = function() {
    for (var index in modals) {
      if (typeof modals[index].style !== 'undefined') modals[index].style.display = "none";    
    }
 }
}
//span1.onclick = function() {
//	  modal1.style.display = "none";
//} 


// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target.classList.contains('modal')) {
     for (var index in modals) {
      if (typeof modals[index].style !== 'undefined') modals[index].style.display = "none";    
     }
    }
}
</script>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
