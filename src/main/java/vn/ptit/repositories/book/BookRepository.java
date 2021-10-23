package vn.ptit.repositories.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
