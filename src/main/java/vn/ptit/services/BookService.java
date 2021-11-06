package vn.ptit.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import vn.ptit.entities.book.BookItem;
import vn.ptit.utils.FilterMap;

@Service
public class BookService {
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<BookItem> findByAuthor(List<FilterMap> list) {

		String jpql = "select p from BookItem p join p.book.authors a where a.id = "
				+ list.get(0).getValue();

		for (FilterMap filterMap : list) {
			if (filterMap.getKey().equalsIgnoreCase("sort")) {
				if (filterMap.getValue().equalsIgnoreCase("low-to-high")) {
					jpql += " order by p.price asc";
				} else
					jpql += " order by p.price desc";

			} else if (filterMap.getKey().equalsIgnoreCase("price")) {
				if (filterMap.getValue().compareToIgnoreCase("duoi100") == 0) {
					jpql += " and p.price<100000";

				} else if (filterMap.getValue().compareToIgnoreCase("100den200") == 0) {
					jpql += " and p.price>=100000 and p.price<200000";

				} else if (filterMap.getValue().compareToIgnoreCase("tren200") == 0) {
					jpql += " and p.price>=200000";

				}
			}
		}

		Query query = entityManager.createQuery(jpql, BookItem.class);

		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<BookItem> findByPublisher(List<FilterMap> list) {

		String jpql = "select p from BookItem p where 1=1 and p.book.publisher.id = "
				+ list.get(0).getValue();

		for (FilterMap filterMap : list) {
			if (filterMap.getKey().equalsIgnoreCase("sort")) {
				if (filterMap.getValue().equalsIgnoreCase("low-to-high")) {
					jpql += " order by p.price asc";
				} else
					jpql += " order by p.price desc";

			} else if (filterMap.getKey().equalsIgnoreCase("price")) {
				if (filterMap.getValue().compareToIgnoreCase("duoi100") == 0) {
					jpql += " and p.price<100000";

				} else if (filterMap.getValue().compareToIgnoreCase("100den200") == 0) {
					jpql += " and p.price>=100000 and p.price<200000";

				} else if (filterMap.getValue().compareToIgnoreCase("tren200") == 0) {
					jpql += " and p.price>=200000";

				}
			}
		}

		Query query = entityManager.createQuery(jpql, BookItem.class);

		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<BookItem> getBookItemBySlug(String slug) {
		String jpql = "select p from BookItem p";
		if(!slug.isEmpty()) {
			jpql += " where p.slug = '" + slug +"'";
		}
		Query query = entityManager.createQuery(jpql, BookItem.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<BookItem> getSameBookItem(String slug) {
		String jpql = "select p from BookItem p";
		if (slug != null) {
			jpql += " where p.slug <> '" + slug + "'order by rand ()";
		}

		Query query = entityManager.createQuery(jpql, BookItem.class);
		query.setMaxResults(4);

		return query.getResultList();
	}
	
	public List<BookItem> findByName(String name){
		String jpql = "SELECT p FROM BookItem p";
		jpql += " WHERE p.book.title LIKE '%" + name + "%'";
		Query query = entityManager.createQuery(jpql, BookItem.class);
		return query.getResultList();
	}
}
