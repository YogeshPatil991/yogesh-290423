package com.avisys.cim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.dao.CustomerDao;
import com.avisys.cim.dao.MobileNumberDao;
import com.avisys.cim.dto.RequestUpdateCustomer;
import com.avisys.cim.pojo.Customer;
import com.avisys.cim.pojo.MobileNumber;

@Service
public class MobileServiceImpl implements MobileService {

	@Autowired
	private MobileNumberDao mobileNumberDao;
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public String updateMobileNumber(RequestUpdateCustomer requestUpdateCustomer) {
		String mes="Please Enter Valid Customer Id";
		Customer customer = customerDao.findById(requestUpdateCustomer.getId()).get();
		System.out.println(customer.getId());
		MobileNumber mobileNumber=new MobileNumber();
		if(customer!=null) {
			List<MobileNumber> mobileNumberlist=mobileNumberDao.findByMobileNumber(customer.getId());
			System.out.println(mobileNumberlist.get(0).getNumber());
			mobileNumber.setId(mobileNumberlist.get(0).getId());
			mobileNumber.setNumber(requestUpdateCustomer.getNumber());
			mobileNumber.setCustomer(mobileNumberlist.get(0).getCustomer());
			mobileNumberDao.save(mobileNumber);
			mes="Update Mobile Number Successfully";
		}
		return mes;
	}
	
	
}
