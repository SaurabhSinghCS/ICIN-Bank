package com.simplilearn.workshop.service;

import com.simplilearn.workshop.model.Admin;

public interface AdminService {

	public Admin isValid(String username, String password);
}
