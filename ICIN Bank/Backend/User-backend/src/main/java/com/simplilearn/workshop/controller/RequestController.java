package com.simplilearn.workshop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.details.ChequeBookRequestDetails;
import com.simplilearn.workshop.details.UserNameDetails;
import com.simplilearn.workshop.model.ChequeBook;
import com.simplilearn.workshop.model.Chequebookhistory;
import com.simplilearn.workshop.service.ChequeBookService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class RequestController {
	
	@Autowired
	private ChequeBookService chequeBookService;
	
	
	@RequestMapping(value = "/chequeBookRequest" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public ChequeBook chequeBookRequest(@RequestBody ChequeBookRequestDetails details) {
		
		System.out.println("Requested "+details.getUsername());
		
		System.out.println("--------> cheque book request ----> "+details.getUsername());
		
		return chequeBookService.insertChequeBook(details.getUsername(), details.getPages(), details.getDate());
	}
	
	@RequestMapping(value = "/alreadyRequested" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public ChequeBook alreadyRequested(@RequestBody UserNameDetails details) {
		
		System.out.println("AlreadyRequested "+details.getUsername());
		
		System.out.println("--------> cheque book already request ----> "+details.getUsername());
		
		return chequeBookService.findByUsername(details.getUsername());
	}
	
	@RequestMapping(value = "/chequebookhistory" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public List<Chequebookhistory> chequebookhistory(@RequestBody UserNameDetails details) {
		
		
		
		return chequeBookService.findAllByUsername(details.getUsername());
	}
	
	
	
	
	
	

}
