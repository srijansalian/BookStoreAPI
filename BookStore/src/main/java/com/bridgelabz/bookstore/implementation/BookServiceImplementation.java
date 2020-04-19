package com.bridgelabz.bookstore.implementation;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.dto.Purchasedto;
import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.entity.PurchaseInformation;
import com.bridgelabz.bookstore.repository.BookImple;
import com.bridgelabz.bookstore.repository.PurchaseImple;
import com.bridgelabz.bookstore.service.IBookService;


import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class BookServiceImplementation implements IBookService {
	private BookInformation bookinformation = new BookInformation();
	private ModelMapper modelMapper = new ModelMapper();
	private PurchaseInformation purchaseinformation=new PurchaseInformation();
//	@Autowired
//	private ModelMapper modelMapper;
//	@Autowired
//	private IBook repo;

	@Autowired
	private BookImple repository;
	@Autowired
	private PurchaseImple purchaserepository;
	@Transactional
	@Override
	public boolean addBooks(BookDto information) {
		bookinformation = modelMapper.map(information, BookInformation.class);
		bookinformation.setBookName(information.getBookName());
		bookinformation.setAuthorName(information.getAuthorName());
		bookinformation.setPrice(information.getPrice());
		bookinformation.setQuantity(information.getQuantity());
		bookinformation.setCreatedDateAndTime(LocalDateTime.now());
		repository.save(bookinformation);
		return true;
	}

	@Transactional
	@Override
	public List<BookInformation> getBookInfo() {
		List<BookInformation> users = repository.findAll();

		return users;
	}

	@Transactional
	@Override
	public BookInformation searchByTitle(String title) {
		BookInformation title1=repository.searchTitle(title);
		return title1;
	}


	@Transactional
	@Override
	public List<BookInformation> searchByAuthor(String authorname) {
		List<BookInformation> authorname1=repository.searchAuthor(authorname);
		return authorname1;
	}
	
	
	@Transactional
	@Override
	public boolean addAddress(Purchasedto information) {
		purchaseinformation = modelMapper.map(information, PurchaseInformation.class);
	//	bookinformation.setBookName(information.getBookName());
		purchaseinformation.setAddress(information.getAddress());
		purchaseinformation.setBookId(information.getBookId());
		//purchaseinformation.setBookId(bookinformation.getBookId());
		purchaserepository.save(purchaseinformation);
		return true;
	
	}

}
