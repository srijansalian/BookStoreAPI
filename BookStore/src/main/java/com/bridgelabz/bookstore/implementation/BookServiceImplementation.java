package com.bridgelabz.bookstore.implementation;
import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.repository.IBook;
import com.bridgelabz.bookstore.service.IBookService;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import javax.transaction.Transactional;


@Service
public class BookServiceImplementation implements IBookService{
	private BookInformation bookinformation = new BookInformation();
	private ModelMapper modelMapper = new ModelMapper();
//	@Autowired
//	private ModelMapper modelMapper;
	@Autowired
	private IBook repository;

	@Transactional
	@Override
	public boolean addBooks(BookDto information) {
		bookinformation = modelMapper.map(information, BookInformation.class);
		bookinformation.setBookName(information.getBookName());
		bookinformation.setAuthorName(information.getAuthorName());
		bookinformation.setPrice(information.getPrice());
		bookinformation.setQuantity(information.getQuantity());
		repository.save(bookinformation);
		return true;
	}

	@Transactional
	@Override
	public List<BookInformation> getUsers() {
		List<BookInformation> users = repository.getUsers();
		// UserInformation user = users.get(0);
		return users;
	}

	


}
