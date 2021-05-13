package com.simplilearn.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.workshop.model.UserHistory;
import com.simplilearn.workshop.repository.UserHistoryRepository;

@Service(value = "userHistoryService")
public class UserHistoryServiceImpl implements UserHistoryService {

	@Autowired
	private UserHistoryRepository userHistoryRepository;
	
	@Override
	@Transactional
	public List<UserHistory> findAllByUsername(String username) {
		
		return userHistoryRepository.findAllByUsername(username);
	}

}
