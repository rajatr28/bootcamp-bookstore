package com.capgemini.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="profile")
@DynamicUpdate(true)
@DynamicInsert(true)

public class Profile {
	
	@Id
	@Column(name="profile_id")
	private Integer profile_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private CustomerDetails customer_id;

	public Integer getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(Integer profile_id) {
		this.profile_id = profile_id;
	}

	public CustomerDetails getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(CustomerDetails customer_id) {
		this.customer_id = customer_id;
	}
	
	public Profile(Integer profile_id,CustomerDetails customer_id) {
		super();
		this.profile_id = profile_id;
		this.customer_id = customer_id;

	} 
	
	public Profile() {
		super();
	}
	
	@Override
	public String toString() {
		return "profile[profile_id=" + profile_id +",customer_id=" + customer_id +"]";
	}
}