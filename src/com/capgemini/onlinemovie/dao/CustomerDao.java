package com.capgemini.onlinemovie.dao;


import java.sql.SQLException;
import java.util.List;

import com.capgemini.onlinemovie.entities.Theater;
import com.capgemini.onlinemovie.entities.Ticket;

public interface CustomerDao {

	public Theater chooseCity(String city) throws SQLException;
	public boolean bookMovieTicket(int ticketId) throws SQLException;
	
	public boolean cancelMovieTicket(int ticketId) throws SQLException;
}
