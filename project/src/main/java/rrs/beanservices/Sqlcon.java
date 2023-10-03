package rrs.beanservices;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Sqlcon 
{
	Connection getCon()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","RKu99");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.WARNING_MESSAGE);
		}
		return con;
	}
}
