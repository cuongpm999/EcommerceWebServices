package vn.ptit.controllers.shoes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.shoes.Boots;
import vn.ptit.repositories.shoes.BootsRepository;

@RestController
@RequestMapping("/rest/api/shoes/boots")
public class AdminBootsController {

	@Autowired BootsRepository bootsRepository;
	
	@PostMapping(value = "/insert")
	public Boots insert(@RequestBody Boots boots, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return bootsRepository.save(boots);
	}
}
