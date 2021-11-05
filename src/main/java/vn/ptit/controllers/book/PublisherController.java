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

import vn.ptit.entities.book.Publisher;
import vn.ptit.repositories.book.PublisherRepository;

@RestController
@RequestMapping("/rest/api/publisher")
public class PublisherController {
	@Autowired PublisherRepository publisherRepository;

	@PostMapping(value = "/insert")
	public Publisher insert(@RequestBody Publisher publisher, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return publisherRepository.save(publisher);
	}

	@GetMapping(value = "/find-all")
	public List<Publisher> findAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return publisherRepository.findAll();
	}
}
