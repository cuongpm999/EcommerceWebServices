package vn.ptit.repositories.electronics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.electronics.ImgElectronicsItem;

@Repository
public interface ImgElectronicsItemRepository extends JpaRepository<ImgElectronicsItem, Integer>{

}
