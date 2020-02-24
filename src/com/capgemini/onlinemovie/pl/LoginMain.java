package com.capgemini.onlinemovie.pl;



import java.sql.SQLException;

import com.capgemini.onlinemovie.exception.LoginException;
import com.capgemini.onlinemovie.service.LoginService;
import com.capgemini.onlinemovie.service.LoginServiceImpl;

public class LoginMain {

	public static void main(String[] args) {
		
		try {
			LoginService loginService=new LoginServiceImpl();
			loginService.userLogin();
			
		} catch (SQLException|LoginException e) {
		System.err.println(e.getMessage());
			
			e.printStackTrace();
		}
		
		
		
	}
}

