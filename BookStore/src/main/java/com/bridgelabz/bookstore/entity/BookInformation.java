package com.bridgelabz.bookstore.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "bookinfo")
public class BookInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	@NotNull
	private String bookName;
	@Column
	@NotNull
	private int quantity;

	@Column
	@NotNull
	private Double price;
	@Column
	@NotNull
	private String authorName;
	@NotNull
	private String bookDetails;
	private LocalDateTime createdDateAndTime;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CartInformation", joinColumns = { @JoinColumn(name = "bookId") }, inverseJoinColumns = {

			@JoinColumn(name = "userId") })
	@JsonBackReference
	private List<CartInformation> list;

}
