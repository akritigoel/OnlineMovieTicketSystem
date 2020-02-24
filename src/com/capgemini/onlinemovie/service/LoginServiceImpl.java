package com.capgemini.onlinemovie.service;


import java.io.Console;
import java.sql.SQLException;
import java.util.Scanner;

import javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag;

import com.capgemini.onlinemovie.controller.LoginController;
import com.capgemini.onlinemovie.dao.LoginDao;
import com.capgemini.onlinemovie.dao.LoginDaoImpl;
import com.capgemini.onlinemovie.entities.Login;
import com.capgemini.onlinemovie.exception.LoginException;

public class LoginServiceImpl implements LoginService {

	Login login;
	Console console;
	LoginDao dao;

	public LoginServiceImpl() throws SQLException {
		console = System.console();
		dao = new LoginDaoImpl();
	}

	@Override
	public void userLogin() throws LoginException, SQLException {
		Scanner scan = new Scanner (System.in);
		if (console == null)
			System.out.println("console is null");
		login = new Login();
		System.out.println("Are you new customer: type yes or no : ");
		String st= scan.next();
		if(st.equalsIgnoreCase("yes")) {
			System.out.println("are you admin or user:");
			String str1 = scan.next();
			LoginController lc = new LoginController();
			lc.ConrolPage(str1);
		}
		
		System.out.println("Enter Id");
		login.setId(Integer.parseInt(console.readLine()));

		System.out.println("Enter Password");
		login.setPassword(console.readPassword().toString());

		System.out.println("Confirm Password");
		String s = new String(console.readPassword());
		login.setPassword(s);

		boolean status = false, status1 = false;
		if (!s.equals(login.getPassword())) {
			System.err.println("Renter password is wrong");
			status = true;
		}

		if (status) {
			System.out.println("Renter password again");
			s = console.readPassword().toString();
			login.setPassword(s);
		}
		if (!s.equals(login.getPassword())) 
			throw new LoginException("Reneter password wrong Login Denied");

			System.out.println("Enter UserType Admin or User");
			String str=console.readLine();
			login.setUserType(str);

			if (dao.LoginUser(login)) {
				System.out.println("user login successfull");
				LoginController lc = new LoginController();
				lc.ConrolPage(str);
			} else
				System.err.println("login denied either id or password problem");

		}

	}

