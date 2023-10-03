package rrs.beanservices;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import rrs.beans.loginbean;
import rrs.beans.modifytrainbean;
import rrs.beans.registerbean;
import rrs.beans.reservationbean;

public class Httprequestgetapi
{
		Sqlcon c=new Sqlcon();
		Connection con=c.getCon();
		
		public List<loginbean> getLogin()
		{
			List<loginbean>  loginlist=new ArrayList<loginbean>();
			
			loginlist.clear();
			try
			{
				PreparedStatement st=con.prepareStatement("select * from login",ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
		//to set result set to move in both direction forward and backward otherwise it may throws exception
				ResultSet rs=st.executeQuery();
				
				if(rs.isBeforeFirst())
				{
					while(rs.next())
					{
						loginbean lc=new loginbean();
						
						lc.setEmail(rs.getString(1));
						lc.setName(rs.getString(2));
						lc.setPassword(rs.getString(3));
						lc.setUsertype(rs.getString(4));
						
						loginlist.add(lc);
					}
					return loginlist;
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}
			
			return null;
		}
		
	
		public loginbean getLogin(String email)
		{			
			try
			{
				loginbean lc=new loginbean();
				PreparedStatement st=con.prepareStatement("select * from login where email=?",ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
				st.setString(1, email);
				ResultSet rs=st.executeQuery();
				
				if(rs.isBeforeFirst())
				{
					rs.beforeFirst();
					while(rs.next())
					{
						
						lc.setEmail(rs.getString(1));
						lc.setName(rs.getString(2));
						lc.setPassword(rs.getString(3));
						lc.setUsertype(rs.getString(4));
			
					}
					return lc;
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}
			
			return null;
		}
	

		public List<registerbean> getRegister()
		{
			List<registerbean> registerlist=new ArrayList<registerbean>();
			registerlist.clear();
			try
			{
				PreparedStatement st=con.prepareStatement("select * from register",ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=st.executeQuery();
				
				if(rs.isBeforeFirst())
				{
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
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}
			return null;
		}
		
		
		public registerbean getRegister(String email)
		{
			try
			{
				registerbean r=new registerbean();
				PreparedStatement st=con.prepareStatement("select * from register where email=?",ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
				st.setString(1, email);
				ResultSet rs=st.executeQuery();
				
				if(rs.isBeforeFirst())
				{
						while(rs.next())
						{
							r.setEmail(rs.getString(1));
							r.setName(rs.getString(2));
							r.setPhoneno(rs.getString(3));
							r.setNationality(rs.getString(4));
							r.setMaritalstatus(rs.getString(5));
							r.setAge(rs.getInt(6));
							r.setGender(rs.getString(7));
							r.setBod(rs.getString(8));
							r.setAddress(rs.getString(9));
							
						}
						return r;
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}			
			return null;
		}
		
		
		public List<modifytrainbean> getTraindetails()
		{
			List<modifytrainbean> trainlist=new ArrayList<modifytrainbean>();
			trainlist.clear();
			
			try
			{
				  PreparedStatement st=con.prepareStatement("select * from traininfo",ResultSet.TYPE_SCROLL_INSENSITIVE,
                          ResultSet.CONCUR_UPDATABLE);
				  ResultSet rs=st.executeQuery();
				  
				  if(rs.isBeforeFirst())
					{
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
//					  System.out.println("This is error "+trainlist);
					  return trainlist;
				  }
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}	
			return null;
		}
		
		public modifytrainbean getTraindetails(int trainno)
		{			
			try
			{
				  modifytrainbean m=new modifytrainbean();
				  PreparedStatement st=con.prepareStatement("select * from traininfo where trainno="+trainno,ResultSet.TYPE_SCROLL_INSENSITIVE,
                          ResultSet.CONCUR_UPDATABLE);
				  ResultSet rs=st.executeQuery();
				  if(rs.isBeforeFirst())
					{
					  while(rs.next())
					  {
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
						  
					  }
				  return m;
				  }
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}
			
			return null;
		}
		

		public List<reservationbean> getReservation()
		{
			List<reservationbean> reservelist=new ArrayList<reservationbean>();
			reservelist.clear();
			try
			{
				PreparedStatement st=con.prepareStatement("select * from reservation",ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=st.executeQuery();
				if(rs.isBeforeFirst())
				{
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
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}
			return null;
		}
		

		public reservationbean getReservation(int pnr)
		{
			List<reservationbean> reservelist=new ArrayList<reservationbean>();
			reservelist.clear();
			try
			{
				reservationbean res=new reservationbean();
				PreparedStatement st=con.prepareStatement("select * from reservation where pnr="+pnr,ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=st.executeQuery();
				if(rs.isBeforeFirst())
				{
						while(rs.next())
						{
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
						}
				return res;
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
			}
			return null;
		}
}
