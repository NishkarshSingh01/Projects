package rrs.beans;

public class loginbean 
{
	private String email;
	private String name;
	private String password;
	private String cpassword;
	private String usertype;
	public loginbean()
	{
		this.email=null;
		this.password=null;
		this.cpassword=null;
		this.usertype=null;
	}
	public loginbean(String email,String password,String cpassword,String usertype)
	{
		this.email=email;
		this.password=password;
		this.cpassword=cpassword;
		this.usertype=usertype;
	}
	
	public String getEmail()
	{
	  return this.email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getCpassword()
	{
		return this.cpassword;
	}
	public void setCpassword(String cpassword)
	{
		this.cpassword=cpassword;
	}
	public void setUsertype(String usertype)
	{
		this.usertype=usertype;
	}
	public String getUsertype()
	{
		return this.usertype;
	}
	
	@Override
	public String toString()
	{
		return "{\"email\":\""+email+"\",\"name\":\""+name+"\",\"password\":\""+password+"\",\"cpassword\":\""+cpassword+"\",\"usertype\":\""+usertype+"\"}";
	}
}
