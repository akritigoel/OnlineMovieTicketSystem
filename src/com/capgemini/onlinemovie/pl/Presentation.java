package com.capgemini.onlinemovie.pl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.capgemini.onlinemovie.dao.BookingDao;
import com.capgemini.onlinemovie.dao.BookingDaoImpl;
import com.capgemini.onlinemovie.dao.CustomerDao;
import com.capgemini.onlinemovie.dao.CustomerDaoImpl;
import com.capgemini.onlinemovie.dao.ITheaterDao;
import com.capgemini.onlinemovie.dao.MovieDao;
import com.capgemini.onlinemovie.dao.MovieDaoImpl;
import com.capgemini.onlinemovie.dao.ScreenDao;
import com.capgemini.onlinemovie.dao.ScreenDaoImpl;
import com.capgemini.onlinemovie.dao.TheaterDaoImpl;
import com.capgemini.onlinemovie.dao.UserDao;
import com.capgemini.onlinemovie.dao.UserDaoImpl;
import com.capgemini.onlinemovie.entities.Movie;
import com.capgemini.onlinemovie.entities.Seat;
import com.capgemini.onlinemovie.entities.Show;
import com.capgemini.onlinemovie.entities.Theater;
import com.capgemini.onlinemovie.entities.Ticket;

public class Presentation {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
         BookingDao book=new BookingDaoImpl();
         UserDao user=new UserDaoImpl();
         Theater th=new Theater();
         Show sh=new Show();
         Scanner sc=new Scanner(System.in);
         CustomerDao cust=new CustomerDaoImpl();
         
         /*System.out.println("Enter city");
         String city=sc.next();
		 
         CustomerDao cust=new CustomerDaoImpl();
         th=cust.chooseCity(city);
         System.out.println(th);
         
         System.out.println("Search show");
          String showName=sc.next();
          ScreenDao scr=new ScreenDaoImpl();
          sh=scr.searchShow(showName);
          System.out.println(sh);
          */
         
         
          
         
         System.out.println("Enter entries");
         System.out.println("1.Id  2.Type  3.Password  4.Username");
         String t=user.registerNewUser();
         System.out.println(t);
         
		System.out.println("Enter no of seats");
		int no=sc.nextInt();
		
		System.out.println("Enter mode of payment");
		System.out.println("1. Paytm");
		System.out.println("2. Phonepe");
		System.out.println("3. Debit Card");
		System.out.println("4. Credit card");
		sc.nextLine();
		String s=sc.nextLine();
		String s1=book.choosePaymentMethod(s);
		System.out.println(s1);
		
		System.out.println("Seats Available for booking are");
		List<Seat> seats=new ArrayList<>();
		seats=book.chooseSeats();
		for(Seat i:seats)
			System.out.println(i);
		System.out.println("\n");
		
		System.out.println("Seat to be selected by you is/are ");
		List<Seat> seats1=new ArrayList<>();
		seats1=book.selectSeats(no);
		for(Seat j:seats1)
			System.out.println(j);
		
		System.out.println("\n");
		Seat seat=new Seat();
		double cost;
		cost=book.calculateTotalCost();
		System.out.println("Your total amount to pay is "+cost);
		
		System.out.println("\n");
		
		System.out.println("Do you want to make payment  ---yes/no");
		String ch=sc.next();
		if(ch.equals("yes")) {
		boolean res=book.makePayment(s, cost);
		System.out.println("Your payment has been done "+res);
		}
		else
			System.out.println("Payment request cancelled");
		
		
		System.out.println("Booking status");
		System.out.println("Enter your booked ticketId");
		int ticketId=sc.nextInt();
		boolean status=cust.bookMovieTicket(ticketId);
		System.out.println("Done your ticket has been booked ");
		
		
		/*System.out.println("Cancel ticket");
		boolean res1=book.cancelBookings(seats1);
		System.out.println(res1);
		*/
	}

}
