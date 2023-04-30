package com.avisys.cim.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.dao.CustomerDao;
import com.avisys.cim.dao.MobileNumberDao;
import com.avisys.cim.dto.RequestCustomer;
import com.avisys.cim.pojo.Customer;
import com.avisys.cim.pojo.MobileNumber;

@Service()
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	private MobileNumberDao mobileNumberDao;

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

	@Override
	public String insertCustomerWithMultipleMobileNumbers(RequestCustomer customerRequest) {

		Customer customer = new Customer();
		customer.setFirstName(customerRequest.getFirstName());
		customer.setLastName(customerRequest.getLastName());
		customer = customerDao.save(customer);

		List<MobileNumber> mobileList = new ArrayList<MobileNumber>();
		if (customerRequest.getRequestMobille() != null) {
			for (MobileNumber mobileNumber1 : mobileList) {
				MobileNumber mobileNumber = new MobileNumber();
				mobileNumber.setNumber(mobileNumber1.getNumber());
				mobileNumber.setCustomer(customer);

				mobileList.add(mobileNumber);
			}
			mobileNumberDao.saveAll(mobileList);
		}

		return "Customer Added successfully With Multiple Mobile Number";
	}

}
