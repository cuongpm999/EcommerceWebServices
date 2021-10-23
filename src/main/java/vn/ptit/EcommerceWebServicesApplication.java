package vn.ptit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import vn.ptit.entities.book.Author;
import vn.ptit.entities.book.Book;
import vn.ptit.entities.book.Publisher;
import vn.ptit.repositories.book.AuthorRepository;
import vn.ptit.repositories.book.BookRepository;
import vn.ptit.repositories.book.PublisherRepository;

@SpringBootApplication
public class EcommerceWebServicesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EcommerceWebServicesApplication.class, args);
//		PublisherRepository publisherRepository = context.getBean(PublisherRepository.class);
//		Publisher publisher = new Publisher();
//		publisher.setName("NXB Giáo dục");
//		publisher.setAddress("Hà Nội");
//		publisherRepository.save(publisher);
		
//		AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
//		Author author = new Author();
//		author.setName("Trần Đình Quế");
//		author.setBiography("Quê quán: Huế, Tuổi: 50");
//		authorRepository.save(author);
		
//		BookRepository bookRepository = context.getBean(BookRepository.class);
//		Book book = new Book();
//		book.setTitle("Phân tích thiết kế hệ thống thông tin");
//		book.setPages(500);
//		book.setLanguage("Tiếng Việt");
//		book.setSummary("Phân tích thiết kế hệ thống thông tin");
//		book.setAuthors(authorRepository.findAll());
//		book.setPublisher(publisherRepository.findAll().get(0));
//		bookRepository.save(book);
	}

}
