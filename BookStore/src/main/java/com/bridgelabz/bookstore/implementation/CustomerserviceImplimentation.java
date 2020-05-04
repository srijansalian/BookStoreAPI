package com.bridgelabz.bookstore.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstore.dto.CustomerDto;
import com.bridgelabz.bookstore.entity.Address;
import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.entity.CartInformation;
import com.bridgelabz.bookstore.entity.CustomerInformation;
import com.bridgelabz.bookstore.repository.AddressRepository;
import com.bridgelabz.bookstore.repository.BookImple;
import com.bridgelabz.bookstore.repository.CartImple;
import com.bridgelabz.bookstore.repository.CustomerRepository;
import com.bridgelabz.bookstore.service.Customerservice;

@Service
public class CustomerserviceImplimentation implements Customerservice {

	@Autowired
	private BookImple repository;
	@Autowired
	private CartImple cartrepository;
	@Autowired
	CustomerRepository customerrep;
	@Autowired
	AddressRepository addrepository;
	
	@Override
	public BookInformation getBookfromCart(long bookId, long userId) {
		CartInformation cartinfo = new CartInformation();
		cartinfo.setBookId(bookId);
		cartinfo.setUserId(userId); 
		cartrepository.save(cartinfo);
		long cartId = cartinfo.getCartId();
		CartInformation info = cartrepository.findCartbyId(cartId);
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
	
	public double getOriginalPrice(double price, int quantity) {
		long result = (long) (price / quantity);
		return result;
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
