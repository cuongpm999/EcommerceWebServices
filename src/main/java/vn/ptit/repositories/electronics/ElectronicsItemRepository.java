package vn.ptit.repositories.electronics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.electronics.ElectronicsItem;

@Repository
public interface ElectronicsItemRepository extends JpaRepository<ElectronicsItem, Integer>{

}
