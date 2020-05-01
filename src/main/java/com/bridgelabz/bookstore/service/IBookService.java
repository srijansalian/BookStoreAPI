package com.bridgelabz.bookstore.service;

import java.util.List;
import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.dto.CustomerDto;
import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.entity.CustomerInformation;

public interface IBookService {
	// public ResponseEntity<BookResponse> addBooks(BookDto information);
	boolean addBooks(BookDto information);

	List<BookInformation> getBookInfo();

	List<BookInformation> sortGetAllBooks();
	
	void addtocart(Long userId, int quantity , Long bookId);

	List<BookInformation> findAllPageBySize( int pagenumber);
	
//	String customerRegistration( CustomerDto dto);
//	
//	CustomerInformation getCustomerDetails( String token);
//	
//	String getCustomerTokenbyNameandPhonenumber( String name, long phonenumber);
//	
//	boolean addQuantity( long bookId, int quantity);
	
	BookInformation getBookfromCart( long bookId);
	
	boolean deletefromCart( long bookId);
	
	BookInformation getTotalPriceofBook( long bookId, int quantity);
	
	boolean addCustomerDetails( CustomerDto dto, String variable);
}
