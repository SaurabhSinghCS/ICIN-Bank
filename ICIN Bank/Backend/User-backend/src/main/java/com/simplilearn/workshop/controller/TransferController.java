package com.simplilearn.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.details.TransferDetails;
import com.simplilearn.workshop.details.UserNameDetails;
import com.simplilearn.workshop.model.Transfer;
import com.simplilearn.workshop.model.TransferRequest;
import com.simplilearn.workshop.model.Users;
import com.simplilearn.workshop.response.TransferResponseDetails;
import com.simplilearn.workshop.service.TransferRequestService;
import com.simplilearn.workshop.service.TransferService;
import com.simplilearn.workshop.service.UserService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class TransferController {
	
	@Autowired
	private TransferService transferService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TransferRequestService transferRequestService;
	
	private String ifsc = "ICIN09030914";
	
	@RequestMapping(value = "/getTransfer" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public List<Transfer> getTransfer(@RequestBody UserNameDetails details) {
		
		return transferService.findByRaccountOrSaccount(userService.findByUsername(details.getUsername()).getAccno());
	}
	
	@RequestMapping(value = "/transferRequest" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public TransferRequest transferRequest(@RequestBody UserNameDetails details) {
		
		Users user = userService.findByUsername(details.getUsername());
		
		System.out.println("--------> transfer request ----> "+details.getUsername());
		
		transferRequestService.insertRequest(details.getUsername(), user.getAccno());
		
		return transferRequestService.findByUsername(details.getUsername());
	}
	
	@RequestMapping(value = "/alreadyTransferRequested" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public TransferRequest alreadyTransferRequested(@RequestBody UserNameDetails details) {
		
		return transferRequestService.findByUsername(details.getUsername());
	}
	
	@RequestMapping(value = "/transferMoney" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public TransferResponseDetails transferMoney(@RequestBody TransferDetails details) {
		
		System.out.println("IFSC : "+details.getIfsc());
		TransferResponseDetails response=new TransferResponseDetails();
		if(details.getAmount() <= 0) {
			
			response.setSaccount(details.getSaccount());
			response.setResponseMessage("Please Enter Valid amount");
			response.setTransferStatus(false);
			
		}
		try {
			if(details.getIfsc().equals(ifsc)) 
			{
						Users sendingUser=userService.findByUsername(details.getUsername());
						Users beforeSendingRUser = userService.findByAccno(details.getRaccount());
//						Users afterSendingSUsers = new Users();
						if(details.getSaccount() == details.getRaccount()) {
							if(sendingUser.getSamount() >= details.getAmount()) {
								
								userService.selfTransfer(sendingUser.getUser_name(), sendingUser.getSamount()-details.getAmount(),
										sendingUser.getPamount()+details.getAmount());
								
									response.setSaccount(details.getSaccount());
									response.setResponseMessage("Amount successfully transfered");
									response.setTransferStatus(true);
									
									transferService.insertTransfer(details.getSaccount(), details.getRaccount(),
											details.getAmount(), details.getDate());
								
								
								
							}else {
								
								response.setSaccount(details.getSaccount());
								response.setResponseMessage("You Don't have sufficient amount in your saving account");
								response.setTransferStatus(false);
							}
						
						}
						else {
							
							if(sendingUser.isTransfer_access()) {
								
								if(sendingUser.getPamount() >= details.getAmount()) {
									
									userService.anotherTransferSender(details.getSaccount(), sendingUser.getPamount()-details.getAmount());
									userService.anotherTransferReciever(details.getRaccount(), beforeSendingRUser.getSamount()+details.getAmount());
									
									response.setSaccount(details.getSaccount());
									response.setResponseMessage("Amount successfully transfered");
									response.setTransferStatus(true);
									
									transferService.insertTransfer(details.getSaccount(), details.getRaccount(),
											details.getAmount(), details.getDate());
									
								}else {
									
									response.setSaccount(details.getSaccount());
									response.setResponseMessage("You Don't have sufficient amount in your Primary account");
									response.setTransferStatus(false);
								}
								
							}else {
								response.setSaccount(details.getSaccount());
								response.setResponseMessage("You Don't have Transfer access to another account");
								response.setTransferStatus(false);
							}
							
						}
			}
			else {
						response.setSaccount(details.getSaccount());
						response.setResponseMessage("IFSC code is incorrect");
						response.setTransferStatus(false);
			}
		} catch (Exception e) {
			response.setSaccount(details.getSaccount());
			response.setResponseMessage("Please provide an IFSC code");
			response.setTransferStatus(false);
			
		}
		return response;
	}

	
}
