package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.ChequeBook;


@Repository
public interface ChequeBookRepository extends JpaRepository<ChequeBook, Integer>, CrudRepository<ChequeBook, Integer> {

	public ChequeBook findByUsername(String username);
	
	public List<ChequeBook> findAll();
	
	
	@Modifying
	@Query(value = 
		    "insert into chequebook (user_name, pages) values (?1,?2)",
		    nativeQuery = true)
	public void insertChequeBook(String username,int pages);
	
	
	public void deleteByUsername(String username);
}
