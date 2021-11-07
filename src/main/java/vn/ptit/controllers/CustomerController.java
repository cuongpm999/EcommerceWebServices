package vn.ptit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.customer.Account;
import vn.ptit.entities.customer.CustomerMember;
import vn.ptit.repositories.CustomerMemberRepository;
import vn.ptit.services.CustomerService;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerController {
	@Autowired
	CustomerMemberRepository customerMemberRepository;
	@Autowired
	CustomerService customerService;

	@PostMapping(value = "/register")
	public CustomerMember register(@RequestBody CustomerMember customerMember) {
		customerMember.addAccount(customerMember.getAccount());
		customerMember.addAddress(customerMember.getAddress());
		customerMember.addFullName(customerMember.getFullName());
		if (customerService.getCustomerMemberByAccount(customerMember.getAccount()) == null) {
			return customerMemberRepository.save(customerMember);
		} else {
			return null;
		}
	}

	@PostMapping(value = "/login")
	public CustomerMember login(@RequestBody Account account) {
		return customerService.getCustomerMemberByAccount(account);
	}
}
