package vn.ptit.repositories.shoes;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.ptit.entities.shoes.ShoesItem;

public interface ShoesItemRepository extends JpaRepository<ShoesItem, String>{

}
