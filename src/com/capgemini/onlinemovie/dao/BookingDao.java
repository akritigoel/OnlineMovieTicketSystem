package com.capgemini.onlinemovie.dao;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.onlinemovie.entities.Seat;
import com.capgemini.onlinemovie.entities.Ticket;

public interface BookingDao {

	public List<Seat> chooseSeats() throws SQLException;
	public List<Seat> selectSeats(int no) throws SQLException;
	public double calculateTotalCost() throws SQLException;
	public String choosePaymentMethod(String mode);
	public boolean makePayment(String s, double d) throws SQLException;
	public Ticket showTicket() throws SQLException;
	public boolean cancelBookings(List<Seat> seats1) throws SQLException;
	
}
