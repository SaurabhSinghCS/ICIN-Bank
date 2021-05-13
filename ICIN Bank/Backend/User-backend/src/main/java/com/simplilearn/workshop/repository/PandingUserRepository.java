package com.simplilearn.workshop.repository;

import java.util.Date;

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
	
	@Modifying
	@Query(value = 
		    "insert into PandingUsers (first_name, last_name, user_name, dob, address, email, password, kyc_id, kyc_type)"
		    + " values (?1,?2,?3,?4,?5,?6,?7,?9,?8)",
		    nativeQuery = true)
	public void insertPandingUser(String firstname,String lastname,String username,Date dob
			,String address,String email,String password,String kyctype,String kycid);
}
