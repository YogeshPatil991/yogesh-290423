package com.avisys.cim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.dao.CustomerDao;
import com.avisys.cim.pojo.Customer;

@Service()
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> FetchAllCustomer() {

		return customerDao.findAll();
	}

	@Override
	public List<Customer> findByFirstName(String firstName) {

		return customerDao.findByFirstName(firstName);
	}

	@Override
	public List<Customer> findByLastName(String lastName) {

		return customerDao.findByLastName(lastName);
	}

	@Override
	public Customer findByMobileNumber(String mobileNumber) {

		return customerDao.findByMobileNumber(mobileNumber);
	}

}
