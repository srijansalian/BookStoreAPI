package com.bridgelabz.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.bookstore.entity.CartInformation;

public interface CartImple extends JpaRepository<CartInformation, Long> {
	
	

}
