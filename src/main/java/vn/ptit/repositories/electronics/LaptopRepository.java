package vn.ptit.repositories.electronics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.electronics.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer>{
	
}
