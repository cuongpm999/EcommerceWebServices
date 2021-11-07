package vn.ptit.services;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import vn.ptit.entities.clothes.ClothesItem;
import vn.ptit.utils.FilterMap;

@Service
public class ClothesService {
	@PersistenceContext
	EntityManager entityManager;

	private int LIMIT = 28;

	public List<ClothesItem> getClothesItemBySlug(String slug) {
		String jpql = "SELECT c FROM ClothesItem c";
		if (!slug.isEmpty()) {
			jpql += " WHERE c.slug = '" + slug + "'";
		}
		Query query = entityManager.createQuery(jpql, ClothesItem.class);
		return query.getResultList();
	}

	public List<ClothesItem> get4ClothesItemBySlug(String slug) {
		String jpql = "SELECT c FROM ClothesItem c";
		if (!slug.isEmpty()) {
			jpql += " WHERE c.slug <> '" + slug + "' order by rand()";
		}
		Query query = entityManager.createQuery(jpql, ClothesItem.class);
		return query.setMaxResults(4).getResultList();
	}

	public List<ClothesItem> get8ClothesItemInHome() {
		String jpql = "SELECT c FROM ClothesItem c ORDER BY substring_index(c.slug, '-', -1) desc";
		Query query = entityManager.createQuery(jpql, ClothesItem.class);
		return query.setMaxResults(8).getResultList();
	}

	public List<ClothesItem> findByCategory(List<FilterMap> list) {
		String jpql = "select p from ClothesItem p where 1=1";
		int page = 1;
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
				jpql += " and p.clothes." + filterMap.getKey() + "='" + filterMap.getValue() + "'";
			} else if (filterMap.getKey().equalsIgnoreCase("style")) {
				jpql += " and p.clothes." + filterMap.getKey() + "='" + filterMap.getValue() + "'";
			} else if (filterMap.getKey().equalsIgnoreCase("material")) {
				jpql += " and p.clothes." + filterMap.getKey() + "='" + filterMap.getValue() + "'";
			}else if (filterMap.getKey().equalsIgnoreCase("pageNumber")) {
				page = Integer.parseInt(filterMap.getValue());
			}
		}
		Query query = entityManager.createQuery(jpql, ClothesItem.class);
		query.setFirstResult((page-1)*LIMIT);
		query.setMaxResults(LIMIT);
		return query.getResultList();
	}
	
	public List<ClothesItem> findItemByCategory(List<FilterMap> list) {
		String jpql = "select p from ClothesItem p where 1=1";
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
				jpql += " and p.clothes." + filterMap.getKey() + "='" + filterMap.getValue() + "'";
			} else if (filterMap.getKey().equalsIgnoreCase("style")) {
				jpql += " and p.clothes." + filterMap.getKey() + "='" + filterMap.getValue() + "'";
			} else if (filterMap.getKey().equalsIgnoreCase("material")) {
				jpql += " and p.clothes." + filterMap.getKey() + "='" + filterMap.getValue() + "'";
			}
		}
		Query query = entityManager.createQuery(jpql, ClothesItem.class);
		return query.getResultList();
	}

	public List<ClothesItem> findByName(String name) {
		String jpql = "SELECT p FROM ClothesItem p";
		jpql += " WHERE p.clothes.name LIKE '%" + name + "%'";
		Query query = entityManager.createQuery(jpql, ClothesItem.class);
		return query.getResultList();
	}

}
