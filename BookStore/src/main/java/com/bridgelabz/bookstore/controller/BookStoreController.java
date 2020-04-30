package com.bridgelabz.bookstore.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	@GetMapping("/SortNewestArrival")
	public ResponseEntity<BookResponse> sort(){
		List<BookInformation> list=bookservice.sortGetAllBooks();
		return ResponseEntity.status(HttpStatus.OK).body(new BookResponse("all books",list));
	}

//	@PostMapping("/addandupdatecart")
//	public ResponseEntity<BookResponse> addtocart(@RequestParam("userId") Long userId,
//			@RequestHeader("quantity") int quantity, @RequestParam("bookId") Long bookId) {
//		boolean value = bookservice.addandupdatecart(userId, quantity, bookId);
//		if (value) {
//			return ResponseEntity.status(HttpStatus.OK).body(new BookResponse("Book is added to cart ", quantity));
//		} else
//			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new BookResponse("Out of Stock", quantity));
//
//	}
//	@PutMapping("/addtocartupdated")
//	public ResponseEntity<BookResponse>setQuantity(@RequestParam("userId") Long userId, @RequestHeader("quantity") int quantity,
//			@RequestParam("bookId") Long bookId){
//		String orderNumber=bookservice.setPurchasingQuantity(userId, quantity, bookId);
//		if(!orderNumber.isEmpty()) {
//		return ResponseEntity.status(HttpStatus.OK).body(new BookResponse("Order processed Successfully!", orderNumber));
//	}
//		return ResponseEntity.status(HttpStatus.OK).body(new BookResponse("Oops... Error processing order!", orderNumber));
//	}
	@PutMapping("/removefromcart")
	public ResponseEntity<BookResponse> removelabel(@RequestParam("userId") Long userId, @RequestParam("bookId") Long bookId) {
		bookservice.removefromcart(userId,bookId);
		return ResponseEntity.status(HttpStatus.OK).body(new BookResponse("Book has been removed from the cart", bookId));
	}

	
	@GetMapping("/sorting")
	public ResponseEntity<BookResponse> sorting(@RequestParam("value") boolean value){
		List<BookInformation> list=bookservice.sorting( value);
		if (value==true) {
			return ResponseEntity.status(HttpStatus.OK).body(new BookResponse("all books",list));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new BookResponse("all books",list));
		}

	}
}

