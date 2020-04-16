package com.bridgelabz.bookstore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.bridgelabz.bookstore.entity.BookInformation;


@Repository
public class IBookImple implements IBook {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public BookInformation save(BookInformation bookinformation) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(bookinformation);
		return bookinformation;
	}

	@Override
	public List<BookInformation> getUsers() {
		Session currentSession = entityManager.unwrap(Session.class);
		List BookList = currentSession.createQuery("from BookInformation").getResultList();
		return BookList;

	}
//	@Override
//	public BookInformation searchTitle(String title)
//	{
//		Session session = entityManager.unwrap(Session.class);
//		Query q = session.createQuery("from BookInformation where book_name=:title");
//		q.setParameter("book_name", title);
//		System.out.println("in ses"+title);
//		return (BookInformation) q.uniqueResult();
//	}
}

