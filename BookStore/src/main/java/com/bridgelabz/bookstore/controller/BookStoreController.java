package com.bridgelabz.bookstore.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.entity.BookInformation;
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

	@PostMapping("/addandupdatecart")
	public ResponseEntity<BookResponse> addtocart(@RequestParam("userId") Long userId,
			@RequestHeader("quantity") int quantity, @RequestParam("bookId") Long bookId) {
		boolean value = bookservice.addandupdatecart(userId, quantity, bookId);
		if (value) {
			return ResponseEntity.status(HttpStatus.OK).body(new BookResponse("Book is added to cart ", quantity));
		} else
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new BookResponse("Out of Stock", quantity));

	}

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
	@GetMapping( value = "/getallbookspagewise/{pagenumber}")
	public ResponseEntity<BookResponse> getBookPagewise( @PathVariable( value = "pagenumber") int pagenumber) {
		List<BookInformation> pageList = bookservice.findAllPageBySize( pagenumber);
		if( pageList != null) 
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new BookResponse("Successfull", pageList));

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BookResponse(400, "Failed"));
	}
	
	@GetMapping( value = "/getbookbyId/{bookId}")
 public ResponseEntity<BookResponse> getBookbyId( @PathVariable("bookId") long bookId) {
		BookInformation info = bookservice.getBookbyId(bookId);
		if(info != null)
			return ResponseEntity.status(HttpStatus.OK).body(new BookResponse("all books",info));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BookResponse("all books",info));
	}
	
}
