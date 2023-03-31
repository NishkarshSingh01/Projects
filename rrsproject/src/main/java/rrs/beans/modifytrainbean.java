package rrs.beans;

public class modifytrainbean 
{
	private int trainno;
	private String trainname;
	private String fromst;
	private String tost;
	private int distance;
	private String at;
	private String dt;
	private String mon,tues,wed,thur,fri,sat,sun;
	
	public modifytrainbean()
	{
		this.trainno=0;
		this.trainname=null;
		this.fromst=null;
		this.tost=null;
		this.distance=0;
		this.at=null;
		this.dt=null;
		this.mon=null;
		this.tues=null;
		this.wed=null;
		this.thur=null;
		this.fri=null;
		this.sat=null;
		this.sun=null;
	}
	public modifytrainbean(int trainno,String trainname,String fromst,String tost,int distance,String at,String dt,String mon,String tues,String wed,String thur,String fri,String sat,String sun)
	{
		this.trainno=trainno;
		this.trainname=trainname;
		this.fromst=fromst;
		this.tost=tost;
		this.distance=distance;
		this.at=at;
		this.dt=dt;
		this.mon=mon;
		this.tues=tues;
		this.wed=wed;
		this.thur=thur;
		this.fri=fri;
		this.sat=sat;
		this.sun=sun;
	}
	public int getTrainno() {
		return trainno;
	}
	public void setTrainno(int trainno) {
		this.trainno = trainno;
	}
	public String getTrainname() {
		return trainname;
	}
	public void setTrainname(String trainname) {
		this.trainname = trainname;
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
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getAt() {
		return at;
	}
	public void setAt(String at) {
		this.at = at;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public String getMon() {
		return mon;
	}
	public void setMon(String mon) {
		this.mon = mon;
	}
	public String getTues() {
		return tues;
	}
	public void setTues(String tues) {
		this.tues = tues;
	}
	public String getWed() {
		return wed;
	}
	public void setWed(String wed) {
		this.wed = wed;
	}
	public String getThur() {
		return thur;
	}
	public void setThur(String thur) {
		this.thur = thur;
	}
	public String getFri() {
		return fri;
	}
	public void setFri(String fri) {
		this.fri = fri;
	}
	public String getSat() {
		return sat;
	}
	public void setSat(String sat) {
		this.sat = sat;
	}
	public String getSun() {
		return sun;
	}
	public void setSun(String sun) {
		this.sun = sun;
	}
	@Override
	public String toString() {
		return "{\"trainno\":" + trainno + ",\"trainname\":\"" + trainname + "\",\"fromst\":\"" + fromst + "\",\"tost\":\""+tost+"\",\"distance\":"+distance
				 + ",\"at\":\"" + at + "\",\"dt\":\"" + dt + "\",\"mon\":\"" + mon + "\",\"tues\":\"" + tues + "\",\"wed\":\"" + wed + "\",\"thur\":\""
				+ thur + "\",\"fri\":\"" + fri + "\",\"sat\":\"" + sat + "\",\"sun\":\"" + sun + "}";
	}
	
	
	
	
}
