package com.javafiles;

import java.util.List;

public class Address {

	private String city;
	private String street;
	private String country;
	private int zipcode;
	private List<AddressType> addressType;
	
	
	
	public Address() {
		super();
	}
	public Address(String city, String street, String country, int zipcode, List<AddressType> addressType) {
		super();
		this.city = city;
		this.street = street;
		this.country = country;
		this.zipcode = zipcode;
		this.addressType = addressType;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public List<AddressType> getAddressType() {
		return addressType;
	}
	public void setAddressType(List<AddressType> addressType) {
		this.addressType = addressType;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", country=" + country + ", zipcode=" + zipcode
				+ ", addressType=" + addressType + "]";
	}
	
	
	
}
