package vn.ptit.repositories.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.book.ImgBookItem;

@Repository
public interface ImgBookItemRepository extends JpaRepository<ImgBookItem, Integer>{

}
