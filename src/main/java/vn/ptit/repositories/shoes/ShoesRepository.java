package vn.ptit.repositories.shoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.shoes.Shoes;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes, Integer> {

}
