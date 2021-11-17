package vn.ptit.controllers.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.employee.TotalVisit;
import vn.ptit.repositories.employee.TotalVisitRepository;

@RestController
@RequestMapping("/rest/api/statistic")
public class TotalVisitController {
	@Autowired TotalVisitRepository totalVisitRepository;
	
	@PostMapping("/add-total-visit")
	public TotalVisit insert(@RequestBody TotalVisit totalVisit) {
		return totalVisitRepository.save(totalVisit);
		
	}
	
	@GetMapping("/total-visit")
	public Integer find() {
		return totalVisitRepository.findAll().size();
		
	}
}
