package com.capgemini.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.CustomerDetailsDao;
import com.capgemini.entity.CustomerDetails;

@Service
public class CustomerDetailsService {
	
	@Autowired
	private CustomerDetailsDao customerdetailsdao;
	
	@Transactional
	public CustomerDetails addcustomerdetails(CustomerDetails customerdetails) {
		return customerdetailsdao.save(customerdetails);
	}

}
