package com.javafiles;

public class AddressType {

	private String home;
	private String alternateAddress;
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getAlternateAddress() {
		return alternateAddress;
	}
	public void setAlternateAddress(String alternateAddress) {
		this.alternateAddress = alternateAddress;
	}
	@Override
	public String toString() {
		return "AddressType [home=" + home + ", alternateAddress=" + alternateAddress + "]";
	}
	
	
	public AddressType() {
		super();
	}
	public AddressType(String home, String alternateAddress) {
		super();
		this.home = home;
		this.alternateAddress = alternateAddress;
	}
	
	
}
