<%@page import="rrs.beans.reservationbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" import="rrs.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reservation.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<title>Reservation Details</title>
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

<%
boolean status=false;
if(session.getAttribute("reservelist")!=null) 
{
%>
<h1 align="center">Reservation List</h1>

<table style="text-align: center;" class="table table-striped" border="10px">
<br>
<%
List<reservationbean> rl=new ArrayList<reservationbean>();
rl=(List)session.getAttribute("reservelist");
int i=0;
for(reservationbean r:rl)
{
 	if(r.getEmail().equals(session.getAttribute("email").toString()))
 	{
 		status=true;
%>
<tr><th>Sl No.</th><td><%=++i %></td></tr>
<tr>
<th>PNR</th><td><%=r.getPnr() %></td><th>Name</th><td><%=r.getName() %></td><th>Age</th><td><%=r.getAge() %></td>
<th>Gender</th><td><%=r.getGender() %></td><th>Phone No.</th><td><%=r.getPhoneno() %></td><th>Price</th><td><%=r.getPrice() %>&nbsp/-</td>
</tr>
<tr>
<th>Train Number</th><td><%=r.getTrainno() %></td><th>Train Name</th><td><%=r.getTrainname() %></td><th>From Station</th><td><%=r.getFromst() %></td>
<th>To Station</th><td><%=r.getTost() %></td><th>Journey Date</th><td><%=r.getDoj() %></td><th>Class</th><td><%=r.getClasss() %></td>
</tr>
<%
 	}
}
%>
</table>
<%
	if(status==false)
	{
%>
<div style="margin-top: 20%;">
<img alt="oops" src="image/noreserve.png">
<h3 align="center">Oops..... No Reservation with this account.</h3>
</div>
<%
	}
}

%>
<div style="margin-left: 30%">
<form action="reservation" method="post">
<input type="number" name="pnr" placeholder="PNR">
<button type="submit" id="box"  name="cancel"  class="btn btn-outline-success space top btwn">Cancel Reservation</button>
</form>
</div>
<form action="controller" method="post">
<div class="container" style="margin-left:37%;">
<button type="submit" id="box"  name="back"  class="btn btn-outline-success space top btwn">Back To Search</button>
</div> </form>
</body>
</html>
