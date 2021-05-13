package com.simplilearn.workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.workshop.model.TransferRequest;
import com.simplilearn.workshop.repository.TransferRequestRepository;

@Service(value = "transferRequestService")
public class TransferRequestServiceImpl implements TransferRequestService {

	@Autowired
	private TransferRequestRepository transferRequestRepository;
	
	@Override
	@Transactional
	public void insertRequest(String username, Long accno) {
		
		transferRequestRepository.insertRequest(username, accno);
		
	}
	
	@Override
	@Transactional
	public TransferRequest findByUsername(String username) {
		
		return transferRequestRepository.findByUsername(username);
	}
}
