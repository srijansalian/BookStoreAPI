package com.bridgelabz.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstore.dto.CustomerDto;
import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.entity.CustomerInformation;
import com.bridgelabz.bookstore.response.BookResponse;
import com.bridgelabz.bookstore.service.Customerservice;

@RestController
@CrossOrigin( origins = "*", allowedHeaders = "*")
@RequestMapping("/")
public class CustomerController {

	@Autowired
	Customerservice service;
	
	@GetMapping( value = "addtocart/{bookId}/{userId}")
	public ResponseEntity<BookResponse> getBookDetails( @PathVariable( value = "bookId") long bookId,
			                                            @PathVariable( value = "userId") long userId) {
		BookInformation bookinfo = service.getBookfromCart(bookId, userId);
		if( bookinfo != null)
			 return ResponseEntity.status(HttpStatus.OK).body( new BookResponse("Book Details Found..", bookinfo));
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new BookResponse("Book Details are Not Found..", bookinfo));
	}
	   
	@DeleteMapping( value = "deletecart/{bookId}/{cartId}")
	public ResponseEntity<BookResponse> deletefromCart( @PathVariable( value = "bookId") long bookId,
			                                            @PathVariable( value = "cartId") long cartId) {
		boolean is_deleted = service.deletefromCart(bookId, cartId);
		if( is_deleted == true)
			return ResponseEntity.status(HttpStatus.OK).body( new BookResponse("Cart Detail Deleted Successfully..", is_deleted));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new BookResponse("Failed to Delete Cart..", is_deleted));
	}

	@PostMapping( value = "getbookprice/{bookId}/{quantity}")
	public ResponseEntity<BookResponse> getTotalPriceofBookwithDetails( @PathVariable( value = "bookId") long bookId, 
			                                                            @PathVariable( value = "quantity") int quantity) {
		BookInformation info = service.getTotalPriceofBook(bookId, quantity);
		if(info != null) 
			return ResponseEntity.status(HttpStatus.OK).body( new BookResponse("Book Detail are :", info));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new BookResponse("Failed..", info));
	}

	@PostMapping( value = "addcustomer")
	public ResponseEntity<BookResponse> addCustomerDetails( @RequestBody CustomerDto dto) {
		CustomerInformation is_created = service.addCustomerDetails(dto);
		if( is_created != null)
			return ResponseEntity.status(HttpStatus.CREATED).body( new BookResponse("Added Customer Details is:", is_created));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new BookResponse("Failed to Create :", is_created));
	}

	
}