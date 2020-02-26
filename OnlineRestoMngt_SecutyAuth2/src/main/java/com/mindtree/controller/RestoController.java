package com.mindtree.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.entity.Cart;
import com.mindtree.entity.Product;
import com.mindtree.entity.User;
import com.mindtree.repo.CartRepo;
import com.mindtree.repo.ProductRepo;
import com.mindtree.repo.UserRepo;
import com.mindtree.service.CustomerService;

@RestController
public class RestoController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private UserRepo userrepo;

	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private ProductRepo productRepo;

	@RequestMapping("/test")
	public String test() {
		try {
			Cart cart = new Cart();
			User user = new User();
			user.setId(1);
			cart.setUser(user);
			//cartRepo.save(cart);
			Example<Cart> ex = Example.of(cart);
			List<Cart> cl = cartRepo.findAll(ex);
			System.out.println(cl.size());
		} catch (Exception e) {
			System.out.println(e);
		}
		return "success";
	}

	@RequestMapping("/")
	public ModelAndView home1() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/home");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/signupcustom")
	public String addHotel(@RequestBody User customer) {
		customerService.addCust(customer);
		;
		return "Customer Added";
	}

	@RequestMapping("/Payment")
	public ModelAndView bookingcompleted() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/Payment");
		return modelAndView;
	}

	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/home");
		return modelAndView;
	}

	@RequestMapping("/admin")
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin");
		return modelAndView;
	}

	@RequestMapping("/user")
	public ModelAndView user() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user");
		return modelAndView;
	}

	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup");
		return modelAndView;
	}

	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/about");
		return modelAndView;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/login");
		return modelAndView;
	}

	@RequestMapping("/403")
	public ModelAndView error403() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error/403");
		return modelAndView;
	}

}
