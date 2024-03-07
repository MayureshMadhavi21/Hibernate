package com.hibernate;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="student_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
	private int addressId;
    
    @Column(length = 6)
	private int pincode;
    @Column(length = 50)
	private String city;
	private boolean isUrban;
	
	@Transient
	private double x;
	
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	
	@Lob
	private byte[] image;

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", pincode=" + pincode + ", city=" + city + ", isUrban=" + isUrban
				+ ", x=" + x + ", addedDate=" + addedDate + ", image=" + Arrays.toString(image) + "]";
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isUrban() {
		return isUrban;
	}

	public void setUrban(boolean isUrban) {
		this.isUrban = isUrban;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Address(int addressId, int pincode, String city, boolean isUrban, double x, Date addedDate, byte[] image) {
		super();
		this.addressId = addressId;
		this.pincode = pincode;
		this.city = city;
		this.isUrban = isUrban;
		this.x = x;
		this.addedDate = addedDate;
		this.image = image;
	}

}
