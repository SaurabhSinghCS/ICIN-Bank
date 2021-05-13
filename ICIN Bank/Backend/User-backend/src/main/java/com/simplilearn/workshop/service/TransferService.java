package com.simplilearn.workshop.service;

import java.util.List;

import com.simplilearn.workshop.model.Transfer;

public interface TransferService {
	
	public List<Transfer> findByRaccountOrSaccount(Long accno);
	
	public void insertTransfer(long saccount,long raccount,Double amount, String date);
	
}
