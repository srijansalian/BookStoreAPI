package com.bridgelabz.bookstore.servicelayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.implementation.BookServiceImplementation;
import com.bridgelabz.bookstore.repository.BookImple;

@RunWith(MockitoJUnitRunner.class)
class BookServiceImplTestcase {

	@InjectMocks
	BookServiceImplementation bookservice;
	@InjectMocks
	BookImple reposi;
	@Mock
	BookInformation dao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getallbooklist() {
		List<BookDto> list=new ArrayList<>();
		BookDto b1=new BookDto("goal",100,10.0,"srijan","work is worship");
		BookDto b2=new BookDto("fail",100,30.0,"prade"," worship");
		BookDto b3=new BookDto("sol",100,130.0,"mag","rip");
		BookDto b4=new BookDto("aquire",100,20.0,"ewq","working");
		list.add(b4);
		list.add(b3);
		list.add(b2);
		list.add(b1);
		
		
		 
	}
}
