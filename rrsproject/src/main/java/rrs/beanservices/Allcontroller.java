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

@WebServlet("/controller")
public class Allcontroller extends HttpServlet
{
	Httprequestgetjson g=new Httprequestgetjson();
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		//JOptionPane.showMessageDialog(null,"Warning type","warning",JOptionPane.WARNING_MESSAGE);
		
		HttpSession session=req.getSession();
		
		
		if(req.getParameter("register")!=null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("register");
			rd.forward(req, res);
		}
		else if(req.getParameter("send")!=null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("forgotpassword");
			rd.forward(req, res);
		}
		else if(req.getParameter("changep")!=null)
		{
			if(req.getParameter("password")!="" && req.getParameter("cpassword")!="")
			{
				RequestDispatcher rd=req.getRequestDispatcher("changepassword");
				rd.forward(req, res);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please provide the password","INFO",JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher rd=req.getRequestDispatcher("changepassword.jsp");
				rd.forward(req, res);
				
			}
		}
		else if(req.getParameter("updatep")!=null)
		{
			if(req.getParameter("email")!=null && req.getParameter("name")!=null && req.getParameter("phoneno")!=null && req.getParameter("nationality")!=null && req.getParameter("marital")!=null && req.getParameter("age")!=null 
					&& req.getParameter("gender")!=null && req.getParameter("changemail")!=null && req.getParameter("dob")!=null && req.getParameter("address")!=null)
			{
				RequestDispatcher rd=req.getRequestDispatcher("updateprofile");
				rd.forward(req, res);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Don't Leave field blank","INFO",JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher rd=req.getRequestDispatcher("updateprofile.jsp");
				rd.forward(req, res);
			}
		}
		else if(req.getParameter("profileview")!=null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("profileview");
			rd.forward(req, res);
		}
		else if(req.getParameter("search")!=null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("searchtrain");
			rd.forward(req, res);
		}
		else if(req.getParameter("reserve")!=null || req.getParameter("reserved")!=null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("reservation");
			rd.forward(req, res);
		}
		else if(req.getParameter("modify")!=null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("modifytrain.jsp");
			rd.forward(req, res);
		}
		else if(req.getParameter("ulogin")!=null)
		{
			session.setAttribute("user","User");
			RequestDispatcher rd=req.getRequestDispatcher("login");
			rd.forward(req, res);
		}
		else if(req.getParameter("alogin")!=null)
		{
			session.setAttribute("user","Admin");
			RequestDispatcher rd=req.getRequestDispatcher("login");
			rd.forward(req, res);
		}
		else if(req.getParameter("back")!=null)
		{
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
	
		else if(req.getParameter("signout")!=null)
		{
			int ch=JOptionPane.showConfirmDialog(null, "Are You sure want to Sign Out?");
			if(ch==JOptionPane.YES_OPTION)
			{
				session.removeAttribute("username");
				session.removeAttribute("user");
				session.removeAttribute("email");
				session.removeAttribute("jday");
				session.removeAttribute("reservelist");
				session.removeAttribute("profile");
				req.removeAttribute("trainlist");
				req.removeAttribute("day");
				session.invalidate();
				RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
				rd.forward(req, res);
			}
			else if(ch==JOptionPane.CANCEL_OPTION||ch==JOptionPane.NO_OPTION || ch==JOptionPane.CLOSED_OPTION)
			{
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
	}
}
