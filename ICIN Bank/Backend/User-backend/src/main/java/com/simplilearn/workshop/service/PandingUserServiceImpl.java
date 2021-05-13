package com.simplilearn.workshop.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.workshop.details.PandingUserDetails;
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
	public void insertIntoPandingUser(PandingUserDetails entity) {
		
		try {
			pandingUserRepository.insertPandingUser(entity.getFirstname(),entity.getLastname(),entity.getUsername(),new SimpleDateFormat("yyyy-MM-dd").parse(entity.getDob())
					,entity.getAddress(),entity.getEmail(),entity.getPassword(),entity.getKyctype(),entity.getKycid());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	@Transactional
	public PandingUser findByKycid(String kycid) {
		
		return pandingUserRepository.findByKycid(kycid);
	}
	
	 
	
	

}
