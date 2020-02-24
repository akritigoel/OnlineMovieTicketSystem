package com.capgemini.onlinemovie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.capgemini.onlinemovie.database.Database;
import com.capgemini.onlinemovie.entities.Seat;
import com.capgemini.onlinemovie.entities.Ticket;

public class BookingDaoImpl implements BookingDao {
	Scanner sc = new Scanner(System.in);
	Connection connection;
	Statement st;
	ResultSet rs, rs1;
	PreparedStatement pst, pst1;
	List<Seat> list;
	Seat seat;

	public BookingDaoImpl() throws SQLException {
		connection = Database.myconnection();
		//connection.setAutoCommit(false);
	}

	@Override
	public List<Seat> chooseSeats() throws SQLException {
		if (connection == null)
			System.out.println("Not connected");
		st = connection.createStatement();
		list = new ArrayList<>();
		rs = st.executeQuery("select * from seat where seatStatus= 'available'");
		while (rs.next()) {
			Seat seat = null;
			seat = new Seat();
			seat.setSeatId(rs.getInt(1));
			seat.setSeatStatus(rs.getString(2));
			seat.setSeatPrice(rs.getDouble(3));

			list.add(seat);
		}

		return list;
	}

	List<Seat> list2 = null;

	public List<Seat> selectSeats(int noOfSeats) throws SQLException {
		list2 = new ArrayList<>();
		int c=0;
		rs = st.executeQuery("select seatId from seat where seatStatus='available'");
		   
		int seat_ar[] = new int[noOfSeats];
		int x = 0;
          
		while (rs.next()) {
			
			seat_ar[x++] = rs.getInt(1);
			if (x == noOfSeats)
				break;
		}
		//System.out.println("Ids updated are.......... " + Arrays.toString(seat_ar));
		//System.out.println("seat available " + x);
		noOfSeats = x;
		x = 0;
          while (noOfSeats != 0) {
			// while(rs.next())
			// seat.setSeatStatus("booked");
			pst = connection.prepareStatement("update seat set seatStatus='booked' where seatId=?");
			pst.setInt(1, seat_ar[x++]);
            
			int res = pst.executeUpdate();
			//System.out.println(res);
			noOfSeats--;
		}
		//System.out.println("updated seat " + x);
		x = 0;
		//System.out.println("Ids updated are " + Arrays.toString(seat_ar));
		for (int i = 0; i < seat_ar.length; i++) {
			pst1 = connection.prepareStatement("select  * from seat where seatid=?");
			pst1.setInt(1, seat_ar[i]);
			rs1 = null;
			rs1 = pst1.executeQuery();
			seat = null;
			seat = new Seat();
			rs1.next();
			seat.setSeatId(rs1.getInt(1));
			seat.setSeatStatus(rs1.getString(2));
			seat.setSeatPrice(rs1.getDouble(3));
            list2.add(seat);
		}

		return list2;
	}

	@Override
	public double calculateTotalCost() throws SQLException {

		// st=connection.createStatement();
		List<Seat> list = new ArrayList<>();
		list = list2;
		double sum = 0;
		for (Seat s:list) {
			//System.out.println("   List is "+s.getSeatPrice());
			sum = sum + s.getSeatPrice();
        
		}
		return sum;
	}

	@Override
	public String choosePaymentMethod(String mode) {
		// TODO Auto-generated method stub
		if (mode.equalsIgnoreCase("paytm"))
			return "Payment mode selected is paytm";

		else if (mode.equalsIgnoreCase("phonepe"))
			return "Payment mode selected is phonepe";

		else if (mode.equalsIgnoreCase("credit card"))
			return "Payment mode selected is credit card";

		else if (mode.equalsIgnoreCase("debit card"))
			return "Payment mode selected is debit card";

		return mode;
	}

	@Override
	public boolean makePayment(String s, double d) throws SQLException {
		pst=connection.prepareStatement("update admin_account set account=account+?");
        pst.setDouble(1, d);
        int res=pst.executeUpdate();
		  if(res==1)
		     return true;
		  else
			  return false;
	}

	@Override
	public Ticket showTicket() throws SQLException {
		// TODO Auto-generated method stub

		System.out.println("***************************************");
		Ticket t=new Ticket();
		t=null;
		t.setNoOfSeats(t.getNoOfSeats());
		
		return t;
	}

	@Override
	public boolean cancelBookings(List<Seat> s) throws SQLException {
		// TODO Auto-generated method stub
		
		pst=connection.prepareStatement("update seat set seatStatus='available' where seatId=?");
		pst.setInt(1, s.get(1).getSeatId());
		int res=pst.executeUpdate();
		if(res==1)
			return true;
		else
		return false;
	}

}
