package com.bridgelabz.bookstore.service;
import java.util.List;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.entity.BookInformation;


public interface IBookService {
	//public ResponseEntity<BookResponse> addBooks(BookDto information);
	boolean addBooks(BookDto information);
	List<BookInformation> getBookInfo();
	
	boolean addtocart(Long userId, int quantity , Long bookId);
	
	void removefromcart(Long userId, Long bookId);

}



