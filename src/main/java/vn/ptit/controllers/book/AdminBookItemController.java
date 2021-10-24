package vn.ptit.controllers.book;

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
import vn.ptit.repositories.book.ImgBookItemRepository;

@RestController
@RequestMapping("/rest/api/book-item")
public class AdminBookItemController {

	@Autowired
	BookItemRepository bookItemRepository;

	@Autowired
	ImgBookItemRepository imgBookItemRepository;

	@PostMapping(value = "/insert")
	public BookItem insert(@RequestBody BookItem bookItem, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		for (int i = 0; i < bookItem.getImgBookItems().size(); i++) {
			bookItem.getImgBookItems().get(i).setBookItem(bookItem);
		}
		return bookItemRepository.save(bookItem);
	}

	@GetMapping(value = "/find-all")
	public List<BookItem> findAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return bookItemRepository.findAll();
	}

}
