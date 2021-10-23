package vn.ptit.controllers.admin.clothes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.clothes.Jeans;
import vn.ptit.repositories.clothes.JeansRepository;

@RestController
@RequestMapping("/rest/api/clothes/jeans")
public class AdminJeansController {
	@Autowired JeansRepository jeansRepository;
	
	@PostMapping(value = "/insert")
	public Jeans insert(@RequestBody Jeans jeans, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return jeansRepository.save(jeans);
	}
}