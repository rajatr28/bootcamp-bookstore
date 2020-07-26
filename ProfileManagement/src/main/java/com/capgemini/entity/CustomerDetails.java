package com.capgemini.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="customerdetails")
@DynamicUpdate(true)
@DynamicInsert(true)
public class CustomerDetails {

	@Id
	@Column(name="customer_id")
	private Integer customer_id;
	
	@NotEmpty(message = "Name is required")
	@Column(name="name")
	private String name;
	
	@NotEmpty(message = "Email is required")
	@Column(name="email")
	private String email;
	
	@Column(name="phonenumber")
	private String phonenumber;
	
	@NotEmpty(message = "address is required")
	@Column(name="address")
	private String address;
	
	@NotEmpty(message = "city is required")
	@Column(name="city")
	private String city;
	
	@Column(name="zipcode")
	@NotEmpty(message = "zipcode is required")
	private String zipcode;
	
	@NotEmpty(message = "Country is required")
	@Column(name="country")
	private String country;

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CustomerDetails(int customer_id,String name,String email,String phonenumber,String address,String city,String zipcode,String country) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.country = country;
	}
	
	public CustomerDetails() {
		super();
	}
	
	@Override
	public String toString() {
		return "Customer[customer_id=" + customer_id +", name=" + name +", email=" + email +",phonenumber=" + phonenumber +", address=" + address +", city=" + city +", zipcode=" + zipcode +", country=" + country +"]";
	}
}
