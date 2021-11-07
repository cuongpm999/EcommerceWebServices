package vn.ptit.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import vn.ptit.entities.shoes.ShoesItem;
import vn.ptit.utils.FilterMap;

@Service
public class ShoesService {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<ShoesItem> getShoesItemBySlug(String slug) {
		String jpql = "SELECT c FROM ShoesItem c";
		if (!slug.isEmpty()) {
			jpql += " WHERE c.slug = '" + slug + "'";
		}
		Query query = entityManager.createQuery(jpql, ShoesItem.class);
		return query.getResultList();
	}

	public List<ShoesItem> get4CShoesItemBySlug(String slug) {
		String jpql = "SELECT c FROM ShoesItem c";
		if (!slug.isEmpty()) {
			jpql += " WHERE c.slug <> '" + slug + "' order by rand()";
		}
		Query query = entityManager.createQuery(jpql, ShoesItem.class);
		return query.setMaxResults(4).getResultList();
	}
	
	public List<ShoesItem> findByCategory(List<FilterMap> list) {
		String jpql = "select p from ShoesItem p where 1=1";
		for (FilterMap filterMap : list) {
			if (filterMap.getKey().equalsIgnoreCase("sort")) {
				if (filterMap.getValue().equalsIgnoreCase("low-to-high")) {
					jpql += " order by p.price asc";
				} else
					jpql += " order by p.price desc";

			} else if (filterMap.getKey().equalsIgnoreCase("price")) {
				if (filterMap.getValue().compareToIgnoreCase("duoi100") == 0) {
					jpql += " and p.price<100000";

				} else if (filterMap.getValue().compareToIgnoreCase("tu100den300") == 0) {
					jpql += " and p.price>=100000 and p.price<300000";

				} else if (filterMap.getValue().compareToIgnoreCase("tu300den500") == 0) {
					jpql += " and p.price>=300000 and p.price<500000";

				} else if (filterMap.getValue().compareToIgnoreCase("tu500den1trieu") == 0) {
					jpql += " and p.price>=500000 and p.price<1000000";

				} else if (filterMap.getValue().compareToIgnoreCase("tren1trieu") == 0) {
					jpql += " and p.price>=1000000";

				}
			} else if (filterMap.getKey().equalsIgnoreCase("color")) {
				jpql += " and p.shoes." + filterMap.getKey() + "='" + filterMap.getValue() + "'";
			} else if (filterMap.getKey().equalsIgnoreCase("style")) {
				jpql += " and p.shoes." + filterMap.getKey() + "='" + filterMap.getValue() + "'";
			} else if (filterMap.getKey().equalsIgnoreCase("material")) {
				jpql += " and p.shoes." + filterMap.getKey() + "='" + filterMap.getValue() + "'";
			}
		}
		Query query = entityManager.createQuery(jpql, ShoesItem.class);
		return query.getResultList();
	}
	
	public List<ShoesItem> findByName(String name){
		String jpql = "SELECT p FROM ShoesItem p";
		jpql += " WHERE p.shoes.name LIKE '%" + name + "%'";
		Query query = entityManager.createQuery(jpql, ShoesItem.class);
		return query.getResultList();
	}
}
