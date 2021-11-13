package vn.ptit.repositories.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.order.ShoppingCart;

@Repository
public interface CartRepository extends JpaRepository<ShoppingCart, Integer>{

}
