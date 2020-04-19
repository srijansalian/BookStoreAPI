package com.bridgelabz.bookstore.dto;

import org.springframework.stereotype.Component;

@Component
public class Purchasedto {
	private String address;
	private int bookId;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
