package com.avisys.cim.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.dto.RequestCustomer;
import com.avisys.cim.pojo.Customer;
import com.avisys.cim.service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/fetchAll")
	public ResponseEntity<?> FetchAllCustomer() {
		List<Customer> customers = new ArrayList<Customer>();
		customers = customerService.FetchAllCustomer();
		if (customers == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@GetMapping("/firstName")
	public ResponseEntity<?> findByFirstName(@RequestParam(value = "firstName") String firstName) {
		List<Customer> customers = customerService.findByFirstName(firstName);
		if (customers == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@GetMapping("/lastName")
	public ResponseEntity<?> findByLastName(@RequestParam(value = "lastName") String lastName) {
		List<Customer> customers = customerService.findByLastName(lastName);
		if (customers == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@GetMapping("/mobileNumber")
	public ResponseEntity<?> findByMobileNumber(@RequestParam(value = "mobileNumber") String mobileNumber) {
		Customer customer = customerService.findByMobileNumber(mobileNumber);
		if (customer == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PostMapping("/addWithMultipleMobileNumber")
	public ResponseEntity<?> insertCustomerWithMultipleMobileNumbers(@RequestBody RequestCustomer customer) {

		String message = customerService.insertCustomerWithMultipleMobileNumbers(customer);

		return new ResponseEntity(message, HttpStatus.OK);
	}

	@GetMapping("/delete")
	public ResponseEntity<?> deleteCustomerByMobileNumber(@RequestParam(value = "mobileNumber") String mobileNumber) {
		Customer customer = customerService.findByMobileNumber(mobileNumber);
		String message = "Enter Valid Mobile Number";
		if (customer != null) {
			message = customerService.deleteCustomerByMobileNumber(customer.getId());
			return new ResponseEntity(message, HttpStatus.OK);
		}
		return new ResponseEntity(message, HttpStatus.NOT_FOUND);
	}

}
