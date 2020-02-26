package com.mindtree.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tables {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String numberofseats;
	
	private String status;
	
	private String menu;
	
	@ManyToOne
	@JoinColumn(name = "hotel_hotelid")
	private Hotel hotel;
	
	private String price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumberofseats() {
		return numberofseats;
	}

	public void setNumberofseats(String numberofseats) {
		this.numberofseats = numberofseats;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Tables(int id, String numberofseats, String status, String menu, Hotel hotel, String price) {
		super();
		this.id = id;
		this.numberofseats = numberofseats;
		this.status = status;
		this.menu = menu;
		this.hotel = hotel;
		this.price = price;
	}

	public Tables() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
