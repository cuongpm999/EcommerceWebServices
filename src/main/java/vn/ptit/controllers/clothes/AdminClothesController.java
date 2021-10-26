package vn.ptit.controllers.clothes;

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

import vn.ptit.repositories.clothes.ClothesRepository;
import vn.ptit.repositories.clothes.DressesRepository;
import vn.ptit.repositories.clothes.JeansRepository;
import vn.ptit.repositories.clothes.SwimWearRepository;
import vn.ptit.entities.clothes.Clothes;
import vn.ptit.entities.clothes.Dresses;
import vn.ptit.entities.clothes.Jeans;
import vn.ptit.entities.clothes.SwimWear;

@RestController
@RequestMapping("/rest/api/clothes")
public class AdminClothesController {
	@Autowired ClothesRepository clothesRepository;
	@Autowired DressesRepository dressesRepository;
	@Autowired JeansRepository jeansRepository;
	@Autowired SwimWearRepository swimWearRepository;
	
	@GetMapping(value = "/find-all")
	public List<Clothes> findAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp){
		return clothesRepository.findAll();
	}
	
	@PostMapping(value = "/dresses/insert")
	public Dresses insert(@RequestBody Dresses dresses, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return dressesRepository.save(dresses);
	}
	
	@PostMapping(value = "/jeans/insert")
	public Jeans insert(@RequestBody Jeans jeans, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return jeansRepository.save(jeans);
	}
	
	@PostMapping(value = "/swimwear/insert")
	public SwimWear insert(@RequestBody SwimWear swimwear, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return swimWearRepository.save(swimwear);
	}
	
}
