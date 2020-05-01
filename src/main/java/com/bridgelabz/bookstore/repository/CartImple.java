package com.bridgelabz.bookstore.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.entity.CartInformation;

public interface CartImple extends JpaRepository<CartInformation, Long> {

//	@Transactional
//	@Modifying
//	@Query( value = "update cartinfo set quantity = :number where book_id = :bookId", nativeQuery = true)
//	void updateBookQuantity( long number, long bookId);
	
	@Query(value = "select * from cartinfo where cart_id=:id ", nativeQuery = true)
	CartInformation fetchbyId(long id);
	
	@Query(value = "select * from cartinfo where book_id=:id ", nativeQuery = true)
	CartInformation findCartbyId(long id);
	
//	@Query( value = "delete from cartinfo where book_id = :bookId", nativeQuery = true)
//	void 
}
