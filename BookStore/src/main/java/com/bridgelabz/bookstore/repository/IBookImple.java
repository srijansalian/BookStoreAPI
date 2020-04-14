package com.bridgelabz.bookstore.repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;
import com.bridgelabz.bookstore.entity.BookInformation;


@Repository
public class IBookImple implements IBook{
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public BookInformation save(BookInformation bookinformation) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(bookinformation);
		return bookinformation;
	}




	

}
