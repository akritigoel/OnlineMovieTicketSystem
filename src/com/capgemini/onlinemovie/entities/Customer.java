package com.capgemini.onlinemovie.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import com.capgemini.onlinemovie.*;

public class Customer {

	private int userID;
	private String customerName;
	private String password;
	private Date dateofBirth;
	Ticket[] myTickets;
	private String customerContact;
	
	
	public Customer(int userID, String customerName, String password, Date dateofBirth, Ticket[] myTickets,
			String customerContact) {
		super();
		this.userID = userID;
		this.customerName = customerName;
		this.password = password;
		this.dateofBirth = dateofBirth;
		this.myTickets = myTickets;
		this.customerContact = customerContact;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public Ticket[] getMyTickets() {
		return myTickets;
	}
	public void setMyTickets(Ticket[] myTickets) {
		this.myTickets = myTickets;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	
	/*public boolean bookMovieTicket(Theater th) {
		if(th.searchMovie()) {
			
		}
	}*/
	
	
}