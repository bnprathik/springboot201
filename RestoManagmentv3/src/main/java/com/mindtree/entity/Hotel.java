package com.mindtree.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
	
	
	private String city;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int hotelid;
	
	private String hotelname;
	
	private String description;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Tables> table;
	
	
	
	
	
	public List<Tables> getTable() {
		return table;
	}

	public void setTable(List<Tables> table) {
		this.table = table;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getHotelid() {
		return hotelid;
	}

	public Hotel(String city, int hotelid, String hotelname, String description) {
		super();
		this.city = city;
		this.hotelid = hotelid;
		this.hotelname = hotelname;
		this.description = description;
	}

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
