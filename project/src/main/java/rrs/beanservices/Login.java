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

import org.apache.commons.codec.digest.DigestUtils;

import rrs.beans.loginbean;

@SuppressWarnings("serial")
@WebServlet("/login")
public class Login extends HttpServlet
{

	Httprequestgetapi g=new Httprequestgetapi();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		HttpSession session =req.getSession();
		

		if(session.getAttribute("user")!=null && session.getAttribute("user").equals("User"))
		{
			try
			{
				if(g.getLogin()!=null)
				{
					for(loginbean l:g.getLogin())
					{
//						String pass=DigestUtils.sha256Hex(req.getParameter("psw"));
						String pass= new DigestUtils("SHA3-256").digestAsHex(req.getParameter("psw"));

//							String pass=req.getParameter("psw");
						if((l.getEmail().equals(req.getParameter("uname")) && session.getAttribute("otp")!=null && session.getAttribute("otp").toString().equals(req.getParameter("psw"))&& l.getUsertype().equals("User"))
								||(l.getEmail().equals(req.getParameter("uname")) && l.getPassword().equals(pass) && l.getUsertype().equals("User")))
						{
							
							session.setAttribute("username",l.getName());
							session.setAttribute("email", l.getEmail());
							session.removeAttribute("otp");
							RequestDispatcher rd=req.getRequestDispatcher("userloggedin.jsp");
							rd.forward(req, res);
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"No Login List","INFO",JOptionPane.INFORMATION_MESSAGE);
				}
				if(session.getAttribute("username")==null)
				{
					JOptionPane.showMessageDialog(null,"Wrong Credentials","INFO",JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					rd.forward(req, res);
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e,"INFO",JOptionPane.INFORMATION_MESSAGE); 
			}
		}
		else if(session.getAttribute("user")!=null && session.getAttribute("user").equals("Admin"))
		{
			try
			{
				if(g.getLogin()!=null)
				{
					for(loginbean l:g.getLogin())
					{
//						String pass=DigestUtils.sha256Hex(req.getParameter("psw"));
						String pass= new DigestUtils("SHA3-256").digestAsHex(req.getParameter("psw"));

//						String pass=req.getParameter("psw");
						if((l.getEmail().equals(req.getParameter("uname")) && session.getAttribute("otp")!=null && session.getAttribute("otp").toString().equals(req.getParameter("psw")) && l.getUsertype().equals("Admin"))
								||( l.getEmail().equals(req.getParameter("uname")) && l.getPassword().equals(pass) && l.getUsertype().equals("Admin")))
						{
							session.setAttribute("username",l.getName());
							session.setAttribute("email", l.getEmail());
							session.removeAttribute("otp");
							RequestDispatcher rd=req.getRequestDispatcher("adminloggedin.jsp");
							rd.forward(req, res);
						}	
		
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"No Login List","INFO",JOptionPane.INFORMATION_MESSAGE);
				}
			if(session.getAttribute("username")==null)
			{
				JOptionPane.showMessageDialog(null,"Wrong Credentials","INFO",JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.forward(req, res);
			}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"INFO",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	

}
