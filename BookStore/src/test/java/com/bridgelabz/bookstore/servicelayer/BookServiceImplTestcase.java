package com.bridgelabz.bookstore.servicelayer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.implementation.BookServiceImplementation;
import com.bridgelabz.bookstore.repository.BookImple;
import com.bridgelabz.bookstore.service.IBookService;


@SpringBootTest
class BookServiceImplTestcase {
//	 @InjectMocks
//	 BookServiceImplementation bookservice;
	 
//	 @Mock
//	 BookImple dao;
	
	@Autowired
	BookServiceImplementation bookseriveimplementation;
	 
	@MockBean
	BookImple bookimple;

	@Test
	void testAddBooks() {
	//	BookDto book = new BookDto("India",100,20.0,"srijan","Indroduction");
//		bookservice.addBooks(book);
//		 ((IBookService) verify(dao, times(1))).addBooks(book);
		
//		
	}

	@Test
	void testGetBookInfo() {
//		when(bookimple.findAll()).thenReturn(Stream.of(new BookInformation("hello",10,10.0,"qwer","hi")).collect(Collectors.toList()));
//		assertEquals(1,bookseriveimplementation.getBookInfo().size());
	}

}
