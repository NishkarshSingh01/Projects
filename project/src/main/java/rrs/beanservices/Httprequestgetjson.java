package rrs.beanservices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import rrs.beans.loginbean;
import rrs.beans.modifytrainbean;
import rrs.beans.registerbean;
import rrs.beans.reservationbean;

public class Httprequestgetjson 
{
	
	String useragent="Mozilla/5.0";
	public List<loginbean> getLogin()
	{
		List<loginbean> loginlist=new ArrayList<loginbean>();
		loginlist.clear();
		String loginurl="http://localhost:8081/rrsproject/getapi/login"; 

		
		try
		{
			URL url=new URL(loginurl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			
			con.setRequestProperty("User-Agent", useragent);
			if(con.getResponseCode()==HttpURLConnection.HTTP_OK) 
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
				StringBuffer sb=new StringBuffer();
				String in;
				while((in=br.readLine())!=null)
				{
					sb.append(in);
				}
				JSONArray ja=new JSONArray(sb.toString());
				for(int i=0;i<ja.length();i++)
				{
					JSONObject jo=new JSONObject(ja.get(i).toString());
					loginbean lo=new loginbean();
					lo.setEmail(jo.getString("email"));
					lo.setName(jo.getString("name"));
					lo.setPassword(jo.getString("password"));
//					lo.setCpassword(jo.getString("cpassword"));
					lo.setUsertype(jo.getString("usertype"));
					loginlist.add(lo);
				}
				System.out.println("JSON"+loginlist);
				return loginlist;
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Get Login Connection not established","INFO",JOptionPane.INFORMATION_MESSAGE);
				return null;
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		return  null;
	}

	public List<registerbean> getRegister()
	{
		List<registerbean> registerlist=new ArrayList<registerbean>();
		registerlist.clear();
		
		String registerurl="http://localhost:8081/rrsproject/getapi/register";
		
		try
		{
			URL url=new URL(registerurl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", useragent);
			if(con.getResponseCode()==HttpURLConnection.HTTP_OK)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
				StringBuffer sb=new StringBuffer();
				String in;
				while((in=br.readLine())!=null)
				{
					sb.append(in);
				}
				
				JSONArray ja=new JSONArray(sb.toString());
				
				for(int i=0;i<ja.length();i++)
				{
					JSONObject jo=new JSONObject(ja.get(i).toString());
					registerbean re=new registerbean();
					re.setEmail(jo.getString("email"));
					re.setName(jo.getString("name"));
					re.setPhoneno(jo.getString("phoneno"));
					re.setNationality(jo.getString("nationality"));
					re.setMaritalstatus(jo.getString("maritalstatus"));
					re.setAge(jo.getInt("age"));
					re.setGender(jo.getString("gender"));
					re.setBod(jo.getString("bod"));
					re.setAddress(jo.getString("address"));
					
					registerlist.add(re);
				}
//				System.out.println("JSON"+registerlist);
				return registerlist;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Get Register Connection not established","INFO",JOptionPane.INFORMATION_MESSAGE);
				return null;
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		
		return null;
	}
	
	public List<modifytrainbean> getTrain()
	{
		List<modifytrainbean> trainlist=new ArrayList<modifytrainbean>();
		trainlist.clear();
		
		String trainurl="http://localhost:8081/rrsproject/getapi/train";
		
		try
		{
			URL url=new URL(trainurl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", useragent);
			if(con.getResponseCode()==HttpURLConnection.HTTP_OK)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
				StringBuffer sb=new StringBuffer();
				String in;
				while((in=br.readLine())!=null)
				{
					sb.append(in);
				}
				
				JSONArray ja=new JSONArray(sb.toString());
				
				for(int i=0;i<ja.length();i++)
				{
					JSONObject jo=new JSONObject(ja.get(i).toString());
					modifytrainbean m=new modifytrainbean();
					m.setTrainno(jo.getInt("trainno"));
					m.setTrainname(jo.getString("trainname"));
					m.setFromst(jo.getString("fromst"));
					m.setTost(jo.getString("tost"));
					m.setDistance(jo.getInt("distance"));
					m.setAt(jo.getString("at"));
					m.setDt(jo.getString("dt"));
					m.setMon(jo.getString("mon"));
					m.setTues(jo.getString("tues"));
					m.setWed(jo.getString("wed"));
					m.setThur(jo.getString("thur"));
					m.setFri(jo.getString("fri"));
					m.setSat(jo.getString("sat"));
					m.setSun(jo.getString("sun"));
					
					trainlist.add(m);
				}
								
				return trainlist;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Get Train Connection Not Established","INFO",JOptionPane.INFORMATION_MESSAGE);				
				return null;
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
		
		String reservationurl="http://localhost:8081/rrsproject/getapi/reservation";
		
		try
		{
			URL url=new URL(reservationurl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", useragent);
			if(con.getResponseCode()==HttpURLConnection.HTTP_OK)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
				StringBuffer sb=new StringBuffer();
				String in;
				while((in=br.readLine())!=null)
				{
					sb.append(in);
				}
				
				JSONArray ja=new JSONArray(sb.toString());
				
				for(int i=0;i<ja.length();i++)
				{
					reservationbean r=new reservationbean();
					JSONObject jo=new JSONObject(ja.get(i).toString());
					
					r.setPnr(jo.getInt("pnr"));
					r.setEmail(jo.getString("email"));
					r.setName(jo.getString("name"));
					r.setAge(jo.getInt("age"));
					r.setPhoneno(jo.getString("phoneno"));
					r.setNationality(jo.getString("nationality"));
					r.setGender(jo.getString("gender"));
					r.setTrainname(jo.getString("trainname"));
					r.setTrainno(jo.getInt("trainno"));
					r.setFromst(jo.getString("fromst"));
					r.setTost(jo.getString("tost"));
					r.setDoj(jo.getString("doj"));
					r.setClasss(jo.getString("classs"));
					r.setPrice(jo.getInt("price"));
					
					reservelist.add(r);
				}
				
				return reservelist;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Get Reservation Connection Not Established","INFO",JOptionPane.INFORMATION_MESSAGE);
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



