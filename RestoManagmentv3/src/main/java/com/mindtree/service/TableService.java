package com.mindtree.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.entity.Tables;
import com.mindtree.repo.TableRepo;


@Service
public class TableService {

	@Autowired
	private TableRepo tableRepository;
	
	/*public List<Table> getAllTables(String hotelId){
		List<Table> tables = new ArrayList<>();
		tableRepository.findByhotel(hotelId)
		.forEach(tables::add);
		return tables;
	}
*/	
	public Tables getTable(String id) {
		return tableRepository.findOne(id);
	}

	public void addTable(Tables table) {
		tableRepository.save(table);
	}
	
	public void updateTable(Tables table) {
		tableRepository.save(table);
	}

	public void deleteTable(String id) {
		tableRepository.delete(id);
	}

	public String calculateTotalPrice(String price, String numberOfSeats) {
		int pricePerPlate = Integer.parseInt(price);
		int totalSeats = Integer.parseInt(numberOfSeats);
		int totalPrice = (pricePerPlate * totalSeats);
		String finalPrice = String.valueOf(totalPrice);
		return finalPrice;
	}
	
	public List gettables(String hotelname){
	
	
		return tableRepository.findtables(hotelname);
	}

}
