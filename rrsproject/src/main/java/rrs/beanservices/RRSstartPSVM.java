package rrs.beanservices;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RRSstartPSVM {

	
	public static int action=0;//for running the main method only once
	public static void main(String[] args)throws IOException  
	{
		
		// TODO Auto-generated method stub
			
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/rrs?createDatabaseIfNotExist=true","root","");
			
			
			PreparedStatement st=con.prepareStatement("create table if not exists login(email varchar(255),name varchar(255) not null,password varchar(255) not null, cpassword varchar(255) not null,usertype varchar(255) not null, primary key(email))");
			
			st.execute();
			st=con.prepareStatement("create table if not exists register(email varchar(255),name varchar(255) not null, phoneno varchar(13),nationality varchar(255),maritalstatus varchar(255),age int(3),gender varchar(11),bod date,address varchar(255),primary key(email))");
			st.execute();
			st=con.prepareStatement("create table if not exists reservation(pnr int(10),email varchar(255),name varchar(255) not null,age int(3) not null,phoneno varchar(13) not null,nationality varchar(255) not null,gender varchar(11),trainname varchar(255),trainno int(20),fromst varchar(255) not null,tost varchar(255) not null,doj date,class varchar(10) not null, price int(5) not null,primary key(pnr))");
			st.execute();
			st=con.prepareStatement("create table if not exists traininfo(trainno varchar(20),trainname varchar(255) not null,fromst varchar(255) not null,tost varchar(255) not null,distance int(5) not null,at varchar(10) not null,dt varchar(10) not null,"
					+ "mon varchar(10) not null,tues varchar(10) not null,wed varchar(10) not null,thur varchar(10) not null,fri varchar(10) not null,sat varchar(10) not null,sun varchar(10) not null,primary key(trainno))");
			st.execute();

			System.out.println("Jay Shree Radhe Krishna");

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
