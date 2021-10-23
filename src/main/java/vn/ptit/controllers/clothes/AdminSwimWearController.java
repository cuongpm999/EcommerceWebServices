package vn.ptit.controllers.clothes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.clothes.SwimWear;
import vn.ptit.repositories.clothes.SwimWearRepository;

@RestController
@RequestMapping("/rest/api/clothes/swimwear")
public class AdminSwimWearController {

	@Autowired SwimWearRepository swimWearRepository;
	
	@PostMapping(value = "/insert")
	public SwimWear insert(@RequestBody SwimWear swimwear, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return swimWearRepository.save(swimwear);
	}
}
