package com.capgemini.onlinemovie.dao;


import com.capgemini.onlinemovie.entities.Seat;

public class SeatDaoImpl implements SeatDao{

	@Override
	public BookingState blockSeat() {
		// TODO Auto-generated method stub
		
		BookingState s=BookingState.blocked;
		return s;
	}

	@Override
	public BookingState bookSeat() {
		// TODO Auto-generated method stub
		BookingState s1=BookingState.booked;
		return s1;
	}

	@Override
	public BookingState cancelSeat() {
		// TODO Auto-generated method stub
		BookingState s2=BookingState.available;
		
		return s2;
	}

	
}
