package vn.ptit.repositories.electronics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.electronics.Laptop;
import vn.ptit.entities.electronics.MobilePhone;

@Repository
public interface MobilePhoneRepository extends JpaRepository<MobilePhone, Integer>{
	
}
