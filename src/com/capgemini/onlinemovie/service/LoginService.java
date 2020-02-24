package com.capgemini.onlinemovie.service;



import java.sql.SQLException;

import com.capgemini.onlinemovie.exception.LoginException;

public interface LoginService {

	public void userLogin() throws LoginException, SQLException;
	
	
}