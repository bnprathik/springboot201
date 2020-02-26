package com.mindtree.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.entity.Hotel;
import com.mindtree.repo.HotelRepo;


@Service
public class HotelService {
	
	@Autowired
	private HotelRepo hotelRepository;
	
	public List<Hotel> getAllHotels(){
		List<Hotel> hotels = new ArrayList<>();
		hotelRepository.findAll()
		.forEach(hotels::add);
		return hotels;
	}
	
	public List<String> getHotel(String city) {
		return hotelRepository.findResto(city);
	}

	public void addHotel(Hotel hotel) {
		hotelRepository.save(hotel);
	}
	
	public void updateHotel(Hotel hotel, String id) {
		hotelRepository.save(hotel);
	}

	public void deleteHotel(String id) {
		hotelRepository.delete(id);
	}
	
}
