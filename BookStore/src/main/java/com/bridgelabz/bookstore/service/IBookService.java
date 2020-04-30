package com.bridgelabz.bookstore.service;

import java.util.List;

import com.bridgelabz.bookstore.dto.BookDto;

import com.bridgelabz.bookstore.dto.UserDto;
import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.entity.UserInformation;

public interface IBookService {
	// public ResponseEntity<BookResponse> addBooks(BookDto information);
	boolean addBooks(BookDto information);

	List<BookInformation> getBookInfo();
	void removefromcart(Long userId, Long bookId);

	List<BookInformation> sortGetAllBooks();
	
//	boolean addandupdatecart(Long userId, int quantity, Long bookId);


	List<BookInformation> sorting(boolean value);

	//String setPurchasingQuantity(Long userId, int quantity, Long bookId);

}

