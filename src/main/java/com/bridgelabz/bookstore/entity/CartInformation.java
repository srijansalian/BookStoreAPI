package com.bridgelabz.bookstore.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name = "cartinfo")
public class CartInformation  {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private int cartId;
public int getCartId() {
	return cartId;
}

public void setCartId(int cartId) {
	this.cartId = cartId;
}

private Long userId;
private int quantity;
private Long bookId;

public Long getUserId() {
	return userId;
}

public void setUserId(Long userId) {
	this.userId = userId;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public Long getBookId() {
	return bookId;
}

public void setBookId(Long bookId) {
	this.bookId = bookId;
}

}
