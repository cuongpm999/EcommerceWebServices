package vn.ptit.repositories.electronics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.electronics.Laptop;
import vn.ptit.entities.electronics.MobilePhone;
import vn.ptit.entities.electronics.Tivi;

@Repository
public interface TiviRepository extends JpaRepository<Tivi, Integer>{
	
}
