package vn.ptit.controllers.electronics;

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

import vn.ptit.entities.electronics.ElectronicsItem;
import vn.ptit.entities.electronics.ImgElectronicsItem;
import vn.ptit.entities.electronics.Laptop;
import vn.ptit.entities.electronics.Tivi;
import vn.ptit.entities.electronics.MobilePhone;
import vn.ptit.entities.electronics.Manufacturer;
import vn.ptit.repositories.electronics.ElectronicsItemRepository;
import vn.ptit.repositories.electronics.ImgElectronicsItemRepository;
import vn.ptit.services.ElectronicsService;
import vn.ptit.utils.FilterMap;

@RestController
@RequestMapping("/rest/api/electronics-item")
public class AdminElectronicsItemController {
	@Autowired
	ElectronicsItemRepository electronicsItemRepository;
	@Autowired
	ImgElectronicsItemRepository imgElectronicsItemRepository;
	@Autowired
	ElectronicsService electronicsService;

	@PostMapping(value = "/find-all-in-category")
	public List<ElectronicsItem> findAllInCategory(@RequestBody List<FilterMap> filterMap, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {

		return electronicsService.findByCategory(filterMap);
	}

	@PostMapping(value = "/insert")
	public ElectronicsItem insert(@RequestBody ElectronicsItem electronicsItem, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {

		for (int i = 0; i < electronicsItem.getImgElectronicsItems().size(); i++) {
			electronicsItem.getImgElectronicsItems().get(i).setElectronicsItem(electronicsItem);
		}

		return electronicsItemRepository.save(electronicsItem);
	}

	@PostMapping(value = "/find-by-category")
	public List<ElectronicsItem> filterByCategory(@RequestBody List<FilterMap> filterMap, ModelMap model,
			HttpServletRequest req, HttpServletResponse resp) {
		List<ElectronicsItem> electronicsItems = electronicsService.findByCategory(filterMap);
		List<ElectronicsItem> itemByCategory = new ArrayList<>();
		if (filterMap.get(0).getValue().equalsIgnoreCase("laptop")) {
			for (ElectronicsItem electronicsItem : electronicsItems) {
				if (electronicsItem.getElectronics() instanceof Laptop) {
					itemByCategory.add(electronicsItem);
				}
			}
		}
		else if (filterMap.get(0).getValue().equalsIgnoreCase("tivi")) {
			for (ElectronicsItem electronicsItem : electronicsItems) {
				if (electronicsItem.getElectronics() instanceof Tivi) {
					itemByCategory.add(electronicsItem);
				}
			}
		}
		else if (filterMap.get(0).getValue().equalsIgnoreCase("mobile-phone")) {
			for (ElectronicsItem electronicsItem : electronicsItems) {
				if (electronicsItem.getElectronics() instanceof MobilePhone) {
					itemByCategory.add(electronicsItem);
				}
			}
		}
		return itemByCategory;
	}
	
	@PostMapping(value = "/find-by-manufacturer")
	public List<ElectronicsItem> findByManufacturer(@RequestBody List<FilterMap> filterMap, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {

		return electronicsService.findByManufacturer(filterMap);
	}
	
	@GetMapping(value = "/find-all")
	public List<ElectronicsItem> findAllInHome(ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {

		return electronicsItemRepository.findAll();
	}
	
	@GetMapping(value = "/{slug}")
	public ElectronicsItem getElectronicsItemBySlug(@PathVariable("slug") String slug, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		
		return electronicsService.getElectronicsItemBySlug(slug).get(0);
	}
	
	@GetMapping(value = "/same-item/{slug}")
	public List<ElectronicsItem> getSameElectronicsItem(@PathVariable("slug") String slug, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		
		return electronicsService.getSameElectronicsItem(slug);
	}


}
