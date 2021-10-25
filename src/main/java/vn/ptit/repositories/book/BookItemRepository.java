package vn.ptit.repositories.book;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.ptit.entities.book.BookItem;

public interface BookItemRepository extends JpaRepository<BookItem, String> {

}
