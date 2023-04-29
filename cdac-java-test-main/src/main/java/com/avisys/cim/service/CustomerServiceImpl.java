package com.avisys.cim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.dao.CustomerDao;
import com.avisys.cim.pojo.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	@Override
	public List<Customer> FetchAllCustomer() {
		
		return customerDao.findAll();
	}
	@Override
	public List<Customer> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return customerDao.findByFirstName(firstName);
	}
	@Override
	public List<Customer> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return customerDao.findByLastName(lastName);
	}
	@Override
	public Customer findByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return customerDao.findByMobileNumber(mobileNumber);
	}
	@Override
	public List<Customer> findByRandomSearchTerm(String firstOrLastName) {
		// TODO Auto-generated method stub
		return customerDao.findByRandomSearchTerm(firstOrLastName);
	}
	
	

		
}
