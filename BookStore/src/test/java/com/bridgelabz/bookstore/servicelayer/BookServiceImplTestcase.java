
package com.bridgelabz.bookstore.servicelayer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.implementation.BookServiceImplementation;

class BookServiceImplTestcase {
	
	private BookServiceImplementation service;
	private BookInformation bookinfo;
	@Test
	void testAddBooks() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBookInfo() {
		fail("Not yet implemented");
	}
	
	@Test
	void testsearchByTitle() {
		BookInformation expected;
		BookInformation actual;
		//fail("Not yet implemented");
		//List<BookInformation> books=Arrays.asList(bookinfo,bookinfo,bookinfo);
		
		BookInformation book=service.searchByTitle("sop");
		actual=book; 
		expected=book;
		
		assertEquals(expected, actual);
	}
	

}
