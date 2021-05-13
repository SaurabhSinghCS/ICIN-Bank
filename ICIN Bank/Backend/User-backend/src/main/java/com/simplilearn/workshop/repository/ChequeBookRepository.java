package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.ChequeBook;


@Repository
public interface ChequeBookRepository extends JpaRepository<ChequeBook, Integer>, CrudRepository<ChequeBook, Integer> {

	public ChequeBook findByUsername(String username);
	
	@Modifying
	@Query(value = 
		    "insert into ChequeBook (user_name, pages,date) values (?1,?2,?3)",
		    nativeQuery = true)
	public void insertChequeBook(String username,int pages,String date);
}
