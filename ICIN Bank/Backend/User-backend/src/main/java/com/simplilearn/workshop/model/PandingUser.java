package com.simplilearn.workshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pandingusers")
public class PandingUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "kyc_type")
	private String kyctype;
	
	@Column(name = "kyc_id")
	private String kycid;
	
	
	
	public PandingUser() {
		super();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getKyctype() {
		return kyctype;
	}



	public void setKyctype(String kyctype) {
		this.kyctype = kyctype;
	}



	public String getKycid() {
		return kycid;
	}



	public void setKycid(String kycid) {
		this.kycid = kycid;
	}


}
