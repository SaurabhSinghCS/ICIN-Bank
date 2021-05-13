package com.simplilearn.workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.workshop.model.Admin;
import com.simplilearn.workshop.repository.AdminRepository;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	@Transactional
	public Admin isValid(String username, String password) {
		
		Admin admin = adminRepository.findByUsername(username);
		
		if(admin != null && admin.getPassword().equals(password)) {
			return admin;
		}
		return null;
	}

}
