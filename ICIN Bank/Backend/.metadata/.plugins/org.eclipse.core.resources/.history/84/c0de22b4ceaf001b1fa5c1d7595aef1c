package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Chequebookhistory;

@Repository
public interface ChequebookhistoryRepository extends JpaRepository<Chequebookhistory, Integer> {

	public List<Chequebookhistory> findAllByUsername(String username);
}
