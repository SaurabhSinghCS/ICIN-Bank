package com.simplilearn.workshop.service;

import java.util.List;

import com.simplilearn.workshop.model.UserHistory;

public interface UserHistoryService {

	public List<UserHistory> findAllByUsername(String username);
	
}
