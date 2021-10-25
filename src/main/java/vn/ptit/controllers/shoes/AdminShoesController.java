package vn.ptit.controllers.shoes;

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

import vn.ptit.entities.shoes.Boots;
import vn.ptit.entities.shoes.HighHeels;
import vn.ptit.entities.shoes.Shoes;
import vn.ptit.entities.shoes.Sneaker;
import vn.ptit.repositories.shoes.BootsRepository;
import vn.ptit.repositories.shoes.HighHeelsRepository;
import vn.ptit.repositories.shoes.ShoesRepository;
import vn.ptit.repositories.shoes.SneakerRepository;

@RestController
@RequestMapping("/rest/api/shoes")
public class AdminShoesController {
	@Autowired ShoesRepository shoesRepository;
	@Autowired SneakerRepository sneakerRepository;
	@Autowired BootsRepository bootsRepository;
	@Autowired HighHeelsRepository highHeelsRepository;
	
	@GetMapping(value = "find-all")
	public List<Shoes> findAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp){
		return shoesRepository.findAll();
	}
	@PostMapping(value = "/boots/insert")
	public Boots insert(@RequestBody Boots boots, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return bootsRepository.save(boots);
	}
	@PostMapping(value = "/sneaker/insert")
	public Sneaker insert(@RequestBody Sneaker sneaker, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return sneakerRepository.save(sneaker);
	}
	@PostMapping(value = "/highheels/insert")
	public HighHeels insert(@RequestBody HighHeels highheels, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return highHeelsRepository.save(highheels);
	}
}
