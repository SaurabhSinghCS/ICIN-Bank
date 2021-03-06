package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer> {

	
	public List<Transfer> findByRaccountOrSaccount(Long accno, Long accNo);
	
	@Modifying
	@Query(value = 
		    "insert into transfer (saccount, raccount, amount, date)"
		    + " values (?1,?2,?3,?4)",
		    nativeQuery = true)
	public void insertTransfer(long saccount,long raccount,Double amount, String date);
}
