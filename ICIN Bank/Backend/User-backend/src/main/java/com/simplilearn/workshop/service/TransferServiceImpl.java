package com.simplilearn.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.workshop.model.Transfer;
import com.simplilearn.workshop.repository.TransferRepository;

@Service(value = "transferService")
public class TransferServiceImpl implements TransferService {

	@Autowired
	private TransferRepository transferRepository;
	
	@Override
	@Transactional
	public List<Transfer> findByRaccountOrSaccount(Long accno) {
		
		return transferRepository.findByRaccountOrSaccount(accno,accno);
	}

	@Override
	@Transactional
	public void insertTransfer(long saccount, long raccount, Double amount, String date) {
		
		transferRepository.insertTransfer(saccount, raccount, amount, date);
		
	}
}
