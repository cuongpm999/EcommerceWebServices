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

import vn.ptit.entities.shoes.ShoesItem;
import vn.ptit.repositories.shoes.ShoesItemRepository;

@RestController
@RequestMapping("/rest/api/shoes-item")
public class AdminShoesItemController {

	@Autowired ShoesItemRepository shoesItemRepository;
	
	@GetMapping(value = "/find-all")
	public List<ShoesItem> findAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp){
		return shoesItemRepository.findAll();
	}
	
	@PostMapping(value = "/insert")
	public ShoesItem insert(@RequestBody ShoesItem shoesItem, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		for(int i=0;i<shoesItem.getImgShoesItems().size();i++) {
			shoesItem.getImgShoesItems().get(i).setShoesItem(shoesItem);
		}
		return shoesItemRepository.save(shoesItem);
	}
}
