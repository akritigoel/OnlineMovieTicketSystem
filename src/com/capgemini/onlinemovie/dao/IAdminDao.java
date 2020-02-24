package com.capgemini.onlinemovie.dao;


import java.sql.SQLException;
import java.util.HashMap;

import com.capgemini.onlinemovie.entities.Movie;
import com.capgemini.onlinemovie.entities.Show;
import com.capgemini.onlinemovie.entities.Theater;




public interface IAdminDao {
	public Theater addTheater(Theater th) throws SQLException;
	
	public boolean deleteTheater(int id) throws SQLException;
	
	public void addMovie(int id) throws SQLException;
	public boolean deleteMovie(int id) throws SQLException;
	
	public boolean deleteScreen(int id) throws SQLException;
	
	public Show addShow(Show sh) throws SQLException;
	public boolean deleteShow(int id) throws SQLException;
	
	
}
