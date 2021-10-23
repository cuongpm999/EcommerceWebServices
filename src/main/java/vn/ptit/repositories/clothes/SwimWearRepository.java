package vn.ptit.repositories.clothes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.clothes.SwimWear;
@Repository
public interface SwimWearRepository extends JpaRepository<SwimWear, Integer>{

}
