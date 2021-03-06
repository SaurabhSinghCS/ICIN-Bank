package com.simplilearn.workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.workshop.model.Users;
import com.simplilearn.workshop.repository.UserRepository;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	@Transactional
	public Users isValid(String username, String password) {
		
		Users user = userRepository.findByUsername(username);
		
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
	
	@Override
	@Transactional
	public Users findByUsername(String user_Name) {
		return userRepository.findByUsername(user_Name);
	}
	
	
	@Override
	@Transactional
	public void transferRequest(String username) {
		
		userRepository.transferRequest(username);
		
	}
	
	@Override
	@Transactional
	public void selfTransfer(String username, Double samount, Double pamount) {
		
		userRepository.selfTransfer(username, samount, pamount);
		
	}
	
	@Override
	@Transactional
	public Users findByAccno(Long accno) {
		
		return userRepository.findByAccno(accno);
		
	}
	
	@Override
	@Transactional
	public void anotherTransferReciever(Long accno, Double samount) {
		
		userRepository.anotherTransferReciever(accno, samount);
		
	}
	
	@Override
	@Transactional
	public void anotherTransferSender(Long accno, Double samount) {
		
		userRepository.anotherTransferSender(accno, samount);
		
	}
	
	@Override
	@Transactional
	public void updateUser(String username, String email, String address, String password) {
		
		userRepository.updateUser(username, email, address, password);
		
	}

}
