package com.capgemini.onlinemovie.pl;

import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.onlinemovie.dao.ITheaterDao;
import com.capgemini.onlinemovie.dao.TheaterDaoImpl;
import com.capgemini.onlinemovie.dao.UserDao;
import com.capgemini.onlinemovie.dao.UserDaoImpl;

public class UserMain {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		UserDao user = null;
		ITheaterDao th = null;
		
		try {
			user = new UserDaoImpl();
			th= new TheaterDaoImpl();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Enter details to register:");
		
		
		try {
			user.registerNewUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
