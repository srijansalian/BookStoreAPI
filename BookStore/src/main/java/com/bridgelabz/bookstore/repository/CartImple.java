package com.bridgelabz.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.bridgelabz.bookstore.entity.CartInformation;

public interface CartImple extends JpaRepository<CartInformation, Long> {
	
	@Modifying
	@Query("DELETE FROM CartInformation WHERE book_id=:id")
	void deletebyId(Long id);
	
	

}
