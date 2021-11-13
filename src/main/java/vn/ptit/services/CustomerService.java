package vn.ptit.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import vn.ptit.entities.customer.Account;
import vn.ptit.entities.customer.CustomerMember;

@Service
public class CustomerService {
	@PersistenceContext
	EntityManager entityManager;

	public CustomerMember getCustomerMemberByAccount(Account account) {
		String jpql = "select p from CustomerMember p";
		if (account != null) {
			jpql += " where p.account.username = '" + account.getUsername() + "'";
			jpql += " and p.account.password = '" + account.getPassword() + "'";
		}
		Query query = entityManager.createQuery(jpql, CustomerMember.class);
		if (query.getResultList().size() > 0) {
			return (CustomerMember) query.getResultList().get(0);
		}
		return null;
	}

	public CustomerMember getCustomerMemberByEmail(String email) {
		String jpql = "select p from CustomerMember p";
		if (!email.isEmpty()) {
			jpql += " where p.email = '" + email + "'";
		}
		Query query = entityManager.createQuery(jpql, CustomerMember.class);
		return (CustomerMember) query.getResultList().get(0);
	}

	public List<CustomerMember> checkMailEdit(int idCus) {
		String jpql = "select p from CustomerMember p where p.id != " + idCus;
		Query query = entityManager.createQuery(jpql, CustomerMember.class);
		return query.getResultList();
	}
}
