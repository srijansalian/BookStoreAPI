package com.bridgelabz.bookstore.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstore.dto.BookDto;

import com.bridgelabz.bookstore.dto.UserDto;
import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.entity.UserInformation;
import com.bridgelabz.bookstore.response.BookResponse;
import com.bridgelabz.bookstore.service.IBookService;


@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookStoreController {

	@Autowired
	IBookService bookservice;

	@PostMapping("/addbooks")
	public ResponseEntity<BookResponse> addBook(@RequestBody BookDto information) {
		bookservice.addBooks(information);

		return ResponseEntity.status(HttpStatus.CREATED).body(new BookResponse("The Book details are", information));
	}

	@GetMapping("/getbooks")
	public ResponseEntity<BookResponse> getBooks() {
		List<BookInformation> books = bookservice.getBookInfo();

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new BookResponse("The Book details are", books));

	}
	@GetMapping("/searchbytitle")
	public ResponseEntity<BookResponse> searchTitle(@RequestParam("title")String title) {
		BookInformation book= bookservice.searchByTitle(title);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new BookResponse("The book deatails ",book));
	}
	
	@GetMapping("/searchbyauthor")
	public ResponseEntity<BookResponse> searchAuthor(@RequestParam("authorName")String authorName) {
		List<BookInformation> book= bookservice.searchByAuthor(authorName);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new BookResponse("The book deatails ",book));
	}
	
	@PostMapping("/register")
	public ResponseEntity<BookResponse> addAddress(@RequestBody UserDto information) {
		bookservice.registeration(information);
		

		return ResponseEntity.status(HttpStatus.CREATED).body(new BookResponse("The  details added", information));
	}
	@GetMapping("/orderpage")
	public ResponseEntity<BookResponse> getOrdersPage(@RequestParam("userId")Long userId) {
		UserInformation orderdetails = bookservice.getOrdersPage(userId);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new BookResponse("The OrderDetails page", orderdetails));

	}
	
	
	@GetMapping("/confirmorder")
	public ResponseEntity<BookResponse> getConfirmOrder(@RequestParam("userId")Long userId) {
		UserInformation mail = bookservice.sendConfirOrder(userId);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new BookResponse("The Orderconfirm page", mail));

	}
}

