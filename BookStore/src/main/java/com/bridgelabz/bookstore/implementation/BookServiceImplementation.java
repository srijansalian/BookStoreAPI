package com.bridgelabz.bookstore.implementation;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.entity.CartInformation;
import com.bridgelabz.bookstore.repository.BookImple;
import com.bridgelabz.bookstore.repository.CartImple;
import com.bridgelabz.bookstore.service.IBookService;

import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class BookServiceImplementation implements IBookService {
	private BookInformation bookinformation = new BookInformation();
	private CartInformation cartinformation = new CartInformation();
	private ModelMapper modelMapper = new ModelMapper();
//	@Autowired
//	private ModelMapper modelMapper;
//	@Autowired
//	private IBook repo;

	@Autowired
	private BookImple repository;
	
	@Autowired
	private CartImple cartrepository;
	
	

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
	public List<BookInformation> sortGetAllBooks() {
		List<BookInformation> list=repository.findAll();
		list.sort((BookInformation book1,BookInformation book2)->book1.getPrice().compareTo(book2.getPrice()));
		return list;
	}

	@Transactional
	@Override
	public void addtocart(Long userId, int quantity, Long bookId) {
		
		BookInformation book = repository.fetchbyId(bookId);
		cartinformation.setUserId(userId);
		cartinformation.setQuantity(quantity);
		cartinformation.setBookId(bookId);
		cartrepository.save(cartinformation);
		System.out.println(book);
		//book.getList().add(userId, quantity,bookId);
		repository.save(book);
		
		
		
		
		
	}

}
