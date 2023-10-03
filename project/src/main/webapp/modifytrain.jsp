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
  
	<link rel="stylesheet" href="css/modifytrain.css">
<title>Train Details</title>
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
<body>

<div id="id01" class="modal">
  
  <form class="modal-content animate" action="modifytrain" method="post">
    <div class="imgcontainer">

      <span style="margin-left:10px " class="glyphicon icon-train space btwn"></span>
  <br>
    </div>
<h1 style="margin-left: 33%";>MODIFY TRAIN DETAILS</h1>
    <div class="container">
   <label class="space">Train Number</label>:
<input class="space btwn" type="number" placeholder="Train No" name="tno">
<label class="space">Train Name</label>:
<input class="space btwn" type="text"  name="tname" placeholder="Train Name" >

<br><label><span class="glyphicon glyphicon-send"></span></label>:
<input class="space" type="text" placeholder="From" name="from">
<label class="space"><span class="glyphicon glyphicon-map-marker"></span></label>:
<input class="space" type="text" placeholder="To" name="to">
<label class="space">Distance between the routes chosen</label>:
<input type="number" placeholder="Route Distance" name="distance">

<br><label class="space">Arrival Time</label>:
<input class="space btwn" type="text"  name="arrive" placeholder="Arrival Time" >
<label class="space">Departure Time</label>:
<input class="space btwn" type="text" placeholder="Departure Time" name="depart">

<br><label>Choose Running Days</label>:
<select class="space " name="rday1" >
<option value="no"><b>Monday</b></option>
<option value="Monday">Yes</option>
<option value="no">No</option>
</select>
<select class="space " name="rday2" >
<option value="no"><b>Tuesday</b></option>
<option value="Tuesday">Yes</option>
<option value="no">No</option>
</select>
<select class="space " name="rday3" >
<option value="no"><b>Wednesday</b></option>
<option value="Wednesday">Yes</option>
<option value="no">No</option>
</select>
<select class="space " name="rday4" >
<option value="no"><b>Thursday</b></option>
<option value="Thursday">Yes</option>
<option value="no">No</option>
</select>
<select class="space " name="rday5" >
<option value="no"><b>Friday</b></option>
<option value="Friday">Yes</option>
<option value="no">No</option>
</select>
<select class="space " name="rday6" >
<option value="no"><b>Saturday</b></option>
<option value="Saturday">Yes</option>
<option value="no">No</option>
</select>
<select class="space " name="rday7" >
<option value="no"><b>Sunday</b></option>
<option value="Sunday">Yes</option>
<option value="no">No</option>
</select>


<div style="margin-left: 22%;">
<button type="submit" id="box"  name="addtrain"  class="btn btn-outline-success space top btwn">ADD TRAIN</button>
<button type="submit" id="box"  name="updatetrain"  class="btn btn-outline-success space top btwn">UPDATE TRAIN</button>
<button type="submit" id="box"  name="removetrain"  class="btn btn-outline-success space top btwn">REMOVE TRAIN</button>
</div></div>

    <div class="container" style="background-color:#f1f1f1; margin-left: 0px;">
      <button type="submit" name="back" class="cancelbtn" >Back</button>
    </div>
  </form>
</div>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</body>
</html>
