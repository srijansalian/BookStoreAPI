package com.bridgelabz.bookstore.implementation;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.dto.CustomerDto;
import com.bridgelabz.bookstore.entity.Address;
import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.entity.CartInformation;
import com.bridgelabz.bookstore.entity.CustomerInformation;
import com.bridgelabz.bookstore.repository.AddressRepository;
import com.bridgelabz.bookstore.repository.BookImple;
import com.bridgelabz.bookstore.repository.CartImple;
import com.bridgelabz.bookstore.repository.CustomerRepository;
import com.bridgelabz.bookstore.service.IBookService;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class BookServiceImplementation implements IBookService {
	private BookInformation bookinformation = new BookInformation();
	private CartInformation cartinformation = new CartInformation();
	private ModelMapper modelMapper = new ModelMapper();
//	@Autowired
//	private ModelMapper modelMapper;
//	@Autowired
//	private IBook repository;
	@Autowired
	private BookImple repository;

	@Autowired
	CustomerRepository customerrep;
	
	@Autowired
	AddressRepository addrepository;
	
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
	public boolean addandupdatecart(Long userId, int quantity, Long bookId) {
		BookInformation book = repository.fetchbyId(bookId);
		CartInformation cart = cartrepository.fetchbyId(bookId);
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

	@Transactional
	@Override
	public void removefromcart(Long userId, Long bookId) {
		// CartInformation cart =cartrepository.fetchbyId(bookId);
		// System.out.println(cart);
		cartrepository.deletebyId(bookId);
	}

	@Transactional
	@Override
	public List<BookInformation> sortGetAllBooks() {
		List<BookInformation> list = repository.findAll();
		list.sort((BookInformation book1, BookInformation book2) -> book1.getCreatedDateAndTime().compareTo(book2.getCreatedDateAndTime()));
		return list;
	}

//	@Transactional
//	@Override
//	public boolean addandupdatecart(Long userId, int quantity, Long bookId) {
//		BookInformation book = repository.fetchbyId(bookId);
//		CartInformation cart = cartrepository.fetchbyId(bookId);
//		//Session session=new Session();
//		if (cart != null) {
//			int updatedquantity = cart.getQuantity() + quantity;
//			System.out.println(updatedquantity);
//			if (book.getQuantity() >= updatedquantity) {
//				cartrepository.verifyTheUser(updatedquantity, bookId);
//				return true;
//			} else
//				return false;
//		} else if (book.getQuantity() >= quantity) {
//			cartinformation.setUserId(userId);
//			cartinformation.setQuantity(quantity);
//			cartinformation.setBookId(bookId);
//			cartrepository.save(cartinformation);
//			return true;
//		}
//		return false;
//
//	}
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

//}
	
	@Override
	public List<BookInformation> sorting(boolean value){
		List<BookInformation> list = repository.findAll();
		if(value==true) {
		list.sort((BookInformation book1, BookInformation book2) -> book1.getPrice().compareTo(book2.getPrice()));
		return list;
		}
		else {
			list.sort((BookInformation book1, BookInformation book2) -> book1.getPrice().compareTo(book2.getPrice()));
			Collections.reverse(list);
			return list;
		}
	}

	@Override
	public List<BookInformation> findAllPageBySize(int pagenumber) {
		long count = repository.count();
		System.out.println("count ::" + count);
		int pageSize = 3;
		int pages = (int) ((count / pageSize));
		int i = pagenumber; // i should start with zero or 0...
		while (i <= pages) {
			System.out.println("display pages::" + pages);
			System.out.println("Pages ::" + i);
			List<BookInformation> list = repository.findAllPage(PageRequest.of(i, pageSize));
			i++;
			return list;
		}
		return null;
	}

	@Override
	public BookInformation getBookfromCart(long bookId) {
		CartInformation cartinfo = new CartInformation();
		cartinfo.setBookId(bookId);
		cartrepository.save(cartinfo);
		long cartId = cartinfo.getCartId();
		CartInformation info = cartrepository.fetchbyId(cartId);
		if (info != null) {
			BookInformation bookinfo = repository.fetchbyId(info.getBookId());
			if (bookinfo != null) {
				return bookinfo;
			}
		}
		return null;
	}

	@Override
	public boolean deletefromCart(long bookId) {
		CartInformation cartinfo = cartrepository.findCartbyId(bookId);
		if (cartinfo != null) {
			cartrepository.delete(cartinfo);
			return true;
		}
		return false;
	}

	@Override
	public BookInformation getTotalPriceofBook(long bookId, int quantity) {
		BookInformation bookinfo = repository.fetchbyId(bookId);
		double Price = bookinfo.getPrice();
		int Quantity = quantity;
		if (Quantity <= bookinfo.getQuantity() || Quantity >= bookinfo.getQuantity()) {
			if (bookinfo != null && quantity > 0) {
				double price = getOriginalPrice(Price, bookinfo.getQuantity());
				double totalPrice = (price * Quantity);
				bookinfo.setQuantity(quantity);
				bookinfo.setPrice(totalPrice);
				repository.save(bookinfo);
				return bookinfo;
			} else if (bookinfo != null && quantity < 1) {
				double price = getOriginalPrice(Price, bookinfo.getQuantity());
				double totalPrice = (price * 1);
				bookinfo.setQuantity(quantity);
				bookinfo.setPrice(totalPrice);
				repository.save(bookinfo);
				return bookinfo;
			}
		}
		return null;
	}

	public double getOriginalPrice(double price, int quantity) {
		long result = (long) (price / quantity);
		return result;
	}

	@Override
	public boolean addCustomerDetails(CustomerDto dto, String variable) {
		Address addinfo = new Address();
		CustomerInformation info = new CustomerInformation();
		
		addinfo.setPincode(dto.getPincode());
		addinfo.setLocality(dto.getLocality());
		addinfo.setAddress(dto.getAddress());
		addinfo.setCity(dto.getCity());
		addinfo.setLandmark(dto.getLandmark());
		addrepository.save(addinfo);
		
		info.setName(dto.getName());
		info.setPhonenumber(dto.getPhonenumber());
		customerrep.save(info);
		
		addinfo.setUserId(info.getUserId());
		addrepository.save(addinfo);
		
		customerrep.save(info);
		 
		if(variable.equals("Home")) {
		    info.setHome(addinfo); 
		    customerrep.save(info);
		}
		if( variable.equals("Work")) {
			info.setWork(addinfo);
			customerrep.save(info);
		}
		if( variable.equals("Other")) {
			info.setOthers(addinfo); 
			customerrep.save(info);
		}
		
		return true;
	}


	
}
