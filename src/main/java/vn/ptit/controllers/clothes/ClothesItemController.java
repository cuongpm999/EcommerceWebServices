package vn.ptit.controllers.clothes;

import java.util.ArrayList;
import java.util.List;

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

import vn.ptit.repositories.clothes.ClothesItemRepository;
import vn.ptit.services.ClothesService;
import vn.ptit.utils.FilterMap;
import vn.ptit.entities.clothes.*;

@RestController
@RequestMapping("/rest/api/clothes-item")
public class ClothesItemController {
	@Autowired
	ClothesItemRepository clothesItemRepository;
	@Autowired
	ClothesService clothesService;

	@GetMapping(value = "/find-all")
	public List<ClothesItem> findAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return clothesItemRepository.findAll();
	}

	@PostMapping(value = "/find-all-in-category")
	public List<ClothesItem> findAllInCategory(@RequestBody List<FilterMap> filterMap, ModelMap model,
			HttpServletRequest req, HttpServletResponse resp) {

		return clothesService.findByCategory(filterMap);
	}

	@GetMapping(value = "/{slug}")
	public ClothesItem getClothesItemBySlug1(@PathVariable("slug") String slug) {
		return clothesService.getClothesItemBySlug(slug).get(0);
	}

	@GetMapping(value = "/get-4-clothes-item/{slug}")
	public List<ClothesItem> get4ClothesItemBySlug(@PathVariable("slug") String slug) {
		return clothesService.get4ClothesItemBySlug(slug);
	}

	@GetMapping(value = "/get-8-clothes-item")
	public List<ClothesItem> get8ClothesItemInHome() {
		return clothesService.get8ClothesItemInHome();
	}

	@GetMapping(value = "/find-by-name/{name}")
	public List<ClothesItem> getClothesItemByName(@PathVariable("name") String name) {
		return clothesService.findByName(name);
	}

	@PostMapping(value = "/find-by-category")
	public List<ClothesItem> filterByCategory(@RequestBody List<FilterMap> filterMap) {
		List<ClothesItem> clothesItems = clothesService.findItemByCategory(filterMap);
		List<ClothesItem> itemByCategory = new ArrayList<>();
		if (filterMap.get(0).getValue().equalsIgnoreCase("jeans")) {
			for (ClothesItem clothesItem : clothesItems) {
				if (clothesItem.getClothes() instanceof Jeans) {
					itemByCategory.add(clothesItem);
				}
			}
		} else if (filterMap.get(0).getValue().equalsIgnoreCase("dresses")) {
			for (ClothesItem clothesItem : clothesItems) {
				if (clothesItem.getClothes() instanceof Dresses) {
					itemByCategory.add(clothesItem);
				}
			}
		} else if (filterMap.get(0).getValue().equalsIgnoreCase("swimwear")) {
			for (ClothesItem clothesItem : clothesItems) {
				if (clothesItem.getClothes() instanceof SwimWear) {
					itemByCategory.add(clothesItem);
				}
			}
		}
		return itemByCategory;
	}

	@PostMapping(value = "/insert")
	public ClothesItem insert(@RequestBody ClothesItem clothesItem, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		for (int i = 0; i < clothesItem.getImgClothesItems().size(); i++) {
			clothesItem.getImgClothesItems().get(i).setClothesItem(clothesItem);
		}
		return clothesItemRepository.save(clothesItem);
	}

	@GetMapping(value = "/delete-by-code/{code}")
	public Integer deleteByCode(@PathVariable("code") String code) {
		clothesItemRepository.deleteById(code);
		return 1;
	}

	@GetMapping(value = "/find-by-code/{code}")
	public ClothesItem findByCode(@PathVariable("code") String code) {
		return clothesItemRepository.findById(code).get();

	}

	@PostMapping(value = "/update")
	public ClothesItem update(@RequestBody ClothesItem clothesItem, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {

		return clothesItemRepository.save(clothesItem);
	}
}
