package com.mindtree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindtree.entity.User;
import com.mindtree.repo.UserRepo;

@Service
public class CustomerService implements UserDetailsService {
	@Autowired
	private UserRepo  customerRepo;
	
	public void addCust(User customer) {
		customerRepo.save(customer);
	}
	@SuppressWarnings("rawtypes")
	public List<User> findCust() {
		return customerRepo.findAll();
	}
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
