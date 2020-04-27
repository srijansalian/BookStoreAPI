package com.bridgelabz.bookstore.implementation;

import com.bridgelabz.bookstore.dto.BookDto;

import com.bridgelabz.bookstore.dto.UserDto;
import com.bridgelabz.bookstore.entity.BookInformation;

import com.bridgelabz.bookstore.entity.UserInformation;
import com.bridgelabz.bookstore.repository.BookImple;
import com.bridgelabz.bookstore.repository.UserImple;
import com.bridgelabz.bookstore.response.MailData;
import com.bridgelabz.bookstore.service.IBookService;
import com.bridgelabz.bookstore.utility.MailService;

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
	private UserInformation userinformation=new UserInformation();
//	@Autowired
//	private ModelMapper modelMapper;
//	@Autowired
//	private IBook repo;

	@Autowired
	private BookImple repository;
	@Autowired
	private UserImple userrepository;
	@Autowired
	private MailData maildata;
	

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
	public boolean registeration(UserDto information) {
		userinformation.setPassword(information.getPassword());
		userinformation.setEmail(information.getEmail());
		userinformation.setAddress(information.getAddress());
		
		userrepository.save(userinformation);
		return true;
	
	}
	@Transactional
	@Override
	public UserInformation getOrdersPage(Long userId) {
		UserInformation buyerspage = userrepository.findbyUserId(userId);

		return buyerspage;
	}
	
	@Transactional
	@Override
	public UserInformation sendConfirOrder(Long userId) {
		UserInformation user = userrepository.findbyUserId(userId);
		UserDto information=new UserDto();
		maildata.setEmail(user.getEmail());
		maildata.setMessage("Your Order Is Placed");
		maildata.setSubject("verification");
		MailService.SendEmail(maildata.getEmail(), maildata.getSubject(), maildata.getMessage());
		return user;
	}

}
