package rrs.beanservices;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import rrs.beans.modifytrainbean;
import rrs.beans.reservationbean;

@WebServlet("/reservation")
public class Reservation extends HttpServlet 
{
	Httprequestdeletejson d=new Httprequestdeletejson();
	Httprequestgetjson g=new Httprequestgetjson();
	Httprequestpostjson p=new Httprequestpostjson();
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
	{
		HttpSession session =req.getSession();
	try
	{
		if(req.getParameter("cancel")!=null)
		{
			if(req.getParameter("pnr")!="")
			{
				int pnr=Integer.parseInt(req.getParameter("pnr"));
				if(d.deleteReservation(pnr)!=null)
				{
					session.removeAttribute("reservelist");
					JOptionPane.showMessageDialog(null, "You have successfully cancel the ticket refund will be initiated shortly.","Thank You",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"No reservation against PNR:-"+pnr);
				}
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
			else
			{
				JOptionPane.showMessageDialog(null,"Please provide valid PNR number","INFO",JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher rd=req.getRequestDispatcher("reservation.jsp");
				rd.forward(req, res);
			}
		}
		else if(req.getParameter("reserve")!=null)
		{
			if(req.getParameter("date")=="" || req.getParameter("tno")=="" || req.getParameter("from")=="" || req.getParameter("to")=="" || req.getParameter("name")=="")
			{
				JOptionPane.showMessageDialog(null, "Please fill all the details to reserve the ticket","INFO",JOptionPane.INFORMATION_MESSAGE);
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
			else
			{
				int pnr=(new Random()).nextInt(900000000);
				String email=session.getAttribute("email").toString();
				String name=req.getParameter("name");
				int age=Integer.parseInt(req.getParameter("age"));
				String phoneno=req.getParameter("phoneno");
				String nationality=req.getParameter("nationality");
				String gender=req.getParameter("gender");
				String trainname=req.getParameter("tname");
				int trainno=Integer.parseInt(req.getParameter("tno"));
				String fromst=req.getParameter("from");
				String tost=req.getParameter("to");
				String date1 =req.getParameter("date");
				String category=req.getParameter("category");
				String classs=req.getParameter("class");
				
				int price=1;
				boolean status=false;
				reservationbean r=new reservationbean();
				
				r.setPnr(pnr);
				r.setEmail(email);
				r.setName(name);
				r.setAge(age);
				r.setPhoneno(phoneno);
				r.setNationality(nationality);
				r.setGender(gender);
				r.setTrainname(trainname);
				r.setTrainno(trainno);
				r.setFromst(fromst);
				r.setTost(tost);
				r.setDoj(date1);
				r.setClasss(classs);
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date=sdf.parse(date1);
				DateFormat format=new SimpleDateFormat("EEEE");
				String day=format.format(date);
				List<modifytrainbean> tl=new ArrayList<modifytrainbean>();
				tl=g.getTrain();
				for(modifytrainbean t:tl)
				{				
					if((t.getTrainno()==trainno && t.getFromst().equalsIgnoreCase(fromst) && t.getTost().equalsIgnoreCase(tost) && t.getMon().equals(day))||(t.getTrainno()==trainno && t.getFromst().equalsIgnoreCase(fromst) && t.getTost().equalsIgnoreCase(tost) && t.getTues().equals(day)) ||
						(t.getTrainno()==trainno && t.getFromst().equalsIgnoreCase(fromst) && t.getTost().equalsIgnoreCase(tost) && t.getWed().equals(day)) ||(t.getTrainno()==trainno && t.getFromst().equalsIgnoreCase(fromst) && t.getTost().equalsIgnoreCase(tost) &&  t.getThur().equals(day))||
						(t.getTrainno()==trainno && t.getFromst().equalsIgnoreCase(fromst) && t.getTost().equalsIgnoreCase(tost) && t.getFri().equals(day)) ||(t.getTrainno()==trainno && t.getFromst().equalsIgnoreCase(fromst) && t.getTost().equalsIgnoreCase(tost) && t.getSat().equals(day)) || 
						(t.getTrainno()==trainno && t.getFromst().equalsIgnoreCase(fromst) && t.getTost().equalsIgnoreCase(tost) && t.getSun().equals(day)))
					{
							if(classs.equals("AC"))
							{
								price=price*t.getDistance()*4;
							}
							else if(classs.equals("SL"))
							{
								price=price*t.getDistance()*3;
							}
							else
							{
								price=price*t.getDistance()*2;
							}
							
							if(category.equals("Tatkal"))
							{
								price=price+200;
							}
							else if(category.equals("Ladies"))
							{
								price=price-100;
							}
							else if(category.equals("Old citizen"))
							{
								price=price-200;
							}
							else 
							{
								price=price-0;
							}
						r.setPrice(price);

						if(p.postReservation(r)!=null)
						{
							status=true;
							JOptionPane.showMessageDialog(null, "You have Successfully Reserved your seat.");
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
				if(status==false)
				{
					JOptionPane.showMessageDialog(null, "Reservation Failed Given Train details are Wrong.","INFO",JOptionPane.INFORMATION_MESSAGE);
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
		else if(req.getParameter("reserved")!=null)
		{
				List<reservationbean> rl=new ArrayList<reservationbean>();
				if((rl=g.getReservation())!=null)
				{				
							session.setAttribute("reservelist", rl);
							RequestDispatcher rd=req.getRequestDispatcher("reservation.jsp");
							rd.forward(req, res);
				}
			else
			{
				JOptionPane.showMessageDialog(null,"No reservation List.");
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
		JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
	}
	}
}
