package rrs.beans;

public class reservationbean
{
	private int pnr;
	private String email;
	private String name;
	private int age;
	private String phoneno;
	private String nationality;
	private String gender;
	private String trainname;
	private int trainno;
	private String fromst;
	private String tost;
	private String doj;
	private String classs;
	private int price;
	
	public reservationbean()
	{
		this.email=null;
		this.name=null;
		this.age=0;
		this.phoneno=null;
		this.nationality=null;
		this.gender=null;
		this.trainname=null;
		this.trainno=0;
		this.fromst=null;
		this.tost=null;
		this.doj=null;
		this.classs=null;
		this.price=0;
	}
	public reservationbean(int pnr,String email,String name,int age,String phoneno,String nationality,String gender,String trainname,int trainno,String fromst,String tost,String doj,String classs,int price)
	{
		this.pnr=pnr;
		this.email=email;
		this.name=name;
		this.age=age;
		this.phoneno=phoneno;
		this.nationality=nationality;
		this.gender=gender;
		this.trainname=trainname;
		this.trainno=trainno;
		this.fromst=fromst;
		this.tost=tost;
		this.doj=doj;
		this.classs=classs;
		this.price=price;
	}
	
	
	public int getPnr() {
		return pnr;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTrainname() {
		return trainname;
	}
	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}
	public int getTrainno() {
		return trainno;
	}
	public void setTrainno(int trainno) {
		this.trainno = trainno;
	}
	public String getFromst() {
		return fromst;
	}
	public void setFromst(String fromst) {
		this.fromst = fromst;
	}
	public String getTost() {
		return tost;
	}
	public void setTost(String tost) {
		this.tost = tost;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getClasss() {
		return classs;
	}
	public void setClasss(String classs) {
		this.classs = classs;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "{\"pnr\":"+pnr+"\"email\":\"" + email + "\",\"name\":\"" + name + "\",\"age\":" + age + ",\"phoneno\":\"" + phoneno
				+ "\",\"nationality\":\"" + nationality + "\",\"gender\":\"" + gender + "\",\"trainname\":\""+trainname+"\",\"trainno\":"+trainno+",\"fromst\":\"" + fromst + "\",\"tost\":\"" + tost
				+ "\",\"doj\":\"" + doj + "\",\"classs\":\"" + classs +"\",\"price\":"+price+"}";
		
	}
	
	
	
}
