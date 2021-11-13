package vn.ptit.repositories.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.order.Cash;
import vn.ptit.entities.order.Payment;

@Repository
public interface CashRepository extends JpaRepository<Cash, Integer>{

}
