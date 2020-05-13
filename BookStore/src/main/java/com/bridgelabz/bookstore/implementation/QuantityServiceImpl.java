//package com.bridgelabz.bookstore.implementation;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.bridgelabz.bookstore.entity.BookInformation;
//import com.bridgelabz.bookstore.entity.CartInformation;
//import com.bridgelabz.bookstore.entity.QuantityEntity;
//import com.bridgelabz.bookstore.repository.BookImple;
//import com.bridgelabz.bookstore.repository.CartImple;
//import com.bridgelabz.bookstore.repository.QuantityRepository;
//import com.bridgelabz.bookstore.service.QuantityService;
//
//@Service
//public class QuantityServiceImpl implements QuantityService{
//
//	@Autowired
//	private BookImple bookrepo;
//	@Autowired
//	private QuantityRepository repo;
//	@Autowired
//	private  CartImple cartrepo;
//
//
//	@Transactional
//	@Override
//	public void addQuantity(long bookId,int Quantity) 
//	{
//	BookInformation book=bookrepo.fetchbyId(bookId);
//	QuantityEntity en = new QuantityEntity();
//	if(book!=null)
//	{
//		en.setBookquantity(book);
//		en.setQuantity(Quantity);
//	    repo.create(Quantity,book.getBookId());
//       
//	    bookrepo.save(book);
//	}
//	
//	}
//	
//	@Transactional
//	@Override
//	public void addtocartquantity(long bookId,long qid) 
//	{
//		BookInformation book=bookrepo.fetchbyId(bookId);
//		CartInformation crt=book.getCartId();
// //    System.out.println((cart.getCartId()));  
//       QuantityEntity en=repo.getquantId(qid);
//	System.out.println(en.getQuantity_id());
//	  if(en!=null)
//	  {   
//	  repo.save(crt.getCartId(),en.getQuantity_id());
//	  }
//
//	}
//	
//}
//		
//		
//	
//
//
