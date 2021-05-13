package com.simplilearn.workshop.service;


import com.simplilearn.workshop.details.PandingUserDetails;
import com.simplilearn.workshop.model.PandingUser;


public interface PandingUserService {
	
	public PandingUser findByUserName(String username);
	
	public void insertIntoPandingUser(PandingUserDetails entity);
	
	public PandingUser findByKycid(String kycid);

}
