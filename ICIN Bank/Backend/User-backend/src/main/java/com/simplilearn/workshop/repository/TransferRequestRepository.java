package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.TransferRequest;

@Repository
public interface TransferRequestRepository extends JpaRepository<TransferRequest, Integer> {

	@Modifying
	@Query(value = 
		    "insert into transferrequest (username, accno)"
		    + " values (?1,?2)",
		    nativeQuery = true)
	public void insertRequest(String username,Long accno);
	
	
	public TransferRequest findByUsername(String username);
	
}
