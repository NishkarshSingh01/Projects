<%@page import="rrs.beans.registerbean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/profileview.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<title>Profile</title>
</head>
<body>

<%
if(session.getAttribute("profile")!=null)
{
	List<registerbean> rl=new ArrayList<registerbean>();
%>
<h1 align="center"><%=session.getAttribute("username") %> Profile</h1>
<br>
<table style="text-align: center;" class="table table-striped" border="10px">
<%	
	rl=(List)session.getAttribute("profile");
	for(registerbean r:rl)
	{
		if(r.getEmail().equals(session.getAttribute("email").toString()) && r.getName().equals(session.getAttribute("username").toString()))
		{
%>
<tr><th>Name :</th><td><%=r.getName() %></td><th>Gender : </th><td><%=r.getGender() %></td></tr>
<tr><th>Email :</th><td><%=r.getEmail() %></td><th>Phone Number :</th><td><%=r.getPhoneno() %></td></tr>
<tr><th>Birth Date :</th><td><%=r.getBod() %></td><th>Age :</th><td><%=r.getAge() %></td></tr>
<tr><th>Nationality :</th><td><%=r.getNationality() %></td><th>Address :</th><td><%=r.getAddress() %></td></tr> 
<%
		}
	}
%>
</table>
<%
}
%>
<form action="profileview" method="post">
<div class="container" style="margin-left:30%;">
<button type="submit" id="box"  name="back"  class="btn btn-outline-success space top btwn">Back</button>
<button type="submit" id="box"  name="daccount"  class="btn btn-outline-success space top btwn">Delete Account</button>

</div> </form>
</body>
</html>