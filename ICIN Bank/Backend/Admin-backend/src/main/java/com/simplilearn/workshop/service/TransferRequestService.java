package com.simplilearn.workshop.service;

import java.util.List;

import com.simplilearn.workshop.model.TransferRequest;

public interface TransferRequestService {

	public List<TransferRequest> findAll();
	
	public void deleteTransferRequest(String username);
	
	public TransferRequest findByUsername(String username);
}
