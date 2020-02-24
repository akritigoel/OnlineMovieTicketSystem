package com.capgemini.onlinemovie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.capgemini.onlinemovie.database.Database;
import com.capgemini.onlinemovie.entities.Seat;
import com.capgemini.onlinemovie.entities.Show;
import com.capgemini.onlinemovie.entities.Theater;
import com.capgemini.onlinemovie.entities.Ticket;

public class CustomerDaoImpl implements CustomerDao {

	Connection connection;
	ResultSet rs;
	Theater th;
	public CustomerDaoImpl() throws SQLException {
		connection=Database.myconnection();
	}
	
	public Theater chooseCity(String city) throws SQLException {
		PreparedStatement pst = connection.prepareStatement("select theaterName from theater where theatercity=?");
		pst.setString(1, city);
		rs = null;
		rs=pst.executeQuery();

		if(rs.next())
		{
		th=null;
		th=new Theater();

		th.setTheaterId(rs.getInt(1));
		th.setTheaterName(rs.getString(2));
		th.setTheaterCity(rs.getString(3));
		th.setManagerName(rs.getString(4));
		th.setManagerContact(rs.getString(5));
		}
		
		return th;
}

	@Override
	public boolean bookMovieTicket(int ticketId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst1=connection.prepareStatement("select ticketId from ticket where ticket.ticketId=? ");
		pst1.setInt(1, ticketId);
		if(pst1 != null) {
		PreparedStatement pst=connection.prepareStatement("select seatStatus from seat where seatId in(select seatId from ticket where ticketid=?)");
		pst.setInt(1,ticketId);
		rs=null;
		rs=pst.executeQuery();
		rs.next();
		//System.out.println(rs.getString(1));
		if(rs.getString(1).equals("booked"))
				return true;
		//return false;
			
	}
	else
		System.out.println("Id does not exist");
		return false;
	}
	@Override
	public boolean cancelMovieTicket(int ticketId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst1=connection.prepareStatement("select ticketId from ticket where seatId in(select seatId from seat where seatStatus='booked')");
		if(pst1==null)
		{
		   	
		}
		PreparedStatement pst=connection.prepareStatement("update seatStatus='available' where seatId in(select seatId from ticket where ticketId=?)");
		pst.setInt(1, ticketId);
		int res=pst.executeUpdate();
		if(res==1)
			return true;
		
		return false;
	}
}
