package com.bridgelabz.bookstore.servicelayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
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


import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class BookServiceImplTestcase {
	 @InjectMocks
	 BookServiceImplementation bookservice;
	 
	 @Mock
	 BookImple dao;

	@InjectMocks
	BookImple reposi;
	

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getallbooklist() {
//		List<BookDto> list=new ArrayList<>();
//		BookDto b1=new BookDto("goal",100,10.0,"srijan","work is worship");
//		BookDto b2=new BookDto("fail",100,30.0,"prade"," worship");
//		BookDto b3=new BookDto("sol",100,130.0,"mag","rip");
//		BookDto b4=new BookDto("aquire",100,20.0,"ewq","working");
//		list.add(b4);
//		list.add(b3);
//		list.add(b2);
//		list.add(b1);
		
	}
		 
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
