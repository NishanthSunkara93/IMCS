package com.javafiles;

public class Contact {

	private String homeNum;
	private String emergencyNum;
	
	
	
	public Contact() {
		super();
	}
	public Contact(String homeNum, String emergencyNum) {
		super();
		this.homeNum = homeNum;
		this.emergencyNum = emergencyNum;
	}
	public String getHomeNum() {
		return homeNum;
	}
	public void setHomeNum(String homeNum) {
		this.homeNum = homeNum;
	}
	public String getEmergencyNum() {
		return emergencyNum;
	}
	public void setEmergencyNum(String emergencyNum) {
		this.emergencyNum = emergencyNum;
	}
	@Override
	public String toString() {
		return "Contact [homeNum=" + homeNum + ", emergencyNum=" + emergencyNum + "]";
	}
	
	
}
