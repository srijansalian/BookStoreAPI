package com.bridgelabz.bookstore.servicelayer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.implementation.BookServiceImplementation;
import com.bridgelabz.bookstore.repository.BookImple;
import com.bridgelabz.bookstore.service.IBookService;


class BookServiceImplTestcase {
	 @InjectMocks
	 BookServiceImplementation bookservice;
	 
	 @Mock
	 BookImple dao;

	@Test
	void testAddBooks() {
	//	BookDto book = new BookDto("India",100,20.0,"srijan","Indroduction");
//		bookservice.addBooks(book);
//		 ((IBookService) verify(dao, times(1))).addBooks(book);
//		
	}

	@Test
	void testGetBookInfo() {
//		List<BookDto> list = new ArrayList<BookDto>();
//		BookDto book1 = new BookDto("India",100,20.0,"srijan","Indroduction");
//		BookDto book2 = new BookDto("USA",1000,10.0,"Brijesh","Hello");
//		list.add(book1);
//		list.add(book2);
		
		//when(dao).thenReturn(list);
		
		
	
	}

}
