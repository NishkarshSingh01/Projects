package rrs.beans;

public class searchbean 
{
	private String fromst;
	private String tost;
	private String trainname;
	private int trainno;
	private String date;
	
	public searchbean()
	{
		this.fromst=null;
		this.tost=null;
		this.trainname=null;
		this.trainno=0;
		this.date=null;
	}
	public searchbean(String fromst,String tost,String trainname,int trainno,String date)
	{
		this.fromst=fromst;
		this.tost=tost;
		this.trainname=trainname;
		this.trainno=trainno;
		this.date=date;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "searchbean [fromst=" + fromst + ", tost=" + tost + ", trainname=" + trainname + ", trainno=" + trainno
				+ ", date=" + date + "]";
	}
	
	
	
}
