package vn.ptit.controllers.admin.electronics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.electronics.Laptop;
import vn.ptit.repositories.electronics.LaptopRepository;

@RestController
@RequestMapping("/rest/api/electronics/laptop")
public class AdminLaptopController {
	@Autowired LaptopRepository laptopRepository;
	
	@PostMapping(value = "/insert")
	public Laptop insert(@RequestBody Laptop laptop, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		return laptopRepository.save(laptop);
	}
}
