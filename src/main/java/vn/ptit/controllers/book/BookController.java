package vn.ptit.controllers.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.book.Book;
import vn.ptit.repositories.book.BookRepository;

@RestController
@RequestMapping("/rest/api/book")
public class BookController {
	@Autowired BookRepository bookRepository;
	
	@PostMapping(value = "/insert")
	public Book insert(@RequestBody Book book, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return bookRepository.save(book);
	}
	
	@GetMapping(value = "/find-all")
	public List<Book> findAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return bookRepository.findAll();
	}
	
	@GetMapping(value = "/find-by-id/{id}")
	public Book findBookById(@PathVariable("id") int id) {
		return bookRepository.findById(id).get();
	}
	
	@GetMapping(value = "/delete-by-id/{id}")
	public Integer deleteByIdBook(@PathVariable("id") int id) {
		bookRepository.deleteById(id);
		return 1;
	}
}
