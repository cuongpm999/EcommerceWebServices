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

import vn.ptit.entities.book.Author;
import vn.ptit.repositories.book.AuthorRepository;

@RestController
@RequestMapping("/rest/api/author")
public class AdminAuthorController {
	@Autowired AuthorRepository authorRepository;
	
	@PostMapping(value = "/insert")
	public Author insert(@RequestBody Author author, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return authorRepository.save(author);
	}
	
	@GetMapping(value = "/find-all")
	public List<Author> findAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return authorRepository.findAll();
	}
	
}
