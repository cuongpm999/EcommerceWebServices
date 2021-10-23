package vn.ptit.repositories.clothes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.clothes.Jeans;

@Repository
public interface JeansRepository extends JpaRepository<Jeans, Integer>{

}
