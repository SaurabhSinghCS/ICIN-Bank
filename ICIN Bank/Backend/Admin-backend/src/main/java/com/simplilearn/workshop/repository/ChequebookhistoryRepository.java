package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Chequebookhistory;

@Repository
public interface ChequebookhistoryRepository extends JpaRepository<Chequebookhistory, Integer> {

	public List<Chequebookhistory> findAllByUsername(String username);
	
	@Modifying
	@Query(value = 
		    "insert into chequebookhistory (username, pages, date, given)"
		    + " values (?1,?2,?3,?4)",
		    nativeQuery = true)
	public void insertChequebookhistory(String username, int pages, String date, Boolean given);
	
	public Chequebookhistory findByUsernameAndPagesAndDate(String username, int pages, String date);
}
