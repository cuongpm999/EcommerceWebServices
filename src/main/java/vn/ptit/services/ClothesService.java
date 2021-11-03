package vn.ptit.services;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import vn.ptit.entities.clothes.Clothes;
import vn.ptit.entities.clothes.ClothesItem;

@Service
public class ClothesService {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<ClothesItem> getClothesItemBySlug(String slug) {
		String jpql = "SELECT c FROM ClothesItem c";
		if(!slug.isEmpty()) {
			jpql += " WHERE c.slug = '" + slug + "'";
		}
		Query query = entityManager.createQuery(jpql, ClothesItem.class);
		return query.getResultList();
	}

}
