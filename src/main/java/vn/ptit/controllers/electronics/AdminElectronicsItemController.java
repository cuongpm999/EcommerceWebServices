package vn.ptit.controllers.electronics;

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

import vn.ptit.entities.electronics.ElectronicsItem;
import vn.ptit.entities.electronics.ImgElectronicsItem;
import vn.ptit.entities.electronics.Manufacturer;
import vn.ptit.repositories.electronics.ElectronicsItemRepository;
import vn.ptit.repositories.electronics.ImgElectronicsItemRepository;

@RestController
@RequestMapping("/rest/api/electronics-item")
public class AdminElectronicsItemController {
	@Autowired
	ElectronicsItemRepository electronicsItemRepository;
	@Autowired
	ImgElectronicsItemRepository imgElectronicsItemRepository;

	@GetMapping(value = "/find-all")
	public List<ElectronicsItem> findAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		return electronicsItemRepository.findAll();
	}

	@PostMapping(value = "/insert")
	public ElectronicsItem insert(@RequestBody ElectronicsItem electronicsItem, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		
		for (int i = 0; i < electronicsItem.getImgElectronicsItems().size(); i++) {
			electronicsItem.getImgElectronicsItems().get(i).setElectronicsItem(electronicsItem);
		}

		return electronicsItemRepository.save(electronicsItem);
	}

}
