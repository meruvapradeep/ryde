package com.ryde.cm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ryde.cm.domain.Customer;
import com.ryde.cm.repository.CustomerRepository;


@Service
public class CustomerService {

	@Resource
	private CustomerRepository customerRepository;
	
	
	
 public List<Customer> getCustomers(){
	 return customerRepository.findAll();
	 
 }
 
 public Customer saveCustomer(Customer customer) {
	 if(customer != null){
	 return customerRepository.saveAndFlush(customer);
	 }else{
		 return null;
	 }
}
	
	
}
