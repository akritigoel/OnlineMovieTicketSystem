package com.capgemini.onlinemovie.pl;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.capgemini.onlinemovie.dao.AdminDaoImpl;
import com.capgemini.onlinemovie.dao.IAdminDao;
import com.capgemini.onlinemovie.dao.ITheaterDao;
import com.capgemini.onlinemovie.dao.TheaterDaoImpl;
import com.capgemini.onlinemovie.entities.*;
import com.capgemini.onlinemovie.exception.AdminException;
import com.capgemini.onlinemovie.exception.IdException;

import com.capgemini.onlinemovie.exception.TheaterNameException;

import com.capgemini.onlinemovie.service.AdminService;

import com.capgemini.onlinemovie.service.AdminServiceImpl1;

public class AdminMain {

	public static void main(String[] args)
			throws SQLException, ParseException, IdException, TheaterNameException, AdminException {

		AdminService service = null;
		service = new AdminServiceImpl1();

		Scanner scan = new Scanner(System.in);

		int id;

		ITheaterDao th = new TheaterDaoImpl();

		IAdminDao admin = new AdminDaoImpl();

		Theater theater = new Theater();

		Movie movie = new Movie();
		
		Show show=new Show();

		Screen screen = new Screen();

		System.out.println("Choose the operation you want to perform:");

		System.out.println("1.ADD THEATRE\n2.REMOVE THEATRE\n3.REMOVE MOVIE\n4.REMOVE SCREEN\n5.ADD SHOW \n6.REMOVE SHOW");

		int choose = scan.nextInt();

		switch (choose) {

		case 1:
			service.addATheater();

			break;

		
		case 3:
			System.out.println("Enter movie id to be removed: ");

			id = scan.nextInt();

			service.deleteAMovie(id);

			break;

		case 4:
			System.out.println("Enter screen id to be removed: ");

			id = scan.nextInt();

			service.deleteAScreen(id);

			break;
		case 5:
		

			service.addAShow(show);

			break;


		case 6:
			System.out.println("Enter show id to be removed: ");

			id = scan.nextInt();

			service.deleteAShow(id);

			break;

		default:
			System.out.println("enter valid number");

		}

	}

}