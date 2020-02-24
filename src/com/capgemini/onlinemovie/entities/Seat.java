package com.capgemini.onlinemovie.entities;

public class Seat {

	private int seatId;
	private static String seatStatus;
	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatPrice=" + seatPrice + "]";
	}

	{
		//booked,available,blocked;
	}
	private double seatPrice  ;
	
	public int getSeatId() {
		return seatId;
	}
	public double getSeatPrice() {
		return seatPrice;
	}
	public static String getseatStatus() {
		return seatStatus;
	}
	public void setSeatId(int seatId) {
		this.seatId= seatId;
	}
	
	public void setSeatStatus(String seatStatus) {
		this.seatStatus=seatStatus;
	}
	
	public void setSeatPrice(double seatPrice) {
		this.seatPrice= seatPrice;
	}
	
	
	
}
