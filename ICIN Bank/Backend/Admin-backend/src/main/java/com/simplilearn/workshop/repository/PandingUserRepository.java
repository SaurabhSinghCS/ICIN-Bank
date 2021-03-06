package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.PandingUser;

@Repository
public interface PandingUserRepository extends JpaRepository<PandingUser, Integer>, CrudRepository<PandingUser, Integer> {

	public PandingUser findByUsername(String username);
	
	public PandingUser findByKycid(String kycid);
	
	public List<PandingUser> findAll();
	
	@Modifying
	@Query(value = 
		    "insert into pandingusers (first_name, last_name, user_name, dob, address, email, password, kyc_id, kyc_type)"
		    + " values (?1,?2,?3,?4,?5,?6,?7,?8,?9)",
		    nativeQuery = true)
	public void insertPandingUser(String firstname,String lastname,String username,String dob
			,String address,String email,String password,String kyctype,String kycid);
	
	
	public void deleteByUsername(String username);

	
	
}
