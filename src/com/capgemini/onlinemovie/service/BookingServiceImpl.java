package com.capgemini.onlinemovie.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.capgemini.onlinemovie.dao.BookingDao;
import com.capgemini.onlinemovie.database.Database;
import com.capgemini.onlinemovie.entities.Seat;
import com.capgemini.onlinemovie.exception.BookingException;

public class BookingServiceImpl {

	Connection connection;
	Statement st;
	BookingDao book;
	public BookingServiceImpl() throws SQLException {
		connection=Database.myconnection();
	}
	public String selectSeats1(int noOfSeats) throws SQLException, BookingException{
		List list=null;
		ResultSet rs;
		int c=0;
	    rs=st.executeQuery("select seatId from seat where seatStatus='available'");
		while(rs.next())
			c++;
		
		if(c<noOfSeats)
			throw new BookingException("This much of Seats are not available");
		else
			book.selectSeats(noOfSeats);
		
		return null;
	}
}
