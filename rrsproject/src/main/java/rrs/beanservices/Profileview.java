package rrs.beanservices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import rrs.beans.registerbean;

@WebServlet("/profileview")
public class Profileview extends HttpServlet
{
	Httprequestdeletejson d=new Httprequestdeletejson();
	Httprequestgetjson g=new Httprequestgetjson();
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		HttpSession session=req.getSession();
		
		if(req.getParameter("daccount")!=null)
		{				
				int ch=JOptionPane.showConfirmDialog(null, "Are You sure want to delete account ?");
				if(ch==JOptionPane.YES_OPTION)
				{
					if(d.deleteRegister(session.getAttribute("email").toString())!=null)
					{
						session.removeAttribute("username");
						session.removeAttribute("email");
						JOptionPane.showMessageDialog(null, "Account Successfully Deleted.","INFO",JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher rd=req.getRequestDispatcher("RRShome.jsp");
						rd.forward(req, res);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error while Deleting Account.","INFO",JOptionPane.INFORMATION_MESSAGE);
						RequestDispatcher rd=req.getRequestDispatcher("RRShome.jsp");
						rd.forward(req, res);
					}
				}
				else if(ch==JOptionPane.CANCEL_OPTION||ch==JOptionPane.NO_OPTION || ch==JOptionPane.CLOSED_OPTION)
				{
					RequestDispatcher rd=req.getRequestDispatcher("profileview.jsp");
					rd.forward(req, res);
				}
			}
			else if(req.getParameter("profileview")!=null)
			{
				if(g.getRegister()!=null)
				{
					List<registerbean> rl=new ArrayList<registerbean>();
					rl=g.getRegister();
					for(registerbean r:rl)
					{
						if(r.getEmail().equals(session.getAttribute("email").toString()) && r.getName().equals(session.getAttribute("username").toString())) 
						{
							session.setAttribute("profile", rl);
							RequestDispatcher rd=req.getRequestDispatcher("profileview.jsp");
							rd.forward(req, res);
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Error While loading Profile Date.");
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
					RequestDispatcher rd=req.getRequestDispatcher("RRShome.jsp");
					rd.forward(req, res);
				}
			}	
		}
}
