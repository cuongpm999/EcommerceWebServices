package vn.ptit.controllers.admin.shoes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.shoes.HighHeels;
import vn.ptit.repositories.shoes.HighHeelsRepository;

@RestController
@RequestMapping("/rest/api/shoes/highheels")
public class AdminHighHeelsController {
	
	@Autowired HighHeelsRepository highHeelsRepository;
	
	@PostMapping(value = "/insert")
	public HighHeels insert(@RequestBody HighHeels highheels, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return highHeelsRepository.save(highheels);
	}
}
