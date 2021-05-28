package com.simplilearn.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.details.LoginCredentialDetails;
import com.simplilearn.workshop.model.Admin;
import com.simplilearn.workshop.service.AdminService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/validateLogin" ,produces = { MediaType.APPLICATION_JSON_VALUE,"application/json" },method = RequestMethod.POST)
	public Admin isValidLogin(@RequestBody LoginCredentialDetails details) {
		System.out.println("reached  "+details.getPassword()+"  "+details.getUsername());
		Admin admin = adminService.isValid(details.getUsername(), details.getPassword());
		if(admin == null) {
			System.out.println("Null");
		}else {
			System.out.println(admin.getId());
		}
		return admin;
	}
}
