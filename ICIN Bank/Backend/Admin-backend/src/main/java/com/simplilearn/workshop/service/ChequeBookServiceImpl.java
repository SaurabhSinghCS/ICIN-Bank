package com.simplilearn.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.workshop.model.ChequeBook;
import com.simplilearn.workshop.model.Chequebookhistory;
import com.simplilearn.workshop.repository.ChequeBookRepository;
import com.simplilearn.workshop.repository.ChequebookhistoryRepository;

@Service(value = "chequeBookService")
public class ChequeBookServiceImpl implements ChequeBookService {
	
	@Autowired
	private ChequeBookRepository chequeBookRepository;
	
	@Autowired
	private ChequebookhistoryRepository chequebookhistoryRepository;

	@Override
	@Transactional
	public ChequeBook findByUsername(String username) {
		
		return chequeBookRepository.findByUsername(username);
	}

	@Override
	@Transactional
	public ChequeBook insertChequeBook(String username, int pages) {
		
		chequeBookRepository.insertChequeBook(username, pages);
		
		return chequeBookRepository.findByUsername(username);
	}
	
	@Override
	@Transactional
	public List<ChequeBook> findAll() {
		
		return chequeBookRepository.findAll();
	}
	
	@Override
	@Transactional
	public List<Chequebookhistory> findAllByUsername(String username) {
		
		return chequebookhistoryRepository.findAllByUsername(username);
	}

	
	@Override
	@Transactional
	public void deleteByUsername(String username) {
		
		chequeBookRepository.deleteByUsername(username);
		
	}
	
	@Override
	@Transactional
	public void insertChequebookhistory(String username, int pages, String date, Boolean given) {
		
		chequebookhistoryRepository.insertChequebookhistory(username, pages, date, given);
		
	}
	
	@Override
	@Transactional
	public Chequebookhistory findByUsernameAndPagesAndDate(String username, int pages, String date) {
		
		return chequebookhistoryRepository.findByUsernameAndPagesAndDate(username, pages, date);
	}
}
