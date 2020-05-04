package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CustomerDto;
import com.bridgelabz.bookstore.entity.BookInformation;

public interface Customerservice {

    BookInformation getBookfromCart( long bookId, long userId);
	
	boolean deletefromCart( long bookId);
	
	BookInformation getTotalPriceofBook( long bookId, int quantity);
	
	boolean addCustomerDetails( CustomerDto dto, String variable);
	
}
