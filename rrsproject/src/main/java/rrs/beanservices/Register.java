package rrs.beanservices;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import rrs.beans.loginbean;
import rrs.beans.registerbean;

@WebServlet("/register")
public class Register extends HttpServlet
{
	Httprequestpostjson p=new Httprequestpostjson();
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException , ServletException
	{
			String email=req.getParameter("email");
			String name=req.getParameter("name");
			String phoneno=req.getParameter("phoneno");
			String nationality=req.getParameter("nationality");
			String maritalstatus=req.getParameter("marital");
			int age=Integer.parseInt(req.getParameter("age"));
			String gender=req.getParameter("gender");
			String user=req.getParameter("type");
			String bod=req.getParameter("dob");
			String address=req.getParameter("address");
			String password=req.getParameter("password");
			String cpassword=req.getParameter("cpassword");
			
			loginbean l=new loginbean();
			registerbean r=new registerbean();
			
			l.setEmail(email);
			l.setName(name);
			l.setPassword(password);
			l.setCpassword(cpassword);
			l.setUsertype(user);
			
			r.setEmail(email);
			r.setName(name);
			r.setPhoneno(phoneno);
			r.setNationality(nationality);
			r.setMaritalstatus(maritalstatus);
			r.setAge(age);
			r.setGender(gender);
			r.setBod(bod);
			r.setAddress(address);
			
		if(password.equals(cpassword))
		{
			if(p.postLogin(l)!=null && p.postRegister(r)!=null)
				{
				JOptionPane.showMessageDialog(null, "Successfully Register","INFO",JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher rd=req.getRequestDispatcher("RRShome.jsp");
				rd.forward(req, res);
				}
			else
			{
			JOptionPane.showMessageDialog(null, "Registration failed","INFO",JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher rd=req.getRequestDispatcher("RRShome.jsp");
			rd.forward(req, res);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Password and Cpassword are not matching.","INFO",JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher rd=req.getRequestDispatcher("register.jsp");
			rd.forward(req, res);
		}
		
	}
}
