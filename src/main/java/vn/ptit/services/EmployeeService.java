package vn.ptit.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import vn.ptit.entities.employee.Employee;

@Service
public class EmployeeService {
	@PersistenceContext
	protected EntityManager entityManager;

	public Employee loadEmployeeByUsername(String username) {
		try {
			String jpql = "select e from Employee e where e.username='" + username +"'";
			Query query = entityManager.createQuery(jpql, Employee.class);
			List<Employee> list= query.getResultList();
			if(list.isEmpty()) return null;
			return (Employee) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
