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
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/rrs","root","");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.WARNING_MESSAGE);
		}
		return con;
	}
}
