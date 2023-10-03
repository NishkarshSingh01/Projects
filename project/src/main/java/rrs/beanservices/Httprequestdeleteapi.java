package rrs.beanservices;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

//import org.springframework.web.bind.annotation.PathVariable;

import rrs.beans.modifytrainbean;
import rrs.beans.registerbean;
import rrs.beans.reservationbean;


public class Httprequestdeleteapi 
{
	Sqlcon c=new Sqlcon();
	Connection con=c.getCon();
	
	Httprequestgetapi g=new Httprequestgetapi();
	

	public registerbean deleteloginregister(String email)
	{
		registerbean loginlist=new registerbean();
		try
		{
			if(g.getLogin(email)!=null && g.getRegister(email)!=null)
			{
				loginlist=g.getRegister(email);
				PreparedStatement st=con.prepareStatement("delete from login where email=?");
				st.setString(1, email);
				st.executeUpdate();
				st=con.prepareStatement("delete from register where email=?");
				st.setString(1, email);
				st.executeUpdate();
				
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			return null;
		}
		
		return loginlist;
	}
	

	public modifytrainbean deleteTrain(int trainno)
	{
		modifytrainbean trainlist=new modifytrainbean();
		try
		{
			if(g.getTraindetails(trainno)!=null)
			{
				trainlist=g.getTraindetails(trainno);
				PreparedStatement st=con.prepareStatement("delete from traininfo where trainno=?");
				st.setInt(1, trainno);
				st.executeUpdate();
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			return null;
		}
		return trainlist;
	}
	

	public reservationbean deleteReservation(int pnr)
	{
		reservationbean reservelist=new reservationbean();
		
		try
		{
			if(g.getReservation(pnr)!=null)
			{
				reservelist=g.getReservation(pnr);
				PreparedStatement st=con.prepareStatement("delete from reservation where pnr=?");
				st.setInt(1, pnr);
				st.executeUpdate();
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			return null;
		}
		
		return reservelist;
	}
}
