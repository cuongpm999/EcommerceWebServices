package vn.ptit.repositories.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.customer.Customer;
import vn.ptit.entities.customer.CustomerMember;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
