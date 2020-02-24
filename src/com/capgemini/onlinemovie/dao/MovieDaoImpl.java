package com.capgemini.onlinemovie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.capgemini.onlinemovie.database.Database;
import com.capgemini.onlinemovie.entities.Movie;

public class MovieDaoImpl implements MovieDao{
   Connection connection;
	ResultSet rs;
	Statement st;
	PreparedStatement pst;
	HashMap<Integer,Movie> hashmap;
	Movie movie;
	
	public MovieDaoImpl() throws SQLException {
		connection=Database.myconnection();
		
	}
	public HashMap<Integer,Movie> showMovie()throws SQLException {
		st=connection.createStatement();
		rs=st.executeQuery("select * from show");
		hashmap=null;
		hashmap=new HashMap<Integer, Movie>();
		while(rs.next())
		{
		movie=null;
		movie=new Movie();

		movie.setMovieId(rs.getInt(1));
		movie.setMovieName(rs.getString(2));
		movie.setMovieGenre(rs.getString(3));
		movie.setMovieDirector(rs.getString(4));
		movie.setMovieLength(rs.getInt(5));
		movie.setLanguage(rs.getString(6));
		movie.setMovieReleaseDate(rs.getDate(7));
		//movie.setMovieId(rs.getInt(7));
		

		hashmap.put(rs.getInt(1), movie);
		
		}
		return hashmap;
		}

}
