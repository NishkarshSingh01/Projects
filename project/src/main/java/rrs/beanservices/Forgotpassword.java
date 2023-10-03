package rrs.beanservices;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import rrs.beans.loginbean;

@SuppressWarnings("serial")
@WebServlet("/forgotpassword")
public class Forgotpassword extends HttpServlet 
{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException , ServletException
	{
		HttpSession session =req.getSession();
//		Httprequestgetjson g=new Httprequestgetjson();
		Httprequestgetapi g=new Httprequestgetapi();
		boolean status=false;
			String recipient =req.getParameter("email");
			
			for(loginbean l:g.getLogin())
			{
				if(l.getEmail().equals(recipient))
				{
					final String from="";
					final String pass="";
					
					Properties prop=System.getProperties();
					
					prop.put("mail.smtp.host","smtp.gmail.com");
					prop.put("mail.smtp.ssl.enable", "true");
					prop.put("mail.smtp.port", "465");
					prop.put("mail.smtp.auth", "true");
					
					Session ses =Session.getInstance(prop, new javax.mail.Authenticator()
							{
								protected PasswordAuthentication getPasswordAuthentication()
								{
									return new PasswordAuthentication(from,pass);
								}
							}
					);
					
					try
					{
						MimeMessage mes=new MimeMessage(ses);
						
						mes.setFrom(new InternetAddress(from,"RKU"));
						mes.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
						mes.setSubject("Forgot Password");
						
						int rand=(new Random()).nextInt(900000);
						session.setAttribute("otp", rand);
						
						mes.setText("OTP as Password for user="+recipient+" is "+rand);
						Transport.send(mes);
						status=true;
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
			if(status)
			{
				JOptionPane.showMessageDialog(null,"Email sent Successfully","INFO",JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher rd= req.getRequestDispatcher("login.jsp");
				rd.forward(req, res);
			}	
			else
			{
				JOptionPane.showMessageDialog(null,"Email not found","INFO",JOptionPane.INFORMATION_MESSAGE);
				RequestDispatcher rd= req.getRequestDispatcher("forgotpassword.jsp");
				rd.forward(req, res);
			}
	}
}
