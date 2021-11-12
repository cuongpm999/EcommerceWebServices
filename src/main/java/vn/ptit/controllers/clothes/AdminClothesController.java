package vn.ptit.controllers.clothes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value = "/jeans/{id}")
	public Jeans findJeansById(@PathVariable("id") int id) {
		Optional<Jeans> optJeans = jeansRepository.findById(id);
		if(optJeans.isPresent()) {
			return optJeans.get();
		}
		return null;
	}
	
	@GetMapping(value = "/dresses/{id}")
	public Dresses findDressesById(@PathVariable("id") int id) {
		Optional<Dresses> optDresses = dressesRepository.findById(id);
		if(optDresses.isPresent()) {
			return optDresses.get();
		}
		return null;
	}
	
	@GetMapping(value = "/swimwear/{id}")
	public SwimWear findSwimwearById(@PathVariable("id") int id) {
		Optional<SwimWear> optSwimWear = swimWearRepository.findById(id);
		if(optSwimWear.isPresent()) {
			return optSwimWear.get();
		}
		return null;
	}
	
	@GetMapping("/find-by-category/{category}")
	public List<Clothes> findClothesByCategory(@PathVariable String category) {
		List<Clothes> clothes1 = clothesRepository.findAll();
		List<Clothes> clothes2 = new ArrayList<>();
		if (category.equalsIgnoreCase("Jeans")) {
			for (Clothes clothes : clothes1) {
				if(clothes instanceof Jeans) {
					clothes2.add(clothes);
				}
			}
		}else if(category.equalsIgnoreCase("Dresses")) {
			for (Clothes clothes : clothes1) {
				if(clothes instanceof Dresses) {
					clothes2.add(clothes);
				}
			}
		}else if(category.equalsIgnoreCase("Swimwear")) {
			for (Clothes clothes : clothes1) {
				if(clothes instanceof SwimWear) {
					clothes2.add(clothes);
				}
			}
		}
		return clothes2;
	}
	
}
