package com.bridgelabz.bookstore.dto;

import org.springframework.stereotype.Component;

@Component
public class BookDto {
	private String bookName;

	private int quantity;

	private Double price;
	private String authorName;
	private String bookDetails;

	

	public BookDto() {
		super();
	}

	public BookDto(String bookName, int quantity, Double price, String authorName, String bookDetails) {
		this.bookName = bookName;
		this.quantity = quantity;
		this.price = price;
		this.authorName = authorName;
		this.bookDetails = bookDetails;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(String bookDetails) {
		this.bookDetails = bookDetails;
	}

//	public BookDto(String bookName, int quantity, Double price, String authorName, String bookDetails) {
//		super();
//		this.bookName = bookName;
//		this.quantity = quantity;
//		this.price = price;
//		this.authorName = authorName;
//		this.bookDetails = bookDetails;
//	}

}