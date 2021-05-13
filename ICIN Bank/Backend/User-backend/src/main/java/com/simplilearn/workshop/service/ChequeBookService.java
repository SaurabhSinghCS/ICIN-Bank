package com.simplilearn.workshop.service;

import java.util.List;

import com.simplilearn.workshop.model.ChequeBook;
import com.simplilearn.workshop.model.Chequebookhistory;

public interface ChequeBookService {

	public ChequeBook findByUsername(String username);
	
	public ChequeBook insertChequeBook(String username, int pages, String date);
	
	public List<Chequebookhistory> findAllByUsername(String username);
}
