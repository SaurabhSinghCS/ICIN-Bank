package com.simplilearn.workshop.service;

import com.simplilearn.workshop.model.TransferRequest;

public interface TransferRequestService {

	public void insertRequest(String username,Long accno);
	
	public TransferRequest findByUsername(String username);
	
}
