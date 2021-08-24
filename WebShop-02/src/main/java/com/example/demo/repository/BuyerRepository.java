 package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
//	@Query("SELECT b FROM  Buyer b WHERE b.email = ?1")
//	public Buyer findByEmail(String email);
	
	 @Query("SELECT b FROM  Buyer b WHERE b.email = :email")
	public Buyer findByEmail(@Param("email") String email);
}
