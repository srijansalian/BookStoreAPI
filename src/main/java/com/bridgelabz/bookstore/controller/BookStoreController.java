package com.bridgelabz.bookstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.bridgelabz.bookstore.dto.CustomerDto;
import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.entity.CustomerInformation;
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
	@GetMapping("/sort")
	public ResponseEntity<BookResponse> sort(){
		List<BookInformation> list=bookservice.sortGetAllBooks();
		return ResponseEntity.status(HttpStatus.OK).body(new BookResponse("all books",list));
	}
	@PostMapping("/addtocart")
	public ResponseEntity<BookResponse> addlabel(@RequestParam("userId") Long userId, @RequestHeader("quantity") int quantity,
			@RequestParam("bookId") Long bookId) {
		bookservice.addtocart(userId, quantity, bookId);

		return ResponseEntity.status(HttpStatus.OK).body(new BookResponse("Book is added to cart ", quantity));

	}

	@GetMapping( value = "/getallbookspagewise/{pagenumber}")
	public ResponseEntity<BookResponse> getBookPagewise( @PathVariable( value = "pagenumber") int pagenumber) {
		List<BookInformation> pageList = bookservice.findAllPageBySize( pagenumber);
		if( pageList != null) 
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new BookResponse("Successfull", pageList));

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BookResponse(400, "Failed"));
	}
	
//   @PostMapping( value = "/registration")
//   public ResponseEntity<BookResponse> customerRegistration( @RequestBody CustomerDto dto) {
//	  String is_registered = bookservice.customerRegistration(dto);
//	  if( is_registered != null)
//		  return ResponseEntity.status(HttpStatus.CREATED).body( new BookResponse("Successfully Registered..", is_registered));
//	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new BookResponse("Failed to Register..", is_registered));
//   }
//	  
//   @GetMapping( value = "/getCustomerDetails")
//   public ResponseEntity<BookResponse> getCustomerDetails( @RequestHeader( value = "token") String token) {
//	   CustomerInformation info = bookservice.getCustomerDetails(token);
//	   if( info != null)
//		   return ResponseEntity.status(HttpStatus.OK).body( new BookResponse(" CustomerInformation is :", info));
//	   return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new BookResponse(" CustomerInformation Not Found", 401)); 
//   }
//   
//   @GetMapping( value = "/searchbyNameandPhoneNumber/{name}/{phonenumber}")
//   public ResponseEntity<BookResponse> searchbyNameandPhoneNumber( @PathVariable( value = "name") String name,
//		                                                           @PathVariable( value = "phonenumber") long phonenumber) {
//	   String is_found = bookservice.getCustomerTokenbyNameandPhonenumber(name, phonenumber);
//		  if( is_found != null)
//			  return ResponseEntity.status(HttpStatus.OK).body( new BookResponse("Customer Details Found..", is_found));
//		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new BookResponse("Not Found..", is_found));
//   }
//
//   @PostMapping( value = "/addQuantity/{bookId}/{quantity}")
//   public ResponseEntity<BookResponse> addQuantity( @PathVariable( value = "bookId") long bookId,
//		                                            @PathVariable( value = "quantity") int quantity ) {
//	   boolean is_added = bookservice.addQuantity(bookId, quantity);
//	   if(is_added == true)
//		   return ResponseEntity.status(HttpStatus.CREATED).body( new BookResponse("Successfully Added Quantity..", is_added));
//		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new BookResponse("Failed to Add Quantity..", is_added));
//   }
  
@GetMapping( value = "/setToCartAndGetBookDetails/{bookId}")
public ResponseEntity<BookResponse> getBookDetails( @PathVariable( value = "bookId") long bookId) {
	BookInformation bookinfo = bookservice.getBookfromCart(bookId);
	if( bookinfo != null)
		 return ResponseEntity.status(HttpStatus.OK).body( new BookResponse("Book Details Found..", bookinfo));
	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new BookResponse("Book Details are Not Found..", bookinfo));
}
   
@DeleteMapping( value = "/deleteBookfromCart/{bookId}")
public ResponseEntity<BookResponse> deletefromCart( @PathVariable( value = "bookId") long bookId) {
	boolean is_deleted = bookservice.deletefromCart(bookId);
	if( is_deleted == true)
		return ResponseEntity.status(HttpStatus.OK).body( new BookResponse("Cart Detail Deleted Successfully..", is_deleted));
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new BookResponse("Failed to Delete Cart..", is_deleted));
}

@PostMapping( value = "/getTotalPriceofBookwithDetails/{bookId}/{quantity}")
public ResponseEntity<BookResponse> getTotalPriceofBookwithDetails( @PathVariable( value = "bookId") long bookId, 
		                                                            @PathVariable( value = "quantity") int quantity) {
	BookInformation info = bookservice.getTotalPriceofBook(bookId, quantity);
	if(info != null) 
		return ResponseEntity.status(HttpStatus.OK).body( new BookResponse("Book Detail are :", info));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new BookResponse("Failed..", info));
}

@PostMapping( value = "/addCustomerDetails/{type}")
public ResponseEntity<BookResponse> addCustomerDetails( @RequestBody CustomerDto dto,
		                                                @PathVariable( value = "type") String type) {
	boolean is_created = bookservice.addCustomerDetails(dto, type);
	if( is_created == true)
		return ResponseEntity.status(HttpStatus.CREATED).body( new BookResponse("Created is:", is_created));
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new BookResponse("Failed to Create :", is_created));
}

}
