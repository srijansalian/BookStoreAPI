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
public class CartInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;

	private Long userId;
	private int quantity;
	private Long bookId;

}