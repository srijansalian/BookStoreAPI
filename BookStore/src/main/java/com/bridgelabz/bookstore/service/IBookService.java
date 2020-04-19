package com.bridgelabz.bookstore.service;

import java.util.List;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.dto.Purchasedto;
import com.bridgelabz.bookstore.entity.BookInformation;

public interface IBookService {
	// public ResponseEntity<BookResponse> addBooks(BookDto information);
	boolean addBooks(BookDto information);

	List<BookInformation> getBookInfo();


	BookInformation searchByTitle(String title);

	List<BookInformation> searchByAuthor(String authorname);

	boolean addAddress(Purchasedto information);

}
