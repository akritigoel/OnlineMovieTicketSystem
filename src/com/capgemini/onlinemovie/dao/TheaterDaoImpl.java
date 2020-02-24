package com.capgemini.onlinemovie.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;
import java.util.HashMap;

import com.capgemini.onlinemovie.database.Database;
//import com.capgemini.onlinemovie.SQLException.Database;
import com.capgemini.onlinemovie.entities.*;


public class TheaterDaoImpl implements ITheaterDao{
	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	Movie m;
	Screen screen;

	HashMap<Integer,Movie> hashMap;
	 public TheaterDaoImpl() throws SQLException {
		 connection=Database.myconnection();
		
	}
	
	@Override
	public Movie searchMovie(String movie) throws SQLException {
		
		pst=connection.prepareStatement("select * from movie where movieName=?");
		pst.setString(1, movie);
		rs=null;
		rs=pst.executeQuery();
		
		if(rs.next()) {
		m=null;
		m=new Movie();
		
		
		m.setMovieId(rs.getInt(1));
		m.setMovieName(rs.getString(2));
		m.setMovieGenre(rs.getString(3));
		m.setMovieDirector(rs.getString(4));
		m.setMovieLength(rs.getInt(5));
		m.setLanguage(rs.getString(6));
		m.setMovieReleaseDate((Date) rs.getObject(7));
		}
	
		return m;
	
	}

	@Override
	public Screen searchScreen(String movie) throws SQLException {
		pst=connection.prepareStatement("select * from screen where movieName=?");
		pst.setString(1, movie);
		rs=null;
		rs=pst.executeQuery();
		
		if(rs.next()) {
		screen=null;
		screen=new Screen();
		
		
		screen.setScreenId(rs.getInt(1));
		screen.setTheaterId(rs.getInt(2));
		screen.setScreenName(rs.getString(3));
		screen.setShowList(rs.getString(4));
		screen.setMovieEndDate(rs.getDate(5));
		screen.setRows(rs.getInt(6));
		screen.setColumns(rs.getInt(7));
	
		}
	
		return screen;
		
	}
	
	

}
