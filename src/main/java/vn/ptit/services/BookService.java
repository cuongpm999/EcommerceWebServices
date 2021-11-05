package vn.ptit.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ptit.entities.book.BookItem;
import vn.ptit.repositories.book.BookItemRepository;

@Service
public class BookService {
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	BookItemRepository bookItemRepository;
	
	@SuppressWarnings("unchecked")
	public List<BookItem> getBookItemBySlug(String slug) {
		String jpql = "select p from BookItem p";
		if(!slug.isEmpty()) {
			jpql += " where p.slug = '" + slug +"'";
		}
		Query query = entityManager.createQuery(jpql, BookItem.class);
		return query.getResultList();
	}
}
