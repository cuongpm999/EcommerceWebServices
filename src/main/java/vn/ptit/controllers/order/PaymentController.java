package vn.ptit.controllers.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.order.Order;
import vn.ptit.entities.order.Payment;
import vn.ptit.repositories.order.PaymentRepository;
import vn.ptit.services.OrderService;

@RestController
@RequestMapping("/rest/api/payment")
public class PaymentController {
	@Autowired PaymentRepository paymentRepository;
	@Autowired OrderService orderService;
	
	@GetMapping("/total-revenue")
	public Double totalRevenue(){
		List<Order> orders = orderService.getOrderByStatus();
		double totalMoney = 0;
		for (Order order : orders) {
			totalMoney+=order.getPayment().getTotalMoney();
		}
		return totalMoney;
	}
	
}
