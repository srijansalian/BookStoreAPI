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
//		BookInformation books = repository.fetchbyId(bookId);
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
	public boolean deletefromCart(long bookId, long cartId) {
		CartInformation cartinfo = cartrepository.cartbyId(cartId, bookId);
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
	public CustomerInformation addCustomerDetails(CustomerDto dto) {
System.out.println("dto====="+dto);
System.out.println("______dto home"+dto.getHome());
System.out.println("______dto work"+dto.getWork());
System.out.println("______dto other"+dto.getOther());
CustomerInformation customer = customerrep.getCustomerbyDetails(dto.getName(), dto.getPhonenumber());
    
		CustomerInformation info = new CustomerInformation();
		Address address = new Address();
		Address home = dto.getHome();
		Address work = dto.getWork();
		Address Other = dto.getOther();
		if(home != null && home.getPincode() != 0 && customer == null) {
			System.out.println("______home");
			address.setAddress(home.getAddress());
			address.setCity(home.getCity());
			address.setLandmark(home.getLandmark());
			address.setLocality(home.getLocality());
			address.setPincode(home.getPincode());
			addrepository.save(address);
			info.setName(dto.getName());
			info.setPhonenumber(dto.getPhonenumber());
			info.setHome(address); 
		customerrep.save(info); 
		}
		if(work != null && work.getPincode() != 0 && customer == null) {
			System.out.println("+++++++work");
			address.setAddress(work.getAddress());
			address.setCity(work.getCity());
			address.setLandmark(work.getLandmark());
			address.setLocality(work.getLocality());
			address.setPincode(work.getPincode());
			addrepository.save(address);
			info.setName(dto.getName());
			info.setPhonenumber(dto.getPhonenumber());
			info.setWork(address); 
		customerrep.save(info); 
		}
		if(Other != null && Other.getPincode() != 0 && customer == null) {
			System.out.println("______other");
			address.setAddress(Other.getAddress());
			address.setCity(Other.getCity());
			address.setLandmark(Other.getLandmark());
			address.setLocality(Other.getLocality());
			address.setPincode(Other.getPincode());
			addrepository.save(address);
			info.setName(dto.getName());
			info.setPhonenumber(dto.getPhonenumber());
			info.setOthers(address); 
		customerrep.save(info); 
		}
    
		return info;
		

	}

}
