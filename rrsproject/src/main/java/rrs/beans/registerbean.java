package rrs.beans;

public class registerbean 
{
	private String email;
	private String name;
	private String phoneno;
	private String nationality;
	private String maritalstatus;
	private int age;
	private String gender;
	private String bod;
	private String address;
	
	public registerbean()
	{
		this.email=null;
		this.name=null;
		this.phoneno=null;
		this.nationality=null;
		this.maritalstatus=null;
		this.age=0;
		this.gender=null;
		this.bod=null;
		this.address=null;
	}
	public registerbean(String email,String name,String phoneno,String nationality,String maritalstatus,int age,String gender,String bod,String address)
	{
		this.email=email;
		this.name=name;
		this.phoneno=phoneno;
		this.nationality=nationality;
		this.maritalstatus=maritalstatus;
		this.age=age;
		this.gender=gender;
		this.bod=bod;
		this.address=address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getMaritalstatus() {
		return maritalstatus;
	}
	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBod() {
		return bod;
	}
	public void setBod(String bod) {
		this.bod = bod;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "{\"email\":\"" + email + "\",\"name\":\"" + name + "\",\"phoneno\":\"" + phoneno + "\",\"nationality\":\"" + nationality
				+ "\",\"maritalstatus\":\"" + maritalstatus + "\",\"age\":" + age + ",\"gender\":\"" + gender + "\",\"bod\":\"" + bod
				+ "\",\"address\":\"" + address + "\"}";
	}
	
	
}
