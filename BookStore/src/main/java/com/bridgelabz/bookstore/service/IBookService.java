package com.bridgelabz.bookstore.service;
import com.bridgelabz.bookstore.dto.BookDto;


public interface IBookService {
	//public ResponseEntity<BookResponse> addBooks(BookDto information);
	boolean addBooks(BookDto information);

}



