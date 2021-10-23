package vn.ptit.repositories.clothes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.clothes.Clothes;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Integer>{

}
