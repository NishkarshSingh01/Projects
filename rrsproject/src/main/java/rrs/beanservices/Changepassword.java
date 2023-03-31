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

import rrs.beans.loginbean;

@WebServlet("/changepassword")
public class Changepassword extends HttpServlet 
{
	Httprequestgetjson g=new Httprequestgetjson();
	Httprequestputjson u=new Httprequestputjson();
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException , ServletException
	{
		HttpSession session=req.getSession();
		
			String pass=req.getParameter("password");
			String cpass=req.getParameter("cpassword");
			if(pass.equals(cpass))
			{
								
				loginbean l=new loginbean();
				l.setEmail(session.getAttribute("email").toString());
				l.setPassword(pass);
				l.setCpassword(cpass);
				l.setName(session.getAttribute("username").toString());
				l.setUsertype(session.getAttribute("user").toString());
				
				if(u.changePassword(l)!=null)
				{
					JOptionPane.showMessageDialog(null,"Password changed Successfully","INFO",JOptionPane.INFORMATION_MESSAGE);
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
						RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
						rd.forward(req, res);
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Provided password doesn't met requirement","INFO",JOptionPane.INFORMATION_MESSAGE);
			}
		
		
	}

}
