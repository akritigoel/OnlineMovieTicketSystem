package com.capgemini.onlinemovie.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.HashMap;

import com.capgemini.onlinemovie.database.Database;
import com.capgemini.onlinemovie.entities.Movie;
import com.capgemini.onlinemovie.entities.Screen;
import com.capgemini.onlinemovie.entities.Show;
import com.capgemini.onlinemovie.entities.Theater;

public class AdminDaoImpl implements IAdminDao {

	HashMap<Integer, Movie> map = new HashMap<>();
	Theater theater;
	Movie m;
	Screen s;
	Show show;
	Connection connection;
	Statement st;
	PreparedStatement pst, pst1,pst2;
	ResultSet rst;

	public AdminDaoImpl() throws SQLException {
		connection = Database.myconnection();
	}

	@Override
	public Theater addTheater(Theater th) throws SQLException {

		pst = connection.prepareStatement("insert into theater values(?,?,?,?,?)");
		pst.setInt(1, th.getTheaterId());
		pst.setString(2, th.getTheaterName());
		pst.setString(3, th.getTheaterCity());	
		m = th.getMovies();
		// add movies
		pst1 = connection.prepareStatement("insert into movie values(?,?,?,?,?,?,?)");
		pst1.setInt(1, th.getTheaterId());
		pst1.setInt(2, m.getMovieId());
		pst1.setString(3, m.getMovieName());
		pst1.setString(4, m.getMovieGenre());
		pst1.setString(5, m.getMovieDirector());
		pst1.setInt(6, m.getMovieLength());
		pst1.setDate(7, (Date) m.getMovieReleaseDate());
		
		pst.setString(4, th.getManagerName());
		pst.setString(5, th.getManagerContact());

		
		//add screen
		s = th.getListofScreens();
		pst2=connection.prepareStatement("insert into screen values(?,?,?,?,?,?)");
		pst2.setInt(1,s.getScreenId());
		pst2.setInt(2, th.getTheaterId());
		pst2.setString(3,s.getScreenName());
		pst2.setDate(4, (Date)s.getMovieEndDate());
		pst2.setInt(5, s.getRows());
		pst2.setInt(6, s.getColumns());
		
		int res = pst.executeUpdate();
		int res1 = pst1.executeUpdate();
		int res2=pst2.executeUpdate();
		if (res == 1 && res1 == 1 && res2==1) {
			return th;
		} else
			return null;
	}
	
	

	@Override
	public boolean deleteTheater(int id) throws SQLException {

		pst = connection.prepareStatement("delete from theater where theaterId=?");
		pst.setInt(1, id);

		int res = pst.executeUpdate();

		if (res == 1) {
			return true;
		} else
			return false;
	}
	
	@Override
	public void addMovie(int id) throws SQLException {
		pst1 = connection.prepareStatement("insert into movie values(?,?,?,?,?,?,?)");
		
		//m=theater.getMovies();
		pst1.setInt(1, id);
		pst1.setInt(2, m.getMovieId());
		pst1.setString(3, m.getMovieName());
		pst1.setString(4, m.getMovieGenre());
		pst1.setString(5, m.getMovieDirector());
		pst1.setInt(6, m.getMovieLength());
		pst1.setDate(7, (Date) m.getMovieReleaseDate());
		
		if(m==null) {
			System.out.println("can not be added");
		}
		else
			System.out.println("added");
		
	}

	@Override
	public boolean deleteMovie(int id) throws SQLException {
		pst = connection.prepareStatement("delete from movie where movieId=?"); 
		pst.setInt(1, id);

		int res = pst.executeUpdate();

		if (res == 1) {
			return true;
		} else
			return false;

	}

	@Override
	public boolean deleteScreen(int id) throws SQLException {
		pst = connection.prepareStatement("delete from screen where screenId=?");
		pst.setInt(1, id);

		int res = pst.executeUpdate();

		if (res == 1) {
			return true;
		} else
			return false;

	}

	@Override
	public Show addShow(Show sh) throws SQLException {
		SeatDao dao = new SeatDaoImpl();

		pst = null;
		if(connection==null)
			System.out.println("No connection");
		
		pst = connection.prepareStatement("insert into show values(?,?,?,?,?,?,?)");
		pst.setInt(1, sh.getShowId());
		pst.setTime(2, new Time(sh.getShowStartTime().getTime()));
		pst.setTime(3, new Time(sh.getShowStartTime().getTime()));

		/* for (Seat s : show.getSeats())
		dao.addSeat(s);*/

		pst.setString(4, sh.getShowName());
		pst.setString(5, sh.getMovieName());
		pst.setInt(6, sh.getScreenId());
		pst.setInt(7, sh.getTheatreId());

		int res = pst.executeUpdate();
		

		return sh;

	}
	

	@Override
	public boolean deleteShow(int id) throws SQLException {
		pst=connection.prepareStatement("delete from show where showId=?");
		pst.setInt(1, id);
		int res=pst.executeUpdate();
		if(res==1)
		return true;

		return false;
		}

	}
/*
	@Override
	public void getMovie() {
		// HashMap<Integer,Movie> hashmap = dao.getAllBook();
		for (HashMap.Entry<Integer, Movie> entry : map.entrySet())
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

	}
	
	*/


