package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	public List<Users> findAll();
	
	@Modifying
	@Query("UPDATE Users u SET u.is_blocked=0 WHERE u.id=?1")
	public void unBlockUser(int id);
	
	
	@Modifying
	@Query("UPDATE Users u SET u.is_blocked=1 WHERE u.id=?1")
	public void blockUser(int id);
	
	@Modifying
	@Query(value = 
		    "insert into Users (id,first_name, last_name, user_name, dob, address, email, password, kyc_id, kyc_type)"
		    + " values (?1,?2,?3,?4,?5,?6,?7,?8,?10,?9)",
		    nativeQuery = true)
	public void inserUsers(int id,String firstname,String lastname,String username,String dob
			,String address,String email,String password,String kyctype,String kycid);
	
	public Users findByUsername(String user_Name);
	
	@Modifying
	@Query("UPDATE Users u SET u.transfer_access=1 WHERE u.username=?1")
	public void giveTransferAccess(String username);
	
}
