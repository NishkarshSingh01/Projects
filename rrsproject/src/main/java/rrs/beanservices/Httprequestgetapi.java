package rrs.beanservices;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rrs.beans.loginbean;
import rrs.beans.modifytrainbean;
import rrs.beans.registerbean;
import rrs.beans.reservationbean;

@Path("getapi")

public class Httprequestgetapi
{
		Sqlcon c=new Sqlcon();
		Connection con=c.getCon();
		
		@GET
		@Path("login")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})	
		public List<loginbean> getLogin()
		{
			List<loginbean>  loginlist=new ArrayList<loginbean>();
			
			loginlist.clear();
			try
			{
				PreparedStatement st=con.prepareStatement("select * from login");
				ResultSet rs=st.executeQuery();
				rs.last();
				if(rs.getRow()!=0)
				{
					rs.beforeFirst();
					while(rs.next())
					{
						loginbean lc=new loginbean();
						
						lc.setEmail(rs.getString(1));
						lc.setName(rs.getString(2));
						lc.setPassword(rs.getString(3));
						lc.setCpassword(rs.getString(4));
						lc.setUsertype(rs.getString(5));
						
						loginlist.add(lc);
					}
					return loginlist;
				}
				else
				{
//					JOptionPane.showMessageDialog(null,"No Data Found","INFO",JOptionPane.INFORMATION_MESSAGE);
					return null;
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}
			
			return null;
		}
		@GET
		@Path("login/email")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})	
		public List<loginbean> getLogin(String email)
		{
			List<loginbean>  loginlist=new ArrayList<loginbean>();
			
			loginlist.clear();
			
			try
			{
				PreparedStatement st=con.prepareStatement("select * from login where email=?");
				st.setString(1, email);
				ResultSet rs=st.executeQuery();
				rs.last();
				if(rs.getRow()!=0)
				{
					rs.beforeFirst();
					while(rs.next())
					{
						loginbean lc=new loginbean();
						
						lc.setEmail(rs.getString(1));
						lc.setName(rs.getString(2));
						lc.setPassword(rs.getString(3));
						lc.setCpassword(rs.getString(4));
						lc.setUsertype(rs.getString(5));
						
						loginlist.add(lc);
					}
					return loginlist;
				}
				else
				{
					//JOptionPane.showMessageDialog(null,"No Data Found","INFO",JOptionPane.INFORMATION_MESSAGE);
					return null;
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}
			
			return null;
		}
	
		@GET
		@Path("register")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public List<registerbean> getRegister()
		{
			List<registerbean> registerlist=new ArrayList<registerbean>();
			registerlist.clear();
			try
			{
				PreparedStatement st=con.prepareStatement("select * from register");
				ResultSet rs=st.executeQuery();
				rs.last();
				if(rs.getRow()!=0)
				{
					rs.beforeFirst();
					while(rs.next())
					{
						registerbean r=new registerbean();
						
						r.setEmail(rs.getString(1));
						r.setName(rs.getString(2));
						r.setPhoneno(rs.getString(3));
						r.setNationality(rs.getString(4));
						r.setMaritalstatus(rs.getString(5));
						r.setAge(rs.getInt(6));
						r.setGender(rs.getString(7));
						r.setBod(rs.getString(8));
						r.setAddress(rs.getString(9));
						
						registerlist.add(r);
					}
					return registerlist;
				}
				else
				{
//					JOptionPane.showMessageDialog(null,"No Data Found","INFO",JOptionPane.INFORMATION_MESSAGE);
					return null;
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}
			
			
			
			return null;
		}
		
		
		@GET
		@Path("register/email")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public List<registerbean> getRegister(String email)
		{
			List<registerbean> registerlist=new ArrayList<registerbean>();
			registerlist.clear();
			
			try
			{
				PreparedStatement st=con.prepareStatement("select * from register where email=?");
				st.setString(1, email);
				ResultSet rs=st.executeQuery();
				rs.last();
				if(rs.getRow()!=0)
				{
					rs.beforeFirst();
						while(rs.next())
						{
							registerbean r=new registerbean();
							r.setEmail(rs.getString(1));
							r.setName(rs.getString(2));
							r.setPhoneno(rs.getString(3));
							r.setNationality(rs.getString(4));
							r.setMaritalstatus(rs.getString(5));
							r.setAge(rs.getInt(6));
							r.setGender(rs.getString(7));
							r.setBod(rs.getString(8));
							r.setAddress(rs.getString(9));
							
							registerlist.add(r);
						}
						return registerlist;
				}
				else
				{
					//JOptionPane.showMessageDialog(null,"No Data Found","INFO",JOptionPane.INFORMATION_MESSAGE);
					return null;
				}

			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}
			
			
			return null;
		}
		
		
		@GET
		@Path("train")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public List<modifytrainbean> getTraindetails()
		{
			List<modifytrainbean> trainlist=new ArrayList<modifytrainbean>();
			trainlist.clear();
			
			try
			{
				  PreparedStatement st=con.prepareStatement("select * from traininfo");
				  ResultSet rs=st.executeQuery();
				  rs.last();
				  if(rs.getRow()!=0)
				  {
					  rs.beforeFirst();
					  while(rs.next())
					  {
						  modifytrainbean m=new modifytrainbean();
						  m.setTrainno(rs.getInt(1));
						  m.setTrainname(rs.getString(2));
						  m.setFromst(rs.getString(3));
						  m.setTost(rs.getString(4));
						  m.setDistance(rs.getInt(5));
						  m.setAt(rs.getString(6));
						  m.setDt(rs.getString(7));
						  m.setMon(rs.getString(8));
						  m.setTues(rs.getString(9));
						  m.setWed(rs.getString(10));
						  m.setThur(rs.getString(11));
						  m.setFri(rs.getString(12));
						  m.setSat(rs.getString(13));
						  m.setSun(rs.getString(14));
						  
						  trainlist.add(m);
					  }
					  return trainlist;
				  }
				  else
				  {
//						JOptionPane.showMessageDialog(null,"No Data Found","INFO",JOptionPane.INFORMATION_MESSAGE);
					   return null;
				  }
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}
			
			
			return null;
		}
		
//		@GET
//		@Path("trainsearch")
//		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//		public List<modifytrainbean> getSearchtrain(searchbean s)
//		{
//			List<modifytrainbean> trainlist=new ArrayList<modifytrainbean>();
//			trainlist.clear();
//			try
//			{
//				PreparedStatement st=con.prepareStatement("select * from traininfo ");
//				ResultSet rs=st.executeQuery();
//				rs.last();
//				if(rs.getRow()!=0)
//				{
//					rs.beforeFirst();
//					while(rs.next())
//					{
//					modifytrainbean m=new modifytrainbean();
//					
//					 m.setTrainno(rs.getInt(1));
//					  m.setTrainname(rs.getString(2));
//					  m.setFromst(rs.getString(3));
//					  m.setTost(rs.getString(4));
//					  m.setAt(rs.getString(5));
//					  m.setDt(rs.getString(6));
//					  m.setMon(rs.getString(7));
//					  m.setTues(rs.getString(8));
//					  m.setWed(rs.getString(9));
//					  m.setThur(rs.getString(10));
//					  m.setFri(rs.getString(11));
//					  m.setSat(rs.getString(12));
//					  m.setSun(rs.getString(13));
//					
//					trainlist.add(m);
//					}
//				return trainlist; 
//				}
//				else
//				{
//					JOptionPane.showMessageDialog(null,"No Data Found","INFO",JOptionPane.INFORMATION_MESSAGE);
//				}
//				
//			}
//			catch(Exception e)
//			{
//				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
//			}
//			
//			return null;
//		}
		
		@GET
		@Path("train/trainno")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public List<modifytrainbean> getTraindetails(int trainno)
		{
			List<modifytrainbean> trainlist=new ArrayList<modifytrainbean>();
			trainlist.clear();
			
			try
			{
				  PreparedStatement st=con.prepareStatement("select * from traininfo where trainno="+trainno);
				  ResultSet rs=st.executeQuery();
				  rs.last();
				  if(rs.getRow()!=0)
				  {
					  rs.beforeFirst();
					  while(rs.next())
					  {
						  modifytrainbean m=new modifytrainbean();
						  m.setTrainno(rs.getInt(1));
						  m.setTrainname(rs.getString(2));
						  m.setFromst(rs.getString(3));
						  m.setTost(rs.getString(4));
						  m.setDistance(rs.getInt(5));
						  m.setAt(rs.getString(6));
						  m.setDt(rs.getString(7));
						  m.setMon(rs.getString(8));
						  m.setTues(rs.getString(9));
						  m.setWed(rs.getString(10));
						  m.setThur(rs.getString(11));
						  m.setFri(rs.getString(12));
						  m.setSat(rs.getString(13));
						  m.setSun(rs.getString(14));
						  
						  trainlist.add(m); 
					  }
				  return trainlist;
				  }
				  else
				  {
//					  JOptionPane.showMessageDialog(null,"No Data Found","INFO",JOptionPane.INFORMATION_MESSAGE);
					  return null;
				  }
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}
			
			return null;
		}
		
		@GET
		@Path("reservation")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public List<reservationbean> getReservation()
		{
			List<reservationbean> reservelist=new ArrayList<reservationbean>();
			reservelist.clear();
			try
			{
				PreparedStatement st=con.prepareStatement("select * from reservation");
				ResultSet rs=st.executeQuery();
				rs.last();
				if(rs.getRow()!=0)
				{
					rs.beforeFirst();
					while(rs.next())
					{
						reservationbean res=new reservationbean();
						
						res.setPnr(rs.getInt(1));
						res.setEmail(rs.getString(2));
						res.setName(rs.getString(3));
						res.setAge(rs.getInt(4));
						res.setPhoneno(rs.getString(5));
						res.setNationality(rs.getString(6));
						res.setGender(rs.getString(7));
						res.setTrainname(rs.getString(8));
						res.setTrainno(rs.getInt(9));
						res.setFromst(rs.getString(10));
						res.setTost(rs.getString(11));
						res.setDoj(rs.getString(12));
						res.setClasss(rs.getString(13));
						res.setPrice(rs.getInt(14));
						
						reservelist.add(res);
					}
					return reservelist;
				}
				else
				{
//					JOptionPane.showMessageDialog(null,"No Data Found","INFO",JOptionPane.INFORMATION_MESSAGE);
					return null;
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}
			
			
			return null;
		}
		
		@GET
		@Path("reservation/pnr")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public List<reservationbean> getReservation(int pnr)
		{
			List<reservationbean> reservelist=new ArrayList<reservationbean>();
			reservelist.clear();
			try
			{
				PreparedStatement st=con.prepareStatement("select * from reservation where pnr="+pnr);
				ResultSet rs=st.executeQuery();
				rs.last();
				if(rs.getRow()!=0)
				{
					rs.beforeFirst();
						while(rs.next())
						{
							reservationbean res=new reservationbean();
							res.setPnr(rs.getInt(1));
							res.setEmail(rs.getString(2));
							res.setName(rs.getString(3));
							res.setAge(rs.getInt(4));
							res.setPhoneno(rs.getString(5));
							res.setNationality(rs.getString(6));
							res.setGender(rs.getString(7));
							res.setTrainname(rs.getString(8));
							res.setTrainno(rs.getInt(9));
							res.setFromst(rs.getString(10));
							res.setTost(rs.getString(11));
							res.setDoj(rs.getString(12));
							res.setClasss(rs.getString(13));
							res.setPrice(rs.getInt(14));
							
							reservelist.add(res);
						}
				return reservelist;
				}
				else
				{
//					JOptionPane.showMessageDialog(null, "No Data Found","INFO",JOptionPane.INFORMATION_MESSAGE);
					return null;
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}
			
			
			return null;
		}
}
