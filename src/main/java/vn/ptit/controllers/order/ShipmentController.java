package vn.ptit.controllers.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.order.Shipment;
import vn.ptit.repositories.order.ShipmentRepository;

@RestController
@RequestMapping("/rest/api/shipment")
public class ShipmentController {
	@Autowired ShipmentRepository shipmentRepository;
	
	@GetMapping("/find-all")
	public List<Shipment> findAll() {
		return shipmentRepository.findAll();
	}
	
	@GetMapping("/find-one/{id}")
	public Shipment findById(@PathVariable("id") int id) {
		return shipmentRepository.findById(id).get();
	}
}
