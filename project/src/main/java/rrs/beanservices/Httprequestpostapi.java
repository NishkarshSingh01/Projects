package rrs.beanservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;

import rrs.beans.loginbean;
import rrs.beans.modifytrainbean;
import rrs.beans.registerbean;
import rrs.beans.reservationbean;


public class Httprequestpostapi 
{
	Sqlcon c=new Sqlcon();
	Connection con=c.getCon();
	Httprequestgetapi g=new Httprequestgetapi();
	

	public loginbean postLogin(loginbean l)
	{
		try
		{
			loginbean check=new loginbean();
			check=g.getLogin(l.getEmail());
						
			if(check==null)
			{
				String pass= new DigestUtils("SHA3-256").digestAsHex(l.getPassword());
				PreparedStatement st=con.prepareStatement("insert into login values(?,?,?,?)");
				st.setString(1,l.getEmail());
				st.setString(2, l.getName());
				st.setString(3, pass);
				st.setString(4,l.getUsertype());
				st.executeUpdate();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Email Already Exist","INFO",JOptionPane.INFORMATION_MESSAGE);
				return null;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		
		return l;
	}
	

	public registerbean postRegister(registerbean r)
	{		
		try
		{
			registerbean check=new registerbean();
			check=g.getRegister(r.getEmail());
						
			if(check==null)
			{
				PreparedStatement st=con.prepareStatement("insert into register values(?,?,?,?,?,?,?,?,?)");
				st.setString(1, r.getEmail());
				st.setString(2,r.getName());
				st.setString(3,r.getPhoneno());
				st.setString(4,r.getNationality());
				st.setString(5,r.getMaritalstatus());
				st.setInt(6,r.getAge());
				st.setString(7,r.getGender());	
				
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
				java.util.Date	 date=sdf.parse(r.getBod());
				java.sql.Date dob=new java.sql.Date(date.getTime());
				
				st.setDate(8,dob);
				st.setString(9,r.getAddress());
				st.executeUpdate();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Email Already Exist","INFO",JOptionPane.INFORMATION_MESSAGE);
				return null;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		return r;
	}

	public modifytrainbean postTraindetails(modifytrainbean m)
	{	
		try
		{
			modifytrainbean check=new modifytrainbean();
			check=g.getTraindetails(m.getTrainno());
						
			if(check==null)
			{
			PreparedStatement st=con.prepareStatement("insert into traininfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			st.setInt(1,m.getTrainno());
			st.setString(2,m.getTrainname());
			st.setString(3,m.getFromst());
			st.setString(4,m.getTost());
			st.setInt(5,m.getDistance());
			st.setString(6, m.getAt());
			st.setString(7, m.getDt());
			st.setString(8, m.getMon());
			st.setString(9, m.getTues());
			st.setString(10, m.getWed());
			st.setString(11, m.getThur());
			st.setString(12, m.getFri());
			st.setString(13, m.getSat());
			st.setString(14, m.getSun());
			st.executeUpdate();	
			}
			else {
				JOptionPane.showMessageDialog(null,"Train Already Exist","INFO",JOptionPane.INFORMATION_MESSAGE);
				return null;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		
		
		return m;
	}
	

	public reservationbean postReservation(reservationbean r)
	{		
		try
		{
			PreparedStatement st=con.prepareStatement("insert into reservation values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			st.setInt(1, r.getPnr());
			st.setString(2, r.getEmail());
			st.setString(3, r.getName());
			st.setInt(4, r.getAge());
			st.setString(5, r.getPhoneno());
			st.setString(6, r.getNationality());
			st.setString(7, r.getGender());
			st.setString(8,r.getTrainname());
			st.setInt(9, r.getTrainno());
			st.setString(10, r.getFromst());
			st.setString(11, r.getTost());
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
			Date date=sdf.parse(r.getDoj());
			java.sql.Date doj=new java.sql.Date(date.getTime());
			
			st.setDate(12, doj);
			st.setString(13, r.getClasss());
			st.setInt(14, r.getPrice());
			st.executeUpdate();			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		return r;
	}
}
