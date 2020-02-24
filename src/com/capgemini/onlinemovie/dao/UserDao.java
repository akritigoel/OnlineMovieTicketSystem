package com.capgemini.onlinemovie.dao;

import java.sql.SQLException;

import com.capgemini.onlinemovie.entities.User;

public interface UserDao {

	public String registerNewUser() throws SQLException ;
	public boolean signIn();
	public boolean signOut();
	
		
		
	
}

	