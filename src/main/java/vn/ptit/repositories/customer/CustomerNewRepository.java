package vn.ptit.repositories.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.customer.CustomerNew;

@Repository
public interface CustomerNewRepository extends JpaRepository<CustomerNew, Integer>{

}
