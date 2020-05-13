package com.bridgelabz.bookstore.dto;

import org.springframework.stereotype.Component;

import com.bridgelabz.bookstore.entity.CustomerInformation;

@Component
public class CustomerDto {
	
	private String Name;
	private long Phonenumber;
	private long Pincode;
	private String Locality;
	private String Address;
	private String City;
	private String Landmark;
	private CustomerInformation Type;
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public long getPhonenumber() {
		return Phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		Phonenumber = phonenumber;
	}

	public long getPincode() {
		return Pincode;
	}

	public void setPincode(long pincode) {
		Pincode = pincode;
	}

	public String getLocality() {
		return Locality;
	}

	public void setLocality(String locality) {
		Locality = locality;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getLandmark() {
		return Landmark;
	}

	public void setLandmark(String landmark) {
		Landmark = landmark;
	}

	public CustomerInformation getType() {
		return Type;
	}

	public void setType(CustomerInformation type) {
		Type = type;
	}

	@Override
	public String toString() {
		return "CustomerDto [Name=" + Name + ", Phonenumber=" + Phonenumber + ", Pincode=" + Pincode + ", Locality="
				+ Locality + ", Address=" + Address + ", City=" + City + ", Landmark=" + Landmark + ", Type=" + Type
				+ "]";
	}

	
	
	
}
