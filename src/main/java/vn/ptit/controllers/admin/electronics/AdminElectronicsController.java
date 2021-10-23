package vn.ptit.controllers.admin.electronics;

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

import vn.ptit.entities.electronics.Electronics;
import vn.ptit.entities.electronics.Laptop;
import vn.ptit.entities.electronics.Manufacturer;
import vn.ptit.entities.electronics.MobilePhone;
import vn.ptit.entities.electronics.Tivi;
import vn.ptit.repositories.electronics.ElectronicsRepository;
import vn.ptit.repositories.electronics.LaptopRepository;
import vn.ptit.repositories.electronics.MobilePhoneRepository;
import vn.ptit.repositories.electronics.TiviRepository;

@RestController
@RequestMapping("/rest/api/electronics")
public class AdminElectronicsController {
	@Autowired ElectronicsRepository electronicsRepository;
	@Autowired LaptopRepository laptopRepository;
	@Autowired TiviRepository tiviRepository;
	@Autowired MobilePhoneRepository mobilePhoneRepository;
	
	@GetMapping(value = "/find-all")
	public List<Electronics> findAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		return electronicsRepository.findAll();
	}
	
	@PostMapping(value = "/laptop/insert")
	public Laptop insertLaptop(@RequestBody Laptop laptop, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		return laptopRepository.save(laptop);
	}
	
	@PostMapping(value = "/tivi/insert")
	public Tivi insert(@RequestBody Tivi tivi, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		return tiviRepository.save(tivi);
	}
	
	@PostMapping(value = "/mobilephone/insert")
	public MobilePhone insert(@RequestBody MobilePhone mobilePhone, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		return mobilePhoneRepository.save(mobilePhone);
	}

}
