package com.simplilearn.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.details.UserNameDetails;
import com.simplilearn.workshop.model.ChequeBook;
import com.simplilearn.workshop.model.TransferRequest;
import com.simplilearn.workshop.model.Users;
import com.simplilearn.workshop.service.ChequeBookService;
import com.simplilearn.workshop.service.TransferRequestService;
import com.simplilearn.workshop.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class RequestController {
	
	@Autowired
	private ChequeBookService chequeBookService;
	
	@Autowired
	private TransferRequestService transferRequestService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/chequeBook" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.GET)
	public List<ChequeBook> chequeBook(){
		
		return chequeBookService.findAll();
	}
	
	
	@RequestMapping(value = "/confirmChequeBook" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public ChequeBook confirmChequeBook(@RequestBody UserNameDetails details){
		
		ChequeBook chequeBook = chequeBookService.findByUsername(details.getUsername());
		
		chequeBookService.insertChequebookhistory(chequeBook.getUsername(), 
				chequeBook.getPages(), chequeBook.getDate(), true);
		
		if(chequeBookService.findByUsernameAndPagesAndDate(chequeBook.getUsername(), chequeBook.getPages(),
				chequeBook.getDate()) != null) {
			chequeBookService.deleteByUsername(chequeBook.getUsername());
			return chequeBookService.findByUsername(details.getUsername());
		}
		return chequeBookService.findByUsername(details.getUsername());
	}
	
	@RequestMapping(value = "/declineChequeBook" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public ChequeBook declineChequeBook(@RequestBody UserNameDetails details){
		
		ChequeBook chequeBook = chequeBookService.findByUsername(details.getUsername());
		
		chequeBookService.insertChequebookhistory(chequeBook.getUsername(), 
				chequeBook.getPages(), chequeBook.getDate(), false);
		
		if(chequeBookService.findByUsernameAndPagesAndDate(chequeBook.getUsername(), chequeBook.getPages(),
				chequeBook.getDate()) != null) {
			chequeBookService.deleteByUsername(chequeBook.getUsername());
			return chequeBookService.findByUsername(details.getUsername());
		}
		return chequeBookService.findByUsername(details.getUsername());
		
	}
	
	
	// Getting all transfer requests
	@RequestMapping(value = "/allTransferRequests" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.GET)
	public List<TransferRequest> allTransferRequests(){
		
		return transferRequestService.findAll();
		
	}
	
	@RequestMapping(value = "/confirmTransferRequest" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public Users confirmTransferRequest(@RequestBody UserNameDetails details){
		
		userService.giveTransferAccess(details.getUsername());
		
		transferRequestService.deleteTransferRequest(details.getUsername());
		
		return userService.findByUsername(details.getUsername());
	}
	
	@RequestMapping(value = "/declineTransferRequest" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public Users declineTransferRequest(@RequestBody UserNameDetails details){
		
		transferRequestService.deleteTransferRequest(details.getUsername());
		
		return userService.findByUsername(details.getUsername());
		
	}
	
	
	
}
