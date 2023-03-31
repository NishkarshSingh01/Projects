package rrs.beans;

public class updateprofilebean 
{
	private String name;
	private String email;
	private String phoneno;
	private String nationality;
	private String maritalstatus;
	private int age;
	private String gender;
	private String changemail;
	private String bod;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getChangemail() {
		return changemail;
	}
	public void setChangemail(String changemail) {
		this.changemail = changemail;
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
		return "{\"name\":" + name + "\",\"email\":\"" + email + "\",\"phoneno\":\"" + phoneno + "\",\"nationality\":\""
				+ nationality + "\",\"maritalstatus\":\"" + maritalstatus + "\",\"age\":" + age + ",\"gender\":" + gender + "\",\"bod\":\""
				+ bod + "\",\"address\":\"" + address + "\"";
	}
	
	
}
