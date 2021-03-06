package com.simplilearn.workshop.service;

import java.util.List;

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
	public List<Users> findAll() {
		
		return userRepository.findAll();
	}
	
	@Override
	@Transactional
	public void unBlockUser(int id) {
//		System.out.println(id);
		userRepository.unBlockUser(id);
		
	}
	
	@Override
	@Transactional
	public void blockUser(int id) {
//		System.out.println(id);
		userRepository.blockUser(id);
		
	}
	
	@Override
	@Transactional
	public void inserUsers(int id,String firstname, String lastname, String username, String dob, String address, String email,
			String password, String kyctype, String kycid) {
		
		userRepository.inserUsers(id,firstname, lastname, username, dob, address, email, password, kyctype, kycid);
		
	}
	
	@Override
	@Transactional
	public Users findByUsername(String user_Name) {
		
		return userRepository.findByUsername(user_Name);
	}
	
	@Override
	@Transactional
	public void giveTransferAccess(String username) {
		
		userRepository.giveTransferAccess(username);
		
	}

}
