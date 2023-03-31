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
import rrs.beans.updateprofilebean;

public class Httprequestputjson 
{
	String contenttype="application/json";
	String useragent="Mozilla/5.0";
	
	public List<loginbean> changePassword(loginbean l)
	{
		List<loginbean> loginlist=new ArrayList<loginbean>();
		loginlist.clear();
		
		String changepasswordurl="http://localhost:8081/rrsproject/rrs/putapi/login/changepassword";

		try
		{
			URL url=new URL(changepasswordurl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", contenttype);
			con.setRequestProperty("Accept", contenttype);
			con.setRequestProperty("User-Agent", useragent);
			
			String changepasswordbody="{\"email\":\""+l.getEmail()+"\",\"password\":\""+l.getPassword()+"\",\"cpassword\":\""+l.getCpassword()+"\",\"usertype\":\""+l.getUsertype()+"\"}";
			
			con.setDoOutput(true);
			OutputStream os=con.getOutputStream();
			byte[] input=changepasswordbody.getBytes("utf-8");
			os.write(input, 0, input.length);
			
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
					lo.setPassword(jo.getString("password"));
					lo.setCpassword(jo.getString("cpassword"));
					lo.setUsertype(jo.getString("usertype"));
					
					loginlist.add(lo);
				}
				
				return loginlist;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Put Login & Register Connection Not Established","INFO",JOptionPane.INFORMATION_MESSAGE);
				return null;
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		
		return null;
	}
	
	public List<updateprofilebean> updateProfile(updateprofilebean r,String userid)
	{
		List<updateprofilebean> updateprofile=new ArrayList<updateprofilebean>();
		updateprofile.clear();
		
		String updateprofileurl="http://localhost:8081/rrsproject/rrs/putapi/loginregister/"+userid;
		
		try
		{
			URL url=new URL(updateprofileurl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type",contenttype);
			con.setRequestProperty("Accept", contenttype);
			con.setRequestProperty("User-Agent", useragent);
			
			String updateprofilebody="{\"email\":\""+r.getEmail()+"\",\"name\":\""+r.getName()+"\",\"phoneno\":\""+r.getPhoneno()+"\",\"nationality\":\""+r.getNationality()+"\",\"maritalstatus\":\""+r.getMaritalstatus()+"\",\"age\":"+r.getAge()+",\"gender\":\""+r.getGender()+"\",\"changemail\":\""+r.getChangemail()+"\",\"bod\":\""+r.getBod()+"\",\"address\":\""+r.getAddress()+"\"}";
			
			con.setDoOutput(true);
			OutputStream os=con.getOutputStream();
			byte[] input=updateprofilebody.getBytes("utf-8");
			os.write(input, 0, input.length);
			
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
					updateprofilebean re=new updateprofilebean();
					
					re.setEmail(jo.getString("email"));
					re.setName(jo.getString("name"));
					re.setPhoneno(jo.getString("phoneno"));
					re.setNationality(jo.getString("nationality"));
					re.setMaritalstatus(jo.getString("maritalstatus"));
					re.setAge(jo.getInt("age"));
					re.setGender(jo.getString("gender"));
					re.setChangemail(jo.getString("changemail"));
					re.setBod(jo.getString("bod"));
					re.setAddress(jo.getString("address"));
					
					updateprofile.add(re);
				}
				return updateprofile;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Put Register Connection Not Established","INFO",JOptionPane.INFORMATION_MESSAGE);
				return null;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"Warning",JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}
	
	public List<modifytrainbean> updateTrain(modifytrainbean m,int trainno)
	{
		List<modifytrainbean> trainlist=new ArrayList<modifytrainbean>();
		trainlist.clear();
		
		String updatetrainurl="http://localhost:8081/rrsproject/rrs/putapi/train/"+trainno;
		
		try
		{
			URL url=new URL(updatetrainurl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type",contenttype);
			con.setRequestProperty("Accept", contenttype);
			con.setRequestProperty("User-Agent", useragent);
			
			String updatetrainbody="{\"trainname\":\""+m.getTrainname()+"\",\"fromst\":\""+m.getFromst()+"\",\"tost\":\""+m.getTost()+"\",\"distance\":"+m.getDistance()+",\"at\":\""+m.getAt()+"\",\"dt\":\""+m.getDt()+"\",\"mon\":\""+m.getMon()+"\",\"tues\":\""+m.getTues()+"\",\"wed\":\""+m.getWed()+"\",\"thur\":\""+m.getThur()+"\",\"fri\":\""+m.getFri()+"\",\"sat\":\""+m.getSat()+"\",\"sun\":\""+m.getSun()+"\"}";
			
			con.setDoOutput(true);
			OutputStream os=con.getOutputStream();
			byte[] input=updatetrainbody.getBytes("utf-8");
			os.write(input,0,input.length);
			
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
				JOptionPane.showMessageDialog(null, "Put Train Connection Not Established","INFO",JOptionPane.INFORMATION_MESSAGE);
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








