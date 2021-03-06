package com.simplilearn.workshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String first_name;
	private String last_name;
	
	@Column(name = "user_name")
	private String username;
	private String dob;
	private String address;
	private String kyc_type;
	private String kyc_id;
	private int validated;
	private String password;
	private boolean is_blocked;
	private boolean transfer_access;
	private Long accno;
	private Double samount;
	private Double pamount;
	private String email;
	
	
	public Users() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getUser_name() {
		return username;
	}


	public void setUser_name(String user_name) {
		this.username = user_name;
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


	public String getKyc_type() {
		return kyc_type;
	}


	public void setKyc_type(String kyc_type) {
		this.kyc_type = kyc_type;
	}


	public String getKyc_id() {
		return kyc_id;
	}


	public void setKyc_id(String kyc_id) {
		this.kyc_id = kyc_id;
	}


	public int getValidated() {
		return validated;
	}


	public void setValidated(int validated) {
		this.validated = validated;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isBlocked() {
		return is_blocked;
	}


	public void setBlocked(boolean isBlocked) {
		this.is_blocked = isBlocked;
	}


	public boolean isTransfer_access() {
		return transfer_access;
	}


	public void setTransfer_access(boolean transfer_access) {
		this.transfer_access = transfer_access;
	}


	public Double getSamount() {
		return samount;
	}


	public void setSamount(Double s_amount) {
		this.samount = s_amount;
	}


	public Double getPamount() {
		return pamount;
	}


	public void setPamount(Double p_amount) {
		this.pamount = p_amount;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getAccno() {
		return accno;
	}


	public void setAccno(Long accno) {
		this.accno = accno;
	}
	
	
	
}
