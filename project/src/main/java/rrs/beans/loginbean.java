package rrs.beans;


public class loginbean 
{
	private String email;
	private String name;
	private String password;
	private String usertype;
	public loginbean()
	{
		this.email=null;
		this.password=null;
		this.name=null;
		this.usertype=null;
	}
	public loginbean(String email,String name,String password,String usertype)
	{
		this.email=email;
		this.name=name;
		this.password=password;
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
		return "{\"email\":\""+email+"\",\"name\":\""+name+"\",\"password\":\""+password+"\",\"usertype\":\""+usertype+"\"}";
	}
}
