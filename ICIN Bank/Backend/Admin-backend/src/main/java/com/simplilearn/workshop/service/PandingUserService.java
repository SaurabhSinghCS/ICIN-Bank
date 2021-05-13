package com.simplilearn.workshop.service;


import java.util.List;

import com.simplilearn.workshop.model.PandingUser;


public interface PandingUserService {
	
	public PandingUser findByUserName(String username);
	
	public List<PandingUser> findAll();
	
	public void deleteByUsername(String username);


}
