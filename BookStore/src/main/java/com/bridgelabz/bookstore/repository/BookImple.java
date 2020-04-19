package com.bridgelabz.bookstore.repository;

import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstore.entity.BookInformation;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface BookImple extends JpaRepository<BookInformation, Long> {

	@Query(value="select * from bookinfo where author_name=?",nativeQuery=true)
	List<BookInformation> searchAuthor(String author_name);

	@Query(value="select * from bookinfo where book_name=?",nativeQuery=true)
	BookInformation searchTitle(String book_name);
	
}
