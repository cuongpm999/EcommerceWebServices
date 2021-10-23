package vn.ptit.repositories.shoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.shoes.Sneaker;

@Repository
public interface SneakerRepository extends JpaRepository<Sneaker, Integer>{

}
