package vn.ptit.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import vn.ptit.entities.order.Order;
import vn.ptit.entities.shoes.ShoesItem;

@Service
public class OrderService {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Order> getOrderByIdCustomer(int id) {
		String jpql = "select o from Order o where customer.id = " +id;
		Query query = entityManager.createQuery(jpql, Order.class);
		return query.getResultList();
	}
	
	public List<Order> getOrderByStatus() {
		String jpql = "select o from Order o where status = 'Đã giao'";
		Query query = entityManager.createQuery(jpql, Order.class);
		return query.getResultList();
	}
}
