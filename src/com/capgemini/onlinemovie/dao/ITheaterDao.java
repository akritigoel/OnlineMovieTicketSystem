package com.capgemini.onlinemovie.dao;


import java.sql.SQLException;
import java.util.HashMap;

import com.capgemini.onlinemovie.entities.Movie;
import com.capgemini.onlinemovie.entities.Screen;
import com.capgemini.onlinemovie.entities.Show;



public interface ITheaterDao {
	
	public Movie searchMovie(String movie) throws SQLException;
	public Screen searchScreen(String movie) throws SQLException;
	
	
}
