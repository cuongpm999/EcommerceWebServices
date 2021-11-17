package vn.ptit.repositories.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.employee.TotalVisit;

@Repository
public interface TotalVisitRepository extends JpaRepository<TotalVisit, Integer>{

}
