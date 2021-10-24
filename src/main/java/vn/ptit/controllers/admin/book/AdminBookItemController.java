package vn.ptit.controllers.admin.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.book.BookItem;
import vn.ptit.repositories.book.BookItemRepository;

@RestController
@RequestMapping("/rest/api/book-item")
public class AdminBookItemController {
	
	@Autowired BookItemRepository bookItemRepository;
	
	@PostMapping(value = "/insert")
	public BookItem insert(@RequestBody BookItem bookItem, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return bookItemRepository.save(bookItem);
	}
	
	@GetMapping(value = "/find-all")
	public List<BookItem> findAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return bookItemRepository.findAll();
	}
	
}
