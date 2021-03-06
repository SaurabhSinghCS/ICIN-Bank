package com.simplilearn.workshop.service;

import com.simplilearn.workshop.model.Users;

public interface UserService {
	
	public Users isValid(String username,String password);
	
	public Users findByUsername(String user_Name);
	
	public Users findByAccno(Long accno);
	
	public void transferRequest(String username);
	
	public void selfTransfer(String username, Double samount, Double pamount);
	
	public void anotherTransferReciever(Long accno, Double samount);
	
	public void anotherTransferSender(Long accno, Double samount);
	
	public void updateUser(String username, String email, String address, String password);

}
