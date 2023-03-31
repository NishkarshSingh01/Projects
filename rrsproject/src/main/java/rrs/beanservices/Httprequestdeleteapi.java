package rrs.beanservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import rrs.beans.modifytrainbean;
import rrs.beans.registerbean;
import rrs.beans.reservationbean;

@Path("deleteapi")
public class Httprequestdeleteapi 
{
	Sqlcon c=new Sqlcon();
	Connection con=c.getCon();
	
	Httprequestgetapi g=new Httprequestgetapi();
	
	@DELETE
	@Path("loginregister/{email}")
	public List<registerbean> deleteloginregister(@PathParam("email") String email)
	{
		List<registerbean> loginlist=new ArrayList<registerbean>();
		loginlist.clear();
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
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			return null;
		}
		
		return loginlist;
	}
	
	@DELETE
	@Path("train/{trainno}")
	public List<modifytrainbean> deleteTrain(@PathParam("trainno") int trainno)
	{
		List<modifytrainbean> trainlist=new ArrayList<modifytrainbean>();
		trainlist.clear();
	
		try
		{
			if(g.getTraindetails(trainno)!=null)
			{
				trainlist=g.getTraindetails(trainno);
				PreparedStatement st=con.prepareStatement("delete from traininfo where trainno=?");
				st.setInt(1, trainno);
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
			return null;
		}
		return trainlist;
	}
	
	@DELETE
	@Path("reservation/{pnr}")
	public List<reservationbean> deleteReservation(@PathParam("pnr")int pnr)
	{
		List<reservationbean> reservelist=new ArrayList<reservationbean>();
		reservelist.clear();
		
		try
		{
			if(g.getReservation(pnr)!=null)
			{
				reservelist=g.getReservation(pnr);
				PreparedStatement st=con.prepareStatement("delete from reservation where pnr=?");
				st.setInt(1, pnr);
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
			return null;
		}
		
		return reservelist;
	}
}
