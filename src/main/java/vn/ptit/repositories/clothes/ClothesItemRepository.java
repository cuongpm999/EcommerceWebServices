package vn.ptit.repositories.clothes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.clothes.ClothesItem;

@Repository
public interface ClothesItemRepository extends JpaRepository<ClothesItem, String>{

}
