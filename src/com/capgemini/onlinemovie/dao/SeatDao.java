package com.capgemini.onlinemovie.dao;



public interface SeatDao {

	public BookingState blockSeat();
	public BookingState bookSeat();
	public BookingState cancelSeat();
}
