package com.bridgelabz.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cartinfo")
public class CartInformation  {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private int cartId;
private Long userId;
private int quantity;
private Long bookId;
private boolean isOutOfStock;

public boolean isOutOfStock() {
	return isOutOfStock;
}

public void setOutOfStock(boolean isOutOfStock) {
	this.isOutOfStock = isOutOfStock;
}

public int getCartId() {
	return cartId;
}

public void setCartId(int cartId) {
	this.cartId = cartId;
}


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