package vn.ptit.repositories.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.order.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Integer>{

}
