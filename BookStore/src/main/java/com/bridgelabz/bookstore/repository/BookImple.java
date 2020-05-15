package com.bridgelabz.bookstore.repository;

import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstore.entity.BookInformation;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface BookImple extends JpaRepository<BookInformation, Long> {
	
	@Query("from BookInformation where book_id=:id ")
	BookInformation fetchbyId(Long id);
	
	@Query( value = "select * from bookinfo", nativeQuery = true)
    List<BookInformation> findAllPage(Pageable pageable);
	
	@Query( value = "select * from bookinfo", nativeQuery = true)
    List<BookInformation> getAllBooks();

	@Query("from BookInformation where book_id=:id ")
	List<BookInformation> fetchbyIdList(Long id);
}