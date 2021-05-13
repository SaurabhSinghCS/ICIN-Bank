package com.simplilearn.workshop.details;

public class TransferDetails {
	
	private long saccount;
	private long raccount;
	private Double amount;
	private String date;
	private String username;
	private String ifsc;
	
	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public long getSaccount() {
		return saccount;
	}
	
	public void setSaccount(long saccount) {
		this.saccount = saccount;
	}
	
	public long getRaccount() {
		return raccount;
	}
	
	public void setRaccount(long raccount) {
		this.raccount = raccount;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

}
