package com.capgemini.onlinemovie.dao;


import java.sql.SQLException;

import com.capgemini.onlinemovie.entities.Login;

public interface LoginDao {

	public boolean LoginUser(Login login)  throws SQLException;
	
	
}
