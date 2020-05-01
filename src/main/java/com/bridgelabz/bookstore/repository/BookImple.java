package com.bridgelabz.bookstore.repository;

import org.springframework.stereotype.Repository;


import com.bridgelabz.bookstore.entity.BookInformation;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

@Repository
public interface BookImple extends JpaRepository<BookInformation, Long> {
	
	@Query( value = "select * from bookinfo", nativeQuery = true)
    List<BookInformation> findAllPage(Pageable pageable);
	
	@Query("from BookInformation where book_id=:id ")
	BookInformation fetchbyId(long id);
	
	@Transactional
	@Modifying
	@Query( value = "update bookinfo set quantity = :quantity where book_id = :bookId", nativeQuery = true)
	void addQuantity( long bookId, int quantity);
	
}
