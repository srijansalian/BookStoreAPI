package com.bridgelabz.bookstore.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "bookinfo")
public class BookInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;

	private String bookName;

	private int quantity;

	private Double price;

	private String authorName;

	private String bookDetails;
	private LocalDateTime createdDateAndTime;
	private String image;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CartInformation", joinColumns = { @JoinColumn(name = "bookId") }, inverseJoinColumns = {

			@JoinColumn(name = "userId") })
	@JsonBackReference
	private List<CartInformation> list;

}