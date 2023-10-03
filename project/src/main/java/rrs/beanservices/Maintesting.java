package rrs.beanservices;

import javassist.bytecode.CodeIterator.Gap;
import rrs.beans.loginbean;
import rrs.beans.modifytrainbean;

public class Maintesting 
{
	public static void main(String args[])
	{
		Httprequestgetapi httprequestgetapi=new Httprequestgetapi();
		Httprequestpostapi httprequestpostapi=new Httprequestpostapi();
		
		loginbean login=new loginbean();
		modifytrainbean mbean=new modifytrainbean();
	    int trainno=19;
		
		  String trainname="south bihar"; String fromst="angul"; String tost="gaya";
		  String at="9:40"; String dt="9:45"; String mon="yes"; String tues="yes";
		 String wed="yes"; String thur="no"; String fri="no"; String sat="yes"; String
		  sun="no"; mbean.setTrainno(trainno); mbean.setTrainname(trainname);
		  mbean.setAt(at); mbean.setDistance(100); mbean.setDt(dt); mbean.setFri(fri);
		  mbean.setFromst(fromst); mbean.setTost(tost); mbean.setMon(mon);
		  mbean.setTues(tues); mbean.setWed(wed); mbean.setThur(thur);
		  mbean.setSat(sat); mbean.setSun(sun);
		 
	    login.setEmail("udit@gmail.com");
	    login.setName("JSK");
	    login.setPassword("RKU99");
	    login.setUsertype("User");
//	    System.out.println(httprequestpostapi.postLogin(login));
		System.out.println(httprequestgetapi.getLogin());
//		System.out.println(httprequestpostapi.postTraindetails(mbean));
		System.out.println(httprequestgetapi.getTraindetails());
		
	}
}
