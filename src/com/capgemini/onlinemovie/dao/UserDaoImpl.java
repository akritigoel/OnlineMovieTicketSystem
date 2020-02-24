package com.capgemini.onlinemovie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.capgemini.onlinemovie.database.Database;
import com.capgemini.onlinemovie.entities.User;

public class UserDaoImpl implements UserDao{

	Scanner sc=new Scanner(System.in);
	Connection connection;
    ResultSet rs;
    Statement st;
    PreparedStatement pst;
	
	public UserDaoImpl() throws SQLException {
		connection = Database.myconnection();
	}
	@Override
	public String registerNewUser() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter id: ");
		int userId=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name:");
		String userName=sc.nextLine();
		System.out.println("Enter password: ");
		String password=sc.next();
		System.out.println("Enter user type: ");
		String userType=sc.next();
		//User user=new User();
		pst=connection.prepareStatement("insert into login values(?,?,?,?)");
		pst.setInt(1, userId);
		
		pst.setString(2, password);
		pst.setString(3, userType);
		pst.setString(4, userName);
		int res=pst.executeUpdate();
		if(res==1)
			return "Successfully registered";
		else 
			return "Not registered....try again";
		
	}

	@Override
	public boolean signIn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean signOut() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
