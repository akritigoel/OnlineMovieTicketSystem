package com.capgemini.onlinemovie.dao;

import java.sql.SQLException;
import java.util.HashMap;

import com.capgemini.onlinemovie.entities.Movie;

public interface MovieDao {

	public HashMap<Integer,Movie> showMovie()throws SQLException;
}
