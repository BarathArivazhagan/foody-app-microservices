package com.barath.app.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String addressName1;
	
	private String addressName2;
	
	private String state;
	
	private String city;
	
	private String pinCode;

	public String getAddressName1() {
		return addressName1;
	}

	public void setAddressName1(String addressName1) {
		this.addressName1 = addressName1;
	}

	public String getAddressName2() {
		return addressName2;
	}

	public void setAddressName2(String addressName2) {
		this.addressName2 = addressName2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Address(String addressName1, String addressName2, String state, String city, String pinCode) {
		super();
		this.addressName1 = addressName1;
		this.addressName2 = addressName2;
		this.state = state;
		this.city = city;
		this.pinCode = pinCode;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Address [addressName1=" + addressName1 + ", addressName2=" + addressName2 + ", state=" + state
				+ ", city=" + city + ", pinCode=" + pinCode + "]";
	}
	
	

}
