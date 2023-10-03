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

import rrs.beans.modifytrainbean;

@SuppressWarnings("serial")
@WebServlet("/modifytrain")
public class Modifytrain extends HttpServlet 
{

	Httprequestpostapi p=new Httprequestpostapi();
	Httprequestdeleteapi de=new Httprequestdeleteapi();
	Httprequestputapi up=new Httprequestputapi();
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException ,ServletException
	{
		HttpSession session=req.getSession();
		
		if((req.getParameter("tno")=="" && req.getParameter("addtrain")!=null)||
				(req.getParameter("updatetrain")!=null && req.getParameter("tno")=="")||
				(req.getParameter("removetrain")!=null && req.getParameter("tno")==""))		
		{
			JOptionPane.showMessageDialog(null, "Please provide the train details","INFO",JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher rd=req.getRequestDispatcher("modifytrain.jsp");
			rd.forward(req, res);
		}
		else if(req.getParameter("tno")!=null && req.getParameter("removetrain")!=null)
		{
				int trainno=Integer.parseInt(req.getParameter("tno"));
				if(de.deleteTrain(trainno)!=null)
				{
					JOptionPane.showMessageDialog(null, "Train deleted Successfully","INFO",JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher rd=req.getRequestDispatcher("modifytrain.jsp");
					rd.forward(req, res);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Train not remove from list","INFO",JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher rd=req.getRequestDispatcher("modifytrain.jsp");
					rd.forward(req, res);
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
				RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
				rd.forward(req, res);
			}
		}
		else if(req.getParameter("tno")!=null && req.getParameter("tname")!=null && req.getParameter("from")!=null && req.getParameter("to")!=null && req.getParameter("distance")!=null 
			&& req.getParameter("arrive")!=null && req.getParameter("depart")!=null && req.getParameter("rday1")!=null && req.getParameter("rday2")!=null
			&& req.getParameter("rday3")!=null && req.getParameter("rday4")!=null && req.getParameter("rday5")!=null && req.getParameter("rday6")!=null && req.getParameter("rday7")!=null)
		{
			
			int trainno=Integer.parseInt(req.getParameter("tno"));
			String trainname=req.getParameter("tname");
			String fromst=req.getParameter("from");
			String tost=req.getParameter("to");
			int distance=Integer.parseInt(req.getParameter("distance"));
			String at=req.getParameter("arrive");
			String dt=req.getParameter("depart");
			String mon=req.getParameter("rday1");
			String tues=req.getParameter("rday2");
			String wed=req.getParameter("rday3");
			String thur=req.getParameter("rday4");
			String fri=req.getParameter("rday5");
			String sat=req.getParameter("rday6");
			String sun=req.getParameter("rday7");
			
			
			modifytrainbean m=new modifytrainbean();
			m.setTrainno(trainno);
			m.setTrainname(trainname);
			m.setFromst(fromst);
			m.setTost(tost);
			m.setDistance(distance);
			m.setAt(at);
			m.setDt(dt);
			m.setMon(mon);
			m.setTues(tues);
			m.setWed(wed);
			m.setThur(thur);
			m.setFri(fri);
			m.setSat(sat);
			m.setSun(sun);
			if(req.getParameter("addtrain")!=null)
			{ 				
				if(p.postTraindetails(m)!=null)
				{
					JOptionPane.showMessageDialog(null,"Train Added Successfully","INFO",JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher rd=req.getRequestDispatcher("modifytrain.jsp");
					rd.forward(req, res);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Train not added in list","INFO",JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher rd=req.getRequestDispatcher("modifytrain.jsp");
					rd.forward(req, res);
				}
				
			}
			else if(req.getParameter("updatetrain")!=null)
			{
				
				if(up.putTrain(m, trainno)!=null)
				{
					JOptionPane.showMessageDialog(null, "Train updated Successfully","INFO",JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher rd=req.getRequestDispatcher("modifytrain.jsp");
					rd.forward(req, res);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Train not updated in list","INFO",JOptionPane.INFORMATION_MESSAGE);
					RequestDispatcher rd=req.getRequestDispatcher("modifytrain.jsp");
					rd.forward(req, res);
				}
			}	
		}
				
	}
}
