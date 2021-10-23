package vn.ptit.controllers.clothes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.clothes.Dresses;
import vn.ptit.repositories.clothes.DressesRepository;

@RestController
@RequestMapping("/rest/api/clothes/dresses")
public class AdminDressesController {
	@Autowired DressesRepository dressesRepository;
	
	@PostMapping(value = "/insert")
	public Dresses insert(@RequestBody Dresses dresses, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return dressesRepository.save(dresses);
	}
}
