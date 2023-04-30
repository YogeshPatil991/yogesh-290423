package com.avisys.cim.service;

import java.util.List;

import com.avisys.cim.pojo.Customer;

public interface CustomerService {

	List<Customer> FetchAllCustomer();

	List<Customer> findByFirstName(String firstName);

	List<Customer> findByLastName(String lastName);

	Customer findByMobileNumber(String mobileNumber);

}
