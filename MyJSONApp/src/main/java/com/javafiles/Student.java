package com.javafiles;

import java.util.List;

public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private List<Marks> marks;
	private List<Address> address;
	private List<Contact> contact;
	
	public Student() {
		super();
	}
	public Student(int id, String firstName, String lastName, List<Marks> marks, List<Address> address,
			List<Contact> contact) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.marks = marks;
		this.address = address;
		this.contact = contact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Marks> getMarks() {
		return marks;
	}
	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public List<Contact> getContact() {
		return contact;
	}
	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", marks=" + marks
				+ ", address=" + address + ", contact=" + contact + "]";
	}
	
	
}
