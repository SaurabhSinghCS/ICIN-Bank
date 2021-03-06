package com.simplilearn.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.details.IdDetails;
import com.simplilearn.workshop.details.UserNameDetails;
import com.simplilearn.workshop.model.PandingUser;
import com.simplilearn.workshop.model.Users;
import com.simplilearn.workshop.service.PandingUserService;
import com.simplilearn.workshop.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PandingUserService pandingUserService;
	
	@RequestMapping(value = "/allUsers" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.GET)
	public List<Users> allUsers(){
		System.out.println("reached");
		return userService.findAll();
	}
	
	
	@RequestMapping(value = "/unblock" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public List<Users> unBlock(@RequestBody IdDetails details){
		System.out.println("not reached "+details.getId());
		userService.unBlockUser(details.getId());
		return userService.findAll();
	}
	
	
	@RequestMapping(value = "/block" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public List<Users> block(@RequestBody IdDetails details){
		System.out.println("not reached "+details.getId());
		userService.blockUser(details.getId());
		return userService.findAll();
	}
	
	
	@RequestMapping(value = "/getAllPandingUsers" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.GET)
	public List<PandingUser> getAllPandingUsers(){
		
		return pandingUserService.findAll();
	}
	
	@RequestMapping(value = "/confirmUser" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public Users confirmUser(@RequestBody UserNameDetails details){
		
		PandingUser userPanding = pandingUserService.findByUserName(details.getUsername());
		userService.inserUsers(userService.findAll().size()+1, userPanding.getFirstname(), userPanding.getLastname(), userPanding.getUsername(), 
				userPanding.getDob(), userPanding.getAddress(), userPanding.getEmail(), userPanding.getPassword(),
				userPanding.getKyctype(), userPanding.getKycid());
		
		if(userService.findByUsername(details.getUsername()) != null) {
			pandingUserService.deleteByUsername(details.getUsername());
			if(pandingUserService.findByUserName(details.getUsername()) == null) {
				return userService.findByUsername(details.getUsername());
			}else {
				return null;
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/declineUser" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public PandingUser declineUser(@RequestBody UserNameDetails details){
		
		pandingUserService.deleteByUsername(details.getUsername());
		
		return pandingUserService.findByUserName(details.getUsername());
		
	}
	
	
	
	
}
