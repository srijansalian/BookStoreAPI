package com.bridgelabz.bookstore.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.response.BookResponse;
import com.bridgelabz.bookstore.service.IBookService;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookStoreController {
	
	@Autowired
	IBookService bookservice;
	
	
	@PostMapping("/add")
	public ResponseEntity<BookResponse> addBook(@RequestBody BookDto information){
		bookservice.addBooks(information);
		return null;
	}
	
	

}
