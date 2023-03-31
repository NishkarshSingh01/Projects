<%@page import="rrs.beans.modifytrainbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" import="rrs.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/searchtrain.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<title>Train Search Result</title>

</head>
<body>

<%
boolean status=false;
if(request.getAttribute("trainlist")!=null) 
{

%>
<h1 align="center">Train List</h1>

<table style="text-align: center;" class="table table-striped" border="10px">
<%
List<modifytrainbean> mt=new ArrayList<modifytrainbean>();
mt=(List)request.getAttribute("trainlist");
int i=0;
String fromst=request.getParameter("from");
String tost=request.getParameter("to");
String date=request.getParameter("date");
String day=request.getAttribute("day").toString();
for(modifytrainbean t:mt)
{
	if((t.getFromst().equalsIgnoreCase(fromst) && t.getTost().equalsIgnoreCase(tost) && t.getMon().equals(day))||( t.getFromst().equalsIgnoreCase(fromst) && t.getTost().equalsIgnoreCase(tost) && t.getTues().equals(day)) ||
			(t.getFromst().equalsIgnoreCase(fromst) && t.getTost().equalsIgnoreCase(tost) && t.getWed().equals(day)) ||(t.getFromst().equalsIgnoreCase(fromst) && t.getTost().equalsIgnoreCase(tost) &&  t.getThur().equals(day))||
			(t.getFromst().equalsIgnoreCase(fromst) && t.getTost().equalsIgnoreCase(tost) && t.getFri().equals(day)) ||(t.getFromst().equalsIgnoreCase(fromst) && t.getTost().equalsIgnoreCase(tost) && t.getSat().equals(day)) || (t.getFromst().equalsIgnoreCase(fromst) && t.getTost().equalsIgnoreCase(tost) && t.getSun().equals(day)))
	{
		status=true;
%>
<tr><th>Sl No.</th><td><%=++i %></td></tr>
<tr>
<th>Train Number</th><td><%=t.getTrainno() %></td><th>Train Name</th><td><%=t.getTrainname() %></td>
<th>Station From</th><td><%=t.getFromst() %></td><th>Station To</th><td><%=t.getTost() %></td>
</tr>
<tr>
<th>Distance</th><td><%=t.getDistance() %>&nbspKM</td><th>Arrival Time</th><td><%=t.getAt() %></td>
<th>Depart Time</th><td><%=t.getDt() %></td><th>Journey Date</th><td><%= session.getAttribute("jday") %></td>
</tr>
<%
	}
}
%>
</table>
<% if(status==false)
	{
%>
<div style="margin-top: 20%;">
<img alt="oops" src="image/oops.png">
<h3 align="center">Oops..... No Trains run between these route.</h3>
</div>
<%
	}
}
%>
<form action="controller" method="post">
<div class="container" style="margin-left:37%;">
<button type="submit" id="box"  name="back"  class="btn btn-outline-success space top btwn">Back To Search</button>
</div> </form>
</body>
</html>