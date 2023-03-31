package rrs.beanservices;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import rrs.beans.updateprofilebean;

@WebServlet("/updateprofile")
public class Updateprofile extends HttpServlet
{
	
	Httprequestputjson up=new Httprequestputjson();
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException , ServletException
	{
		HttpSession session=req.getSession();
		
		String email=req.getParameter("email");
		String name=req.getParameter("name");
		String phoneno=req.getParameter("phoneno");
		String nationality =req.getParameter("nationality");
		String maritalstatus=req.getParameter("marital");
		int age=Integer.parseInt(req.getParameter("age"));
		String gender =req.getParameter("gender");
		String changemail=req.getParameter("changemail");
		String dob=req.getParameter("dob");
		String address=req.getParameter("address");
		
		updateprofilebean u=new updateprofilebean();
		
		u.setEmail(email);
		u.setName(name);
		u.setPhoneno(phoneno);
		u.setNationality(nationality);
		u.setMaritalstatus(maritalstatus);
		u.setAge(age);
		u.setGender(gender);
		u.setChangemail(changemail);
		u.setBod(dob);
		u.setAddress(address);
		
		if(up.updateProfile(u, session.getAttribute("email").toString())!=null)
		{
			JOptionPane.showMessageDialog(null,"Profile Updated Successfully","INFO",JOptionPane.INFORMATION_MESSAGE);
			
			if(session.getAttribute("user")!=null && session.getAttribute("user").equals("User"))
			{
				RequestDispatcher rd=req.getRequestDispatcher("userloggedin.jsp");
				rd.forward(req, res);

			}
			else if(session.getAttribute("user")!=null && session.getAttribute("user").equals("Admin"))
			{
				RequestDispatcher rd=req.getRequestDispatcher("adminloggedin.jsp");
				rd.forward(req, res);
			}
			else if(session.getAttribute("username")==null)
			{
				RequestDispatcher rd=req.getRequestDispatcher("RRShome.jsp");
				rd.forward(req, res);
			}
		}
				
	}
	
}
