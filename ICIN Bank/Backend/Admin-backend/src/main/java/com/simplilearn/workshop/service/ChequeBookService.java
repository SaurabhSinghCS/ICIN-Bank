package com.simplilearn.workshop.service;

import java.util.List;

import com.simplilearn.workshop.model.ChequeBook;
import com.simplilearn.workshop.model.Chequebookhistory;

public interface ChequeBookService {

	public ChequeBook findByUsername(String username);
	
	public List<ChequeBook> findAll();
	
	public ChequeBook insertChequeBook(String username,int pages);
	
	public List<Chequebookhistory> findAllByUsername(String username);
	
	public void deleteByUsername(String username);
	
	public void insertChequebookhistory(String username, int pages, String date, Boolean given);
	
	public Chequebookhistory findByUsernameAndPagesAndDate(String username, int pages, String date);
}
