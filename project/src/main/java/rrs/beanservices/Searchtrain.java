package rrs.beanservices;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import rrs.beans.modifytrainbean;

@SuppressWarnings("serial")
@WebServlet("/searchtrain")
public class Searchtrain extends HttpServlet
{
	Httprequestgetapi g=new Httprequestgetapi();
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException ,ServletException
	{
		HttpSession session=req.getSession();
		try
		{
			if( (req.getParameter("search")!=null &&req.getParameter("from")=="" )|| (req.getParameter("search")!=null && req.getParameter("to")=="") ||
					(req.getParameter("search")!=null && req.getParameter("date")==""))
			{
				JOptionPane.showMessageDialog(null, "Please fill respective field to search train","INFO",JOptionPane.INFORMATION_MESSAGE);
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
			else if(req.getParameter("from")!=null && req.getParameter("to")!=null && req.getParameter("date")!=null)
			{
				
				String date=req.getParameter("date");
				session.setAttribute("jday", date);
				
				
				SimpleDateFormat f1=new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date1=f1.parse(date);
				DateFormat format=new SimpleDateFormat("EEEE");
				String day=format.format(date1);
				List<modifytrainbean> ml=new ArrayList<modifytrainbean>();
				
				if((ml=g.getTraindetails())!=null)
				{
					req.setAttribute("trainlist", ml);
					req.setAttribute("day", day);
					RequestDispatcher rd=req.getRequestDispatcher("searchtrain.jsp");
					rd.forward(req, res);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No Train List","INFO",JOptionPane.INFORMATION_MESSAGE);
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
		catch(Exception e)
		
		{
			JOptionPane.showMessageDialog(null,e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
	}
}
