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
import vn.ptit.entities.electronics.MobilePhone;
import vn.ptit.entities.electronics.Tivi;
import vn.ptit.repositories.electronics.LaptopRepository;
import vn.ptit.repositories.electronics.MobilePhoneRepository;
import vn.ptit.repositories.electronics.TiviRepository;

@RestController
@RequestMapping("/rest/api/electronics/mobilePhone")
public class AdminMobilePhoneController {
	@Autowired MobilePhoneRepository mobilePhoneRepository;
	
	@PostMapping(value = "/insert")
	public MobilePhone insert(@RequestBody MobilePhone mobilePhone, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		return mobilePhoneRepository.save(mobilePhone);
	}
}
