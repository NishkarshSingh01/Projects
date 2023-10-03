package rrs.beanservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;

import rrs.beans.loginbean;
import rrs.beans.modifytrainbean;
import rrs.beans.updateprofilebean;


public class Httprequestputapi 
{
	Sqlcon c=new Sqlcon();
	Connection con=c.getCon();

	
	Httprequestgetapi g=new Httprequestgetapi();
	
	public loginbean putLogin(loginbean l)
	{
		try
		{
			if((l=g.getLogin(l.getEmail()))!=null)
			{
				String pass= new DigestUtils("SHA3-256").digestAsHex(l.getPassword());
				PreparedStatement st=con.prepareStatement("update login set password=? where email=?");
				st.setString(1,pass);
				st.setString(2,l.getEmail());
				st.executeUpdate();
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		
		
		return l;
	}
	

	public updateprofilebean putLogin(updateprofilebean u, String email)
	{
		
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
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		return u;
	}
	
	
	public List<modifytrainbean> putTrain(modifytrainbean t, int trainno)
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
