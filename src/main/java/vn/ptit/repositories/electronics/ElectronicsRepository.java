package vn.ptit.repositories.electronics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.electronics.Electronics;

@Repository
public interface ElectronicsRepository extends JpaRepository<Electronics, Integer>{

}
