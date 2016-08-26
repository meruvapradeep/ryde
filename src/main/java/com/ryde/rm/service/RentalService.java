package com.ryde.rm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ryde.cm.domain.Customer;
import com.ryde.cm.service.CustomerService;
import com.ryde.repository.VehicleRepository;
import com.ryde.rm.domain.Payment;
import com.ryde.rm.domain.Rental;
import com.ryde.rm.repository.PaymentRepository;
import com.ryde.rm.repository.RentalRepository;

@Service
public class RentalService {
	
	
	@Resource
	private RentalRepository rentalRepository;
	
	@Resource
	private PaymentRepository paymentRepository;
	
	@Resource
	private CustomerService customerService;
	
	@Resource
	private VehicleRepository vehicleRepository;

	public Rental createRental(Rental rental) {
		
		
		Customer customer1 = customerService.saveCustomer(rental.getCustomer1());
		Customer customer2 = customerService.saveCustomer(rental.getCustomer2());
				
		rental.setCustomer1(customer1);
		rental.setCustomer2(customer2);
		
		
		Payment payment = paymentRepository.saveAndFlush(rental.getPayment());
		rental.setPayment(payment);
		
		
		
		
		return rentalRepository.saveAndFlush(rental);
	}

	public void updateRental(Rental rental) {

	}

	public void fetchRental(Rental rental) {
	
	}
	
	
	public List<Rental> getRentals(){
		return rentalRepository.findAll();
		
	}
	
	

}
