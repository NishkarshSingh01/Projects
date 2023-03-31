package rrs.beanservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import rrs.beans.loginbean;
import rrs.beans.modifytrainbean;
import rrs.beans.updateprofilebean;

@Path("putapi")
public class Httprequestputapi 
{
	Sqlcon c=new Sqlcon();
	Connection con=c.getCon();
	
	Httprequestgetapi g=new Httprequestgetapi();
	
	@PUT
	@Path("login/changepassword")
	public List<loginbean> putLogin(loginbean l)
	{
		List<loginbean> loginlist=new ArrayList<loginbean>();
		loginlist.clear();
		
		try
		{
			if(g.getLogin(l.getEmail())!=null)
			{
			
				PreparedStatement st=con.prepareStatement("update login set password=?, cpassword=? where email=?");
				st.setString(1,l.getPassword());
				st.setString(2, l.getCpassword());
				st.setString(3,l.getEmail());
				st.executeUpdate();
			}
			else
			{
				return null;
			}
			loginlist.add(l);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		
		
		return loginlist;
	}
	
	@PUT
	@Path("loginregister/{email}")
	public List<updateprofilebean> putLogin(updateprofilebean u,@PathParam("email") String email)
	{
		List<updateprofilebean> updatelist=new ArrayList<updateprofilebean>();
		updatelist.clear();
		
		try
		{
			if(g.getRegister(email)!=null)
			{
					if(u.getChangemail().equals("Yes")==true)
					{
						PreparedStatement st=con.prepareStatement("update login set email=? where email=?");
						st.setString(1,u.getEmail());
						st.setString(2, email);
						st.executeUpdate();
						st=con.prepareStatement("update register set name=?,email=?,phoneno=?,nationality=?,maritalstatus=?,age=?,gender=?,bod=?,address=? where email=?");
						st.setString(1, u.getName());
						st.setString(2, u.getEmail());
						st.setString(3,u.getPhoneno());
						st.setString(4,u.getNationality());
						st.setString(5,u.getMaritalstatus());
						st.setInt(6,u.getAge());
						st.setString(7,u.getGender());
						
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
						Date date=sdf.parse(u.getBod());
						java.sql.Date dob=new java.sql.Date(date.getTime());

						st.setDate(8, dob);
						st.setString(9,u.getAddress());
						st.setString(10, email);
						st.executeUpdate();
					}
					if(u.getChangemail().equals("No")==true)
					{
						
						PreparedStatement st=con.prepareStatement("update register set name=?,phoneno=?,nationality=?,maritalstatus=?,age=?,gender=?,bod=?,address=? where email=?");
						st.setString(1,u.getName());
						st.setString(2, u.getPhoneno());
						st.setString(3, u.getNationality());
						st.setString(4, u.getMaritalstatus());
						st.setInt(5, u.getAge());
						st.setString(6,u.getGender());
						st.setString(7,u.getBod());
						st.setString(8,u.getAddress());
						st.setString(9, email);
						st.executeUpdate();
					}
			}
			else
			{
				return null;
			}	
			updatelist.add(u);
//			JOptionPane.showMessageDialog(null,"Updated sucessfully","Success",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		
		
		return updatelist;
	}
	
	
	@PUT
	@Path("train/{trainno}")
	public List<modifytrainbean> putTrain(modifytrainbean t,@PathParam("trainno") int trainno)
	{
		List<modifytrainbean> trainlist=new ArrayList<modifytrainbean>();
		
		try
		{	if(g.getTraindetails(trainno)!=null)
			{
				PreparedStatement st=con.prepareStatement("update traininfo set trainname=?,fromst=?,tost=?,at=?,dt=?,mon=?,tues=?,wed=?,thur=?,fri=?,sat=?,sun=?,distance=? where trainno=?");
				st.setString(1,t.getTrainname());
				st.setString(2,t.getFromst());
				st.setString(3,t.getTost());
				st.setInt(13, t.getDistance());
				st.setString(4, t.getAt());
				st.setString(5,t.getDt());
				st.setString(6,t.getMon());
				st.setString(7,t.getTues());
				st.setString(8,t.getWed());
				st.setString(9, t.getThur());
				st.setString(10,t.getFri());
				st.setString(11,t.getSat());
				st.setString(12,t.getSun());
				st.setInt(14,trainno);
				st.executeUpdate();
			}
		else 
		{
			return null;
		}
		trainlist.add(t);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		return trainlist;
	}
}
