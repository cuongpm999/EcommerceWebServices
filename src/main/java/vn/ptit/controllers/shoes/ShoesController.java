package vn.ptit.controllers.shoes;

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
public class ShoesController {
	@Autowired ShoesRepository shoesRepository;
	@Autowired SneakerRepository sneakerRepository;
	@Autowired BootsRepository bootsRepository;
	@Autowired HighHeelsRepository highHeelsRepository;
	
	@GetMapping(value = "/find-all")
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
	
	@GetMapping(value = "/boots/{id}")
	public Boots findBootsById(@PathVariable("id") int id) {
		Optional<Boots> optBoots = bootsRepository.findById(id);
		if(optBoots.isPresent()) {
			return optBoots.get();
		}
		return null;
	}
	
	@GetMapping(value = "/sneaker/{id}")
	public Sneaker findSneakerById(@PathVariable("id") int id) {
		Optional<Sneaker> optSneaker = sneakerRepository.findById(id);
		if(optSneaker.isPresent()) {
			return optSneaker.get();
		}
		return null;
	}
	
	@GetMapping(value = "/highheels/{id}")
	public HighHeels findHighHeelsById(@PathVariable("id") int id) {
		Optional<HighHeels> optHighHeels = highHeelsRepository.findById(id);
		if(optHighHeels.isPresent()) {
			return optHighHeels.get();
		}
		return null;
	}
	
	@GetMapping("/find-by-category/{category}")
	public List<Shoes> findShoesByCategory(@PathVariable String category) {
		List<Shoes> shoes1 = shoesRepository.findAll();
		List<Shoes> shoes2 = new ArrayList<>();
		if (category.equalsIgnoreCase("HighHeels")) {
			for (Shoes shoes : shoes1) {
				if(shoes instanceof HighHeels) {
					shoes2.add(shoes);
				}
			}
		}else if(category.equalsIgnoreCase("Sneaker")) {
			for (Shoes shoes : shoes1) {
				if(shoes instanceof Sneaker) {
					shoes2.add(shoes);
				}
			}
		}else if(category.equalsIgnoreCase("Boots")) {
			for (Shoes shoes : shoes1) {
				if(shoes instanceof Boots) {
					shoes2.add(shoes);
				}
			}
		}
		return shoes2;
	}
	
	// update delete 
		@GetMapping(value = "/boots/find-by-id/{id}")
		public Boots findByIdBoots(@PathVariable("id") int id) {

			return bootsRepository.findById(id).get();
		}
		
		@GetMapping(value = "/boots/delete-by-id/{id}")
		public Integer deleteByIdBoots(@PathVariable("id") int id) {
			bootsRepository.deleteById(id);
			return 1;
		}
		
		@GetMapping(value = "/sneaker/find-by-id/{id}")
		public Sneaker findByIdSneaker(@PathVariable("id") int id) {

			return sneakerRepository.findById(id).get();
		}
		
		@GetMapping(value = "/sneaker/delete-by-id/{id}")
		public Integer deleteByIdSneaker(@PathVariable("id") int id) {
			sneakerRepository.deleteById(id);
			return 1;
		}
		
		@GetMapping(value = "/highheels/find-by-id/{id}")
		public HighHeels findByIdHighheels(@PathVariable("id") int id) {

			return highHeelsRepository.findById(id).get();
		}
		
		@GetMapping(value = "/highheels/delete-by-id/{id}")
		public Integer deleteByIdHighheels(@PathVariable("id") int id) {
			highHeelsRepository.deleteById(id);
			return 1;
		}
}
