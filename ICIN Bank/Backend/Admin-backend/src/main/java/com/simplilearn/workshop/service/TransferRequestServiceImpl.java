package com.simplilearn.workshop.service;

import java.util.List;

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
	public List<TransferRequest> findAll() {
		
		return transferRequestRepository.findAll();
		
	}
	
	@Override
	@Transactional
	public void deleteTransferRequest(String username) {
		
		transferRequestRepository.deleteTransferRequest(username);
		
	}
	
	@Override
	@Transactional
	public TransferRequest findByUsername(String username) {
		
		return transferRequestRepository.findByUsername(username);
		
	}

}
