<%@page import="rrs.beanservices.RRSstartPSVM"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/home.css">
<title>Railway Reservation System</title>

</head>
<body>

<%
	RRSstartPSVM s=new RRSstartPSVM();
	
	if(s.action==0)
	{
		RRSstartPSVM.main(null);
		s.action+=1;
	}
	
%>


<div class="topnav">

  <button onclick="location.href='index.jsp'"><i class="fa fa-fw fa-home"></i>RRS</button>
	<button class="modal-button" href="#myModal1">About Us</button>
  <button class="modal-button" href="#myModal2">Help</button>
  <a href="login.jsp" class="split">SIGN IN</a>&nbsp
  <a href="register.jsp" class="split">SIGN UP</a>

</div>

<img alt="rrs" src="image/index.png">



<h2>WELCOME </h2>
<h4>TO THE </h4>
<h3>RAILWAY RESERVATION SYSTEM</h3>




<button class="open-button" onclick="openForm()">SEARCH TRAIN</button>

<div class="form-popup" id="myForm">
  <form action="controller" method="post" class="form-container">
    <h1 style="margin-left: 35%;">SEARCH</h1>

    &nbsp<span class="glyphicon glyphicon-send space"></span>:
<input class="space btwn" type="text" name="from" placeholder="From" >
<label class="space" >Date</label>:
<input class="space" type="date" name="date" >

<br>&nbsp<span class="glyphicon glyphicon-map-marker space"></span>:
<input class="space btwn" type="text" name="to" placeholder="To" >
<label class="space">Train no</label>:
<input class="space" type="number" name="tno" placeholder="Train number" >

    
    <button type="submit" name="search" class="btn">SEARCH</button>
    <button type="button" name="trainlist" class="btn" onclick="location.href='searchtrain.jsp'">All TRAIN LIST</button>
    <button type="button"  class="btn cancel" onclick="closeForm()">CLOSE</button>
  </form>
</div>

<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>



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
      <p><span class="glyphicon glyphicon-envelope"></span> &nbsp:&nbsp xxxx@gmail.com</p>
      <p><span class="glyphicon glyphicon-phone-alt"></span>&nbsp:&nbsp  +91 xxxx647</p>
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



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
