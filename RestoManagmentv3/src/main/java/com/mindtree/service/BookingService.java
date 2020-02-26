package com.mindtree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.entity.Customerdetail;
import com.mindtree.repo.BookingRepo;



@Service
public class BookingService {

	@Autowired
	private BookingRepo bookingRepo;
	
	public void addBooking(Customerdetail customerdetail){
		bookingRepo.save(customerdetail);
	}
}
