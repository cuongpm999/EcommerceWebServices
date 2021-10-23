package vn.ptit.repositories.shoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.shoes.Boots;

@Repository
public interface BootsRepository extends JpaRepository<Boots, Integer> {

}
