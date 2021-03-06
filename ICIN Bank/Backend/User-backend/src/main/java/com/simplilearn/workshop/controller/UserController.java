package com.simplilearn.workshop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.details.LoginCredentialDetails;
import com.simplilearn.workshop.details.PandingUserDetails;
import com.simplilearn.workshop.details.ResultReturnDetails;
import com.simplilearn.workshop.details.UniqueDetails;
import com.simplilearn.workshop.details.UpdateUserDetails;
import com.simplilearn.workshop.details.UserNameDetails;
import com.simplilearn.workshop.model.PandingUser;
import com.simplilearn.workshop.model.UserHistory;
import com.simplilearn.workshop.model.Users;
import com.simplilearn.workshop.response.UpdateResponseDetails;
import com.simplilearn.workshop.service.PandingUserService;
import com.simplilearn.workshop.service.UserHistoryService;
import com.simplilearn.workshop.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PandingUserService pandingUserService;
	
	@Autowired
	private UserHistoryService userHistoryService;
	
	@RequestMapping(value = "/validateLogin" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public Users isValidLogin(@RequestBody LoginCredentialDetails details) {
		System.out.println("reached  "+details.getPassword()+"  "+details.getUsername());
		Users user = userService.findByUsername(details.getUsername());
		return user;
	}
	
	@RequestMapping(value = "/isUserPanding" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public PandingUser isUserPanding(@RequestBody LoginCredentialDetails details) {

		System.out.println("reached  "+details.getPassword()+"  "+details.getUsername());
		
		return pandingUserService.findByUserName(details.getUsername());
	}
	
	@RequestMapping(value = "/registerUser" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public PandingUser isUserPanding(@RequestBody PandingUserDetails details) {

		System.out.println("meet "+details.getFirstname()+" "+details.getLastname()+" "+details.getUsername()+" "+details.getKyctype());
		
		pandingUserService.insertIntoPandingUser(details);
		
		return pandingUserService.findByUserName(details.getUsername());
	}
	
	@RequestMapping(value = "/isUnique" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public ResultReturnDetails isUnique(@RequestBody UniqueDetails details) {

		ResultReturnDetails result = new ResultReturnDetails();
		PandingUser pandingUser = pandingUserService.findByUserName(details.getUsername());
		
		if(pandingUser == null) {
			PandingUser pandingUser1 = pandingUserService.findByKycid(details.getKycid());
			if(pandingUser1 == null) {
				Users user1 = userService.findByUsername(details.getUsername());
				if(user1 == null) {
					Users user2 = userService.findByUsername(details.getKycid());
					if(user2 == null) {
						result.setUnique(true);
						result.setMessage("");
					}else {
						result.setUnique(false);
						result.setMessage("Kyc Id is already Present Please Login");
					}
				}else {
					result.setUnique(false);
					result.setMessage("User Name is already Present Please Login");
				}
			}else {
				result.setUnique(false);
				result.setMessage("Kyc Id is already Present Please wait for activation");
			}
		}else {
			result.setUnique(false);
			result.setMessage("User Name is already Present Please wait for activation");
		}
		
		
		return result;
	}
	
	
	@RequestMapping(value = "/getUser" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public Users getUser(@RequestBody UserNameDetails details) {

		return userService.findByUsername(details.getUsername());
	}
	
	
	//finding user History By User Name
	@RequestMapping(value = "/getUserHistory" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public List<UserHistory> getUserHistory(@RequestBody UserNameDetails details) {

		return userHistoryService.findAllByUsername(details.getUsername());
	}
	
	// Getting all transfer requests
	@RequestMapping(value = "/allTransfer" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.GET)
	public List<UserHistory> allTransfer(@RequestBody UserNameDetails details) {

		return userHistoryService.findAllByUsername(details.getUsername());
	}
	
	//update profile
	@RequestMapping(value = "/updateUser" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.GET)
	public UpdateResponseDetails updateUser(@RequestBody UpdateUserDetails details) {

		System.out.println("--------> transfer request ----> "+details.getUsername());
		
		userService.updateUser(details.getUsername(), details.getEmail(), details.getAddress(), details.getNewpassword());
		Users user = userService.findByUsername(details.getUsername());
		UpdateResponseDetails responseDetails = new UpdateResponseDetails();
		responseDetails.setResponseMessage("Some Error have occured");
		responseDetails.setTransferStatus(false);
		if(user.getEmail().equals(details.getEmail()) && user.getPassword().equals(details.getNewpassword()) && user.getAddress().equals(details.getAddress())) {
			responseDetails.setTransferStatus(true);
			responseDetails.setResponseMessage("Successfully Updated");
		}
		
		return responseDetails;
	}
	
	
	
}
