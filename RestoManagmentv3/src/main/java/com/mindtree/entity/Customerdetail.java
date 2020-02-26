package com.mindtree.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Customerdetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookingid;
	private String email;
	private String custname;
	
	private String bookingdate;
	
	@ManyToOne
	@JoinColumn(name = "table_no")
	private Tables tableno;
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}
	public Tables getTableno() {
		return tableno;
	}
	public void setTableno(Tables tableno) {
		this.tableno = tableno;
	}
	
	

}
