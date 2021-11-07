package vn.ptit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.ptit.entities.customer.CustomerMember;

public interface CustomerMemberRepository extends JpaRepository<CustomerMember, Integer>{

}
