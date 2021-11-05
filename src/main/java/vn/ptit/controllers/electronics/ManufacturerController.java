package vn.ptit.controllers.electronics;

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

import vn.ptit.entities.electronics.Laptop;
import vn.ptit.entities.electronics.Manufacturer;
import vn.ptit.repositories.electronics.ManufacturerRepository;

@RestController
@RequestMapping("/rest/api/manufacturer")
public class ManufacturerController {
	@Autowired ManufacturerRepository manufacturerRepository;
	
	@GetMapping(value = "/find-all")
	public List<Manufacturer> findAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		return manufacturerRepository.findAll();
	}
	
	@PostMapping(value = "/insert")
	public Manufacturer insert(@RequestBody Manufacturer manufacturer, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		return manufacturerRepository.save(manufacturer);
	}
	
	

}
