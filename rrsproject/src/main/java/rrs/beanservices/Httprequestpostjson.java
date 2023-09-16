package rrs.beanservices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
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

public class Httprequestpostjson 
{
	String useragent="Mozilla/5.0";
	String contenttype="application/json";
	
	public List<loginbean> postLogin(loginbean l)
	{
		List<loginbean> loginlist=new ArrayList<loginbean>();
		loginlist.clear();
		
		String loginurl="http://localhost:8081/rrsproject/rrs/postapi/login"; 
		try
		{
			URL url=new URL(loginurl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", contenttype);
			con.setRequestProperty("Accept", contenttype);
			con.setRequestProperty("User-Agent", useragent);
			String pass=DigestUtils.sha256Hex(l.getPassword());
			String cpass=DigestUtils.sha256Hex(l.getCpassword());

			//String pass=DigestUtils("SHA3-256").digestAsHex(l.getPassword());
			//String cpass=DigestUtils("SHA3-256).digestAsHes(l.getCpassword());
			
			String loginbody="{\"email\":\""+l.getEmail()+"\",\"name\":\""+l.getName()+"\",\"password\":\""+pass+"\",\"cpassword\":\""+cpass+"\",\"usertype\":\""+l.getUsertype()+"\"}";
			
			con.setDoOutput(true);
			OutputStream os=con.getOutputStream();
			
			byte[] input=loginbody.getBytes("utf-8");
			os.write(input, 0,input.length);
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
					loginbean lo=new loginbean();
					
					lo.setEmail(jo.getString("email"));
					lo.setName(jo.getString("name"));
					lo.setPassword(jo.getString("password"));
					lo.setCpassword(jo.getString("cpassword"));
					lo.setUsertype(jo.getString("usertype"));
					
					loginlist.add(lo);
				}
				
				return loginlist;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Post Login Connection Not Established","INFO",JOptionPane.INFORMATION_MESSAGE);
				return null;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"warning",JOptionPane.WARNING_MESSAGE);
		}
		
		return null;
	}
	
	public List<registerbean> postRegister(registerbean r)
	{
		List<registerbean> registerlist=new ArrayList<registerbean>();
		registerlist.clear();
		
		String registerurl="http://localhost:8081/rrsproject/rrs/postapi/register";
		
		try
		{
			URL url=new URL(registerurl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", contenttype);
			con.setRequestProperty("Accept", contenttype);
			con.setRequestProperty("User-Agent", useragent);
		
			String registerbody="{\"email\":\""+r.getEmail()+"\",\"name\":\""+r.getName()+"\",\"phoneno\":\""+r.getPhoneno()+"\",\"nationality\":\""+r.getNationality()+"\",\"maritalstatus\":\""+r.getMaritalstatus()+"\",\"age\":"+r.getAge()+",\"gender\":\""+r.getGender()+"\",\"bod\":\""+r.getBod()+"\",\"address\":\""+r.getAddress()+"\"}";
			
			con.setDoOutput(true);
			OutputStream os=con.getOutputStream();
			byte[] input=registerbody.getBytes("utf-8");
			os.write(input, 0,input.length);
			
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
				JOptionPane.showMessageDialog(null,"Post Register Connection Not Established","INFO",JOptionPane.INFORMATION_MESSAGE);
				return null;
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}
	
	public List<modifytrainbean> postTrain(modifytrainbean m)
	{
		List<modifytrainbean> trainlist=new ArrayList<modifytrainbean>();
		trainlist.clear();
		
		String trainurl="http://localhost:8081/rrsproject/rrs/postapi/train";
		
		try
		{
			URL url=new URL(trainurl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", contenttype);
			con.setRequestProperty("Accept", contenttype);
			con.setRequestProperty("User-Agent", useragent);
		
			String trainbody="{\"trainno\":"+m.getTrainno()+",\"trainname\":\""+m.getTrainname()+"\",\"fromst\":\""+m.getFromst()+"\",\"tost\":\""+m.getTost()+"\",\"distance\":"+m.getDistance()+",\"at\":\""+m.getAt()+"\",\"dt\":\""+m.getDt()+"\",\"mon\":\""+m.getMon()+"\",\"tues\":\""+m.getTues()+"\",\"wed\":\""+m.getWed()+"\",\"thur\":\""+m.getThur()+"\",\"fri\":\""+m.getFri()+"\",\"sat\":\""+m.getSat()+"\",\"sun\":\""+m.getSun()+"\"}";
			
			con.setDoOutput(true);
			OutputStream os=con.getOutputStream();
			byte[] input=trainbody.getBytes("utf-8");
			os.write(input,0,input.length);
			
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
				JOptionPane.showMessageDialog(null,"Post Train Connection Not Established","INFO",JOptionPane.INFORMATION_MESSAGE);
				return null;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}
	
	public List<reservationbean> postReservation(reservationbean r)
	{
		List<reservationbean> reservelist=new ArrayList<reservationbean>();
		reservelist.clear();
		
		String reserveurl="http://localhost:8081/rrsproject/rrs/postapi/reservation";
		
		try
		{
			URL url=new URL(reserveurl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type",contenttype);
			con.setRequestProperty("Accept", contenttype);
			con.setRequestProperty("User-Agent", useragent);
			
			String reservationbody="{\"pnr\":"+r.getPnr()+",\"email\":\""+r.getEmail()+"\",\"name\":\""+r.getName()+"\",\"age\":"+r.getAge()+",\"phoneno\":\""+r.getPhoneno()+"\",\"nationality\":\""+r.getNationality()+"\",\"gender\":\""+r.getGender()+"\",\"trainname\":\""+r.getTrainname()+"\",\"trainno\":"+r.getTrainno()+",\"fromst\":\""+r.getFromst()+"\",\"tost\":\""+r.getTost()+"\",\"doj\":\""+r.getDoj()+"\",\"classs\":\""+r.getClasss()+"\",\"price\":"+r.getPrice()+"}";
			
			con.setDoOutput(true);
			OutputStream os=con.getOutputStream();
			byte[] input=reservationbody.getBytes("utf-8");
			os.write(input,0,input.length);
			
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
					res.setPnr(jo.getInt("price"));
					
					reservelist.add(res);
				}
				
				return reservelist;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Post Reservation Connection Not Established","INFO",JOptionPane.INFORMATION_MESSAGE);
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









