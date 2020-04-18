package com.bridgelabz.bookstore.repository;

import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstore.entity.BookInformation;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface BookImple extends JpaRepository<BookInformation, Long> {
	
	@Query("from BookInformation where book_id=:id ")
	BookInformation fetchbyId(Long id);
	
	
	



}
