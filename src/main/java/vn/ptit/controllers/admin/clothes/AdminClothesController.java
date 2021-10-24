package vn.ptit.controllers.admin.clothes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.ptit.entities.clothes.Clothes;
import vn.ptit.repositories.clothes.ClothesRepository;

@Controller
@RequestMapping("/rest/api/clothes")
public class AdminClothesController {
	@Autowired ClothesRepository clothesRepository;
	
	@GetMapping(value = "/find-all")
	public List<Clothes> findAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp){
		return clothesRepository.findAll();
	}
}
