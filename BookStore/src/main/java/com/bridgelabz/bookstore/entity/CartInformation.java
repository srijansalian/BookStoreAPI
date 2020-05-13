package com.bridgelabz.bookstore.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cartinfo")
public class CartInformation  {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private long cartId;
private Long userId;
private int quantity;
@OneToMany
private List<BookInformation> book;

private long bookId;

public long getCartId() {
	return cartId;
}

public void setCartId(long cartId) {
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

public void setQuantity(int quantity) 
{
	this.quantity = quantity;
}

public List<BookInformation> getBook()
{
	return book;
}

public void setBook(List<BookInformation> book) 
{
	this.book = book;
}

public long getBookId() {
	return bookId;
}

public void setBookId(long bookId)
{
	this.bookId = bookId;
}
	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "Cart_Quantity", joinColumns = { @JoinColumn(name =
	 * "cartId")},inverseJoinColumns ={@JoinColumn(name = "quantity_id") }) private
	 * List<QuantityEntity> quantitylist;
	 */





}