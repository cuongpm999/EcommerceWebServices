package vn.ptit.repositories.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.book.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
