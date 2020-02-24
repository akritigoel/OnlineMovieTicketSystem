package com.capgemini.onlinemovie.controller;

import java.sql.SQLException;
import java.text.ParseException;

import com.capgemini.onlinemovie.exception.AdminException;
import com.capgemini.onlinemovie.exception.IdException;
import com.capgemini.onlinemovie.exception.TheaterNameException;
import com.capgemini.onlinemovie.pl.AdminMain;
import com.capgemini.onlinemovie.pl.UserMain;

public class LoginController {

	public void ConrolPage(String user) {
		if(user.equals("admin")) {
		try {
			AdminMain.main(new String[] {});
		} catch (SQLException | ParseException | IdException | TheaterNameException | AdminException e) {
			
			e.printStackTrace();
		}
		}
		
		else if(user.equals("user")) {
			UserMain.main(new String[] {});
		}
	}
	
	
}

