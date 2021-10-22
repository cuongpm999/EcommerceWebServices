package vn.ptit.repositories.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.book.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
