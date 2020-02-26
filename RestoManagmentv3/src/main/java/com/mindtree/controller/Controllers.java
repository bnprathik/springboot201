package com.mindtree.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mindtree.entity.Customerdetail;
import com.mindtree.entity.Hotel;
import com.mindtree.entity.Tables;
import com.mindtree.repo.HotelRepo;
import com.mindtree.repo.TableRepo;
import com.mindtree.service.BookingService;
import com.mindtree.service.HotelService;
import com.mindtree.service.TableService;

@CrossOrigin
@RestController
public class Controllers {
	
	@Autowired
	private HotelService hotelservice;
	
	@Autowired
	private TableService tableservice;
	@Autowired
	private BookingService bookingService;
	
	@Autowired
    private JavaMailSender sender;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/hotels")
	public String addHotel(@RequestBody Hotel hotel){	
	hotelservice.addHotel(hotel);
	return "user";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/hotels/{hotelId}/tables")
	public String addTable(@RequestBody Tables table,@PathVariable String hotelId) {
		table.setHotel(new Hotel("", Integer.parseInt(hotelId), "", ""));
		System.out.println(table.getHotel());
		tableservice.addTable(table);
	return "Adde";}
	
	@RequestMapping(value="/hotel/{city}")
	public List<String> getHotels(@PathVariable String city){	
	hotelservice.getHotel(city);
	return hotelservice.getHotel(city);
	}
	
	
	@RequestMapping(value="/tableno/{hotelname}",produces = "application/json")
	public String getTables(@PathVariable String hotelname){	
	String json = new Gson().toJson(tableservice.gettables(hotelname));
	System.out.println(tableservice.gettables(hotelname));
	return json ;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/hotels/{id}")
	public void updateHotel(@RequestBody Hotel hotel, @PathVariable String id) {
		hotelservice.updateHotel(hotel,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/hotels/{id}")
	public void deleteHotel(@PathVariable String id) {
		hotelservice.deleteHotel(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/booking/{tableno}")
	public String addbooking(@RequestBody Customerdetail customerdetail,@PathVariable String tableno){
		Hotel hotel = new Hotel();
		customerdetail.setTableno(new Tables(Integer.parseInt(tableno), "", "", "", hotel , ""));
		bookingService.addBooking(customerdetail);
		return "Booking Successful";	
	
	}
	
	@RequestMapping("/sendemail/{email}/{name}/{date}/{Table no}")
    @ResponseBody
    String emailhome(@PathVariable String email,@PathVariable String name) {
        try {
        	 MimeMessage message = sender.createMimeMessage();
             MimeMessageHelper helper = new MimeMessageHelper(message);
             
             helper.setTo(email);
             helper.setText(name);
             helper.setSubject("Successfully booked Restaurants");
             
             sender.send(message);
            return "Email Sent!";
        }catch(Exception ex) {
            return "Error in sending email: "+ex;
        }
    }


    }
	
	