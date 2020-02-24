package com.capgemini.onlinemovie.entities;

import java.time.LocalDate;
import java.util.Arrays;

public class Booking {

	private int bookingId;
	private int movieId;
	private int showId;
	LocalDate bookingDate;
	private int transactionId;
	private double totalcost;
	Seat[] seatList;
	Ticket ticket;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public double getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	public Seat[] getSeatList() {
		return seatList;
	}
	public void setSeatList(Seat[] seatList) {
		this.seatList = seatList;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", movieId=" + movieId + ", showId=" + showId + ", bookingDate="
				+ bookingDate + ", transactionId=" + transactionId + ", totalcost=" + totalcost + ", seatList="
				+ Arrays.toString(seatList) + ", ticket=" + ticket + "]";
	}
	public Booking(int bookingId, int movieId, int showId, LocalDate bookingDate, int transactionId, double totalcost,
			Seat[] seatList, Ticket ticket) {
		super();
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.showId = showId;
		this.bookingDate = bookingDate;
		this.transactionId = transactionId;
		this.totalcost = totalcost;
		this.seatList = seatList;
		this.ticket = ticket;
	}
	
	
}
