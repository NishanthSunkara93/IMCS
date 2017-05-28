package com.assessment2.imcs.classes;

import javax.persistence.Id;

public class Passenger {

	@Id
	private int profile_id;
	private String password;
	private String first_name;
	private String last_name;
	private String email_id;
	private double tel_no;
	private String address;
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public double getTel_no() {
		return tel_no;
	}
	public void setTel_no(double tel_no) {
		this.tel_no = tel_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email_id == null) ? 0 : email_id.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + profile_id;
		long temp;
		temp = Double.doubleToLongBits(tel_no);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email_id == null) {
			if (other.email_id != null)
				return false;
		} else if (!email_id.equals(other.email_id))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (profile_id != other.profile_id)
			return false;
		if (Double.doubleToLongBits(tel_no) != Double.doubleToLongBits(other.tel_no))
			return false;
		return true;
	}
	public Passenger(int profile_id, String password, String first_name, String last_name, String email_id,
			double tel_no, String address) {
		super();
		this.profile_id = profile_id;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.tel_no = tel_no;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "PassengerProfile [profile_id=" + profile_id + ", password=" + password + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", email_id=" + email_id + ", tel_no=" + tel_no + ", address=" + address
				+ "]";
	}
	public Passenger() {
		super();
	}
	
		
}
