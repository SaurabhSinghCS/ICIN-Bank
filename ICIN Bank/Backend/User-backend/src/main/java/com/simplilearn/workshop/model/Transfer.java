package com.simplilearn.workshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transfer")
public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "saccount")
	private long saccount;
	
	@Column(name = "raccount")
	private long raccount;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "date")
	private String date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
