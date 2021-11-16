package vn.ptit.controllers.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.customer.CustomerMember;
import vn.ptit.entities.customer.CustomerNew;
import vn.ptit.entities.electronics.ElectronicsItem;
import vn.ptit.entities.order.Cash;
import vn.ptit.entities.order.Credit;
import vn.ptit.entities.order.DigitalWallet;
import vn.ptit.entities.order.LineBookItem;
import vn.ptit.entities.order.LineClothesItem;
import vn.ptit.entities.order.LineElectronicsItem;
import vn.ptit.entities.order.LineShoesItem;
import vn.ptit.entities.order.Order;
import vn.ptit.entities.order.ShoppingCart;
import vn.ptit.repositories.CustomerMemberRepository;
import vn.ptit.repositories.CustomerNewRepository;
import vn.ptit.repositories.order.CartRepository;
import vn.ptit.repositories.order.CashRepository;
import vn.ptit.repositories.order.CreditRepository;
import vn.ptit.repositories.order.DigitalWalletRepository;
import vn.ptit.repositories.order.OrderRepository;
import vn.ptit.services.OrderService;
import vn.ptit.utils.HelperOrder;

@RestController
@RequestMapping("/rest/api/order")
public class OrderController {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CustomerNewRepository customerNewRepository;
	@Autowired CustomerMemberRepository customerMemberRepository;
	@Autowired
	CartRepository cartRepository;
	@Autowired CashRepository cashRepository;
	@Autowired CreditRepository creditRepository;
	@Autowired DigitalWalletRepository digitalWalletRepository;
	@Autowired OrderService orderService;

	@PostMapping(value = "/insert")
	@Transactional
	public Order insert(@RequestBody HelperOrder helperOrder) {

		Order order = helperOrder.getOrder();
		if (order.getShoppingCart().getLineBookItems() != null) {
			for (LineBookItem lineBookItem : order.getShoppingCart().getLineBookItems()) {
				lineBookItem.setShoppingCart(order.getShoppingCart());
			}
		}
		if (order.getShoppingCart().getLineClothesItems() != null) {
			for (LineClothesItem lineClothesItem : order.getShoppingCart().getLineClothesItems()) {
				lineClothesItem.setShoppingCart(order.getShoppingCart());
			}
		}
		if (order.getShoppingCart().getLineElectronicsItems() != null) {
			for (LineElectronicsItem lineElectronicsItem : order.getShoppingCart().getLineElectronicsItems()) {
				lineElectronicsItem.setShoppingCart(order.getShoppingCart());
			}
		}
		if (order.getShoppingCart().getLineShoesItems() != null) {
			for (LineShoesItem lineShoesItem : order.getShoppingCart().getLineShoesItems()) {
				lineShoesItem.setShoppingCart(order.getShoppingCart());
			}
		}

		ShoppingCart shoppingCart = cartRepository.save(order.getShoppingCart());
		order.setShoppingCart(shoppingCart);
		
		if(helperOrder.getCustomerMember()!=null) {
			order.setCustomer(helperOrder.getCustomerMember());
			CustomerMember customerMember = helperOrder.getCustomerMember();
			customerMemberRepository.save(customerMember);
		}
		if(helperOrder.getCustomerNew()!=null) {
			CustomerNew customerNew = helperOrder.getCustomerNew();
			customerNew.addAddress(helperOrder.getCustomerNew().getAddress());
			customerNew.addFullName(helperOrder.getCustomerNew().getFullName());			
			customerNew = customerNewRepository.save(customerNew);
			order.setCustomer(customerNew);
		}
		
		if(helperOrder.getCash()!=null) {
			Cash cash = new Cash();
			cash = helperOrder.getCash();
			cash = cashRepository.save(cash);
			order.setPayment(cash);
		}
		
		if(helperOrder.getCredit()!=null) {
			Credit credit = new Credit();
			credit = helperOrder.getCredit();
			credit = creditRepository.save(credit);
			order.setPayment(credit);
		}
		
		if(helperOrder.getDigitalWallet()!=null) {
			DigitalWallet digitalWallet = new DigitalWallet();
			digitalWallet = helperOrder.getDigitalWallet();
			digitalWallet = digitalWalletRepository.save(digitalWallet);
			order.setPayment(digitalWallet);
		}
		
		System.out.println(order.toString());
		
		return orderRepository.save(order);
	}
	
	@GetMapping("/get-order-by-customer/{idCustomer}")
	public List<Order> viewOrderByCustomer(@PathVariable("idCustomer") int idCustomer){
		return orderService.getOrderByIdCustomer(idCustomer);
	}
	
	@PostMapping("/change-status")
	public Order changeStatus(@RequestBody String status) {
		String[] datas = status.split(";");
		int id = Integer.parseInt(datas[0]);
		String statusOrder = null;
		if(datas[1].equalsIgnoreCase("cancel")) {
			statusOrder = "Đã hủy";
		}
		Order order = orderRepository.findById(id).get();
		order.setStatus(statusOrder);
		return orderRepository.save(order);
	}
	
	@GetMapping("/find-all")
	public List<Order> findAll(){
		return orderRepository.findAll();
	}

}
