package vn.ptit.controllers.admin.shoes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.shoes.Sneaker;
import vn.ptit.repositories.shoes.SneakerRepository;

@RestController
@RequestMapping("/rest/api/shoes/sneaker")
public class AdminSneakerController {

	@Autowired SneakerRepository sneakerRepository;
	
	@PostMapping(value = "/insert")
	public Sneaker insert(@RequestBody Sneaker sneaker, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return sneakerRepository.save(sneaker);
	}
}
