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
import org.springframework.boot.web.servlet.server.Session;

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
	public boolean addandupdatecart(Long userId, int quantity, Long bookId) {
		BookInformation book = repository.fetchbyId(bookId);
		CartInformation cart = cartrepository.fetchbyId(bookId);
		//Session session=new Session();
		if (cart != null) {
			int updatedquantity = cart.getQuantity() + quantity;
			System.out.println(updatedquantity);
			if (book.getQuantity() >= updatedquantity) {
				cartrepository.verifyTheUser(updatedquantity, bookId);
				return true;
			} else
				return false;
		} else if (book.getQuantity() >= quantity) {
			cartinformation.setUserId(userId);
			cartinformation.setQuantity(quantity);
			cartinformation.setBookId(bookId);
			cartrepository.save(cartinformation);
			return true;
		}
		return false;

	}
//	@Transactional
//	@Override
//	public String setPurchasingQuantity(Long userId, int quantity, Long bookId) {
//		BookInformation bookid = repository.fetchbyId(bookId);
//		System.out.println("bookid"+bookId);
//		if(bookid.getQuantity()>=quantity) {
//			cartinformation.setQuantity(bookid.getQuantity()-quantity);
//			System.out.println(bookid.getQuantity()-quantity);
//			cartrepository.save(cartinformation);
//		}else {
//		}
//		return "";
//
//	}

}
