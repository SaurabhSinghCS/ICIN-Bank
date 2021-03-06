package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>,CrudRepository<Users, Integer> {
	
	public Users findByUsername(String user_Name);
	
	public Users findByAccno(long accno);
	
	@Modifying
	@Query("UPDATE Users u SET u.transfer_access=1 WHERE u.username=?1")
	public void transferRequest(String username);
	
	@Modifying
	@Query("UPDATE Users u SET u.samount=?2,u.pamount=?3 WHERE u.username=?1")
	public void selfTransfer(String username, Double samount, Double pamount);
	
	@Modifying
	@Query("UPDATE Users u SET u.samount=?2 WHERE u.accno=?1")
	public void anotherTransferReciever(Long accno, Double samount);
	
	@Modifying
	@Query("UPDATE Users u SET u.pamount=?2 WHERE u.accno=?1")
	public void anotherTransferSender(Long accno, Double samount);
	
	@Modifying
	@Query("UPDATE Users u SET u.email=?2,u.address=?3,u.password=?3 WHERE u.username=?1")
	public void updateUser(String username, String email, String address, String password);
	

}
