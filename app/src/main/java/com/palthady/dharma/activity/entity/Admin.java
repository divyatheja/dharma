package com.palthady.dharma.activity.entity;

public class Admin {
	
	private String phoneNumber;
	
	private String name;
	private boolean status;
	
	public Admin() {
		this.phoneNumber = "";
		this.name = "";
		this.status = false;
	}
	
	public Admin(String phoneNumber, String name, boolean status) {
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.status = status;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	 
}
