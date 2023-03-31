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

import rrs.beans.modifytrainbean;
import rrs.beans.registerbean;
import rrs.beans.reservationbean;

public class Httprequestdeletejson 
{
	String contenttype="application/json";
	String useragent="Mozilla/5.0";
	
	public List<registerbean> deleteRegister(String userid)
	{
		List<registerbean> registerlist=new ArrayList<registerbean>();
		registerlist.clear();
		
		String deleteregisterurl="http://localhost:8081/rrsproject/rrs/deleteapi/loginregister/"+userid;
		
		try
		{
			URL url=new URL(deleteregisterurl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("DELETE");
			con.setRequestProperty("Content-Type", contenttype);
			con.setRequestProperty("Accept", contenttype);
			con.setRequestProperty("User-Agent", useragent);
			
			if(con.getResponseCode()==HttpURLConnection.HTTP_OK)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
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
				return registerlist;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Delete login & Register Connection Not Established","INFO",JOptionPane.INFORMATION_MESSAGE);
				return null;
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		
		
		return null;
	}
	
	
	public List<modifytrainbean> deleteTrain(int trainno)
	{
		List<modifytrainbean> trainlist=new ArrayList<modifytrainbean>();
		trainlist.clear();
		
		String deletetrainurl="http://localhost:8081/rrsproject/rrs/deleteapi/train/"+trainno;
		
		try
		{
			URL url=new URL(deletetrainurl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("DELETE");
			con.setRequestProperty("Content-Type", contenttype);
			con.setRequestProperty("Accept", contenttype);
			con.setRequestProperty("User-Agent", useragent);
			
			if(con.getResponseCode()==HttpURLConnection.HTTP_OK)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
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
					modifytrainbean mt=new modifytrainbean();
					
					mt.setTrainno(jo.getInt("trainno"));
					mt.setTrainname(jo.getString("trainname"));
					mt.setFromst(jo.getString("fromst"));
					mt.setTost(jo.getString("tost"));
					mt.setDistance(jo.getInt("distance"));
					mt.setAt(jo.getString("at"));
					mt.setDt(jo.getString("dt"));
					mt.setMon(jo.getString("mon"));
					mt.setTues(jo.getString("tues"));
					mt.setWed(jo.getString("wed"));
					mt.setThur(jo.getString("thur"));
					mt.setFri(jo.getString("fri"));
					mt.setSat(jo.getString("sat"));
					mt.setSun(jo.getString("sun"));
					
					trainlist.add(mt);
				}
				return trainlist;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Delete Train Connection Not Established","INFO",JOptionPane.INFORMATION_MESSAGE);
				return null;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}
	
	
	public List<reservationbean> deleteReservation(int pnr)
	{
		List<reservationbean> reservelist=new ArrayList<reservationbean>();
		reservelist.clear();
		
		String reservedeleteurl="http://localhost:8081/rrsproject/rrs/deleteapi/reservation/"+pnr;
		
		try
		{
			URL url=new URL(reservedeleteurl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("DELETE");
			con.setRequestProperty("Content-Type",contenttype);
			con.setRequestProperty("Accept", contenttype);
			con.setRequestProperty("User-Agent", useragent);
			
			if(con.getResponseCode()==HttpURLConnection.HTTP_OK)
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
				StringBuffer sb=new StringBuffer();
				String in;
				while((in=br.readLine())!=null)
				{
					sb.append(in);
				}
				
				JSONArray ja=new JSONArray(sb.toString());
				
				for(int i=0;i<ja.length();i++)
				{
					reservationbean res=new reservationbean();
					JSONObject jo=new JSONObject(ja.get(i).toString());
					
					res.setPnr(jo.getInt("pnr"));
					res.setEmail(jo.getString("email"));
					res.setName(jo.getString("name"));
					res.setAge(jo.getInt("age"));
					res.setPhoneno(jo.getString("phoneno"));
					res.setNationality(jo.getString("nationality"));
					res.setGender(jo.getString("gender"));
					res.setTrainname(jo.getString("trainname"));
					res.setTrainno(jo.getInt("trainno"));
					res.setFromst(jo.getString("fromst"));
					res.setTost(jo.getString("tost"));
					res.setDoj(jo.getString("doj"));
					res.setClasss(jo.getString("classs"));
					res.setPrice(jo.getInt("price"));
					
					reservelist.add(res);
				}
				
				return reservelist;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Delete reservation Connection Not Established","INFO",JOptionPane.INFORMATION_MESSAGE);
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



