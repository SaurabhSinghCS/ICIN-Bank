package com.simplilearn.workshop.service;

import java.util.List;

import com.simplilearn.workshop.model.Users;

public interface UserService {
	
	public List<Users> findAll();
	
	public void unBlockUser(int id);
	
	public void blockUser(int id);
	
	public void inserUsers(int id,String firstname,String lastname,String username,String dob
			,String address,String email,String password,String kyctype,String kycid);
	
	public Users findByUsername(String user_Name);
	
	public void giveTransferAccess(String username);

}
