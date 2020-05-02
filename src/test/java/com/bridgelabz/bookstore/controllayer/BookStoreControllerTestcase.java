package com.bridgelabz.bookstore.controllayer;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.bridgelabz.bookstore.BookStoreApplication;
import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.implementation.BookServiceImplementation;

class BookStoreControllerTestcase  extends BookStoreApplication{
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	 @InjectMocks
	 BookServiceImplementation bookservice;
	 
	 @Mock
	 BookInformation dto;
	 
	 @Before
		public void setup() {
			mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		}
	@Test
	void testAddBook() {
		
		

		
	}

	@Test
	void testGetBooks() throws Exception{
		mockMvc.perform(get("/getbooks")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.bookName").value("India")).andExpect(jsonPath("$.authorName").value("srijan"))
		.andExpect(jsonPath("$.bookId").value("1")).andExpect(jsonPath("$.price").value(3000))
		.andExpect(jsonPath("$.quantity").value(20)).andExpect(jsonPath("$.bookDetails").value("Intro"));
		
	}
	@Test
	void addbookstocart() throws Exception{
		mockMvc.perform(get("/getbooks")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}

}
