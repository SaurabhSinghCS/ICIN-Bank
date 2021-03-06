package com.simplilearn.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.workshop.model.PandingUser;
import com.simplilearn.workshop.repository.PandingUserRepository;


@Service(value = "pandingUserService")
public class PandingUserServiceImpl implements PandingUserService {


	@Autowired
	private PandingUserRepository pandingUserRepository;

	@Override
	@Transactional
	public PandingUser findByUserName(String username) {

		return pandingUserRepository.findByUsername(username);
	}
	
	
	
	@Override
	@Transactional
	public List<PandingUser> findAll() {
		
		return pandingUserRepository.findAll();
	}
	 
	@Override
	@Transactional
	public void deleteByUsername(String username) {
		
		pandingUserRepository.deleteByUsername(username);
		
	}
	

}
