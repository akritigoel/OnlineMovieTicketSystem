package com.capgemini.onlinemovie.service;
import java.sql.SQLException;
import java.text.ParseException;
import com.capgemini.onlinemovie.entities.Show;
import com.capgemini.onlinemovie.exception.AdminException;
import com.capgemini.onlinemovie.exception.IdException;
import com.capgemini.onlinemovie.exception.TheaterNameException;



public interface AdminService {

	public void addATheater() throws SQLException, AdminException ;
	public void deleteAMovie(int id) throws SQLException, IdException, AdminException;



	public void deleteAScreen(int id) throws SQLException, IdException, AdminException;



  public void addAShow(Show sh) throws SQLException, AdminException, ParseException;



	public void deleteAShow(int id) throws SQLException, AdminException;
	void deleteATheater(int movieId) throws SQLException, AdminException;
	



}