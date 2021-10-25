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

import vn.ptit.repositories.clothes.ClothesItemRepository;
import vn.ptit.entities.clothes.ClothesItem;

@RestController
@RequestMapping("/rest/api/clothes-item")
public class AdminClothesItemController {
	@Autowired ClothesItemRepository clothesItemRepository;
	
	@GetMapping(value = "/find-all")
	public List<ClothesItem> findAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp){
		return clothesItemRepository.findAll();
	}
	
	@PostMapping(value = "/insert")
	public ClothesItem insert(@RequestBody ClothesItem clothesItem, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		for(int i=0;i<clothesItem.getImgClothesItems().size();i++) {
			clothesItem.getImgClothesItems().get(i).setClothesItem(clothesItem);
		}
		return clothesItemRepository.save(clothesItem);
	}
}
