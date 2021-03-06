package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.TransferRequest;

@Repository
public interface TransferRequestRepository extends JpaRepository<TransferRequest, Integer> {

	public List<TransferRequest> findAll();
	
	@Modifying
	@Query("DELETE FROM TransferRequest u WHERE u.username=?1")
	public void deleteTransferRequest(String username);
	
	public TransferRequest findByUsername(String username);
}
