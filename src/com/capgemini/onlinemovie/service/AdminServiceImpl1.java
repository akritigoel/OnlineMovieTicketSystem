package com.capgemini.onlinemovie.service;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


import com.capgemini.onlinemovie.entities.Movie;
import com.capgemini.onlinemovie.entities.Screen;
import com.capgemini.onlinemovie.entities.Show;
import com.capgemini.onlinemovie.entities.*;
import com.capgemini.onlinemovie.exception.AdminException;
import com.capgemini.onlinemovie.exception.IdException;
import com.capgemini.onlinemovie.exception.TheaterNameException;
import com.capgemini.onlinemovie.dao.AdminDaoImpl;
import com.capgemini.onlinemovie.dao.MovieDao;
import com.capgemini.onlinemovie.dao.MovieDaoImpl;
import com.capgemini.onlinemovie.dao.ScreenDao;
import com.capgemini.onlinemovie.dao.ScreenDaoImpl;
import com.capgemini.onlinemovie.entities.Theater;

public class AdminServiceImpl1 implements AdminService {

AdminDaoImpl admindao;
ScreenDao screendao;
Theater theatre=null;
Show show=null;
Movie movie=null;
Screen screen=null;
Scanner sc=new Scanner(System.in);

int theatreId;
String theatreName;
String theatreCity;
String managerName;
String managerContact;

String showName;
int showId;

int movieId;
String movieName;
String movieGenre;
String movieDirector;
int movieLength;
String language;
Date movieReleaseDate;

int screenId;

public AdminServiceImpl1() throws SQLException
{
admindao=new AdminDaoImpl();
screendao=new ScreenDaoImpl();
MovieDao moviedao=new MovieDaoImpl();
screendao=new ScreenDaoImpl();
}

@Override
public void addATheater() throws SQLException, AdminException {
System.out.println("Add Theatre Data");

System.out.println("Enter Theatre Id");
theatre=null;
theatre=new Theater();
theatreId = sc.nextInt();

if(theatreId<2000)
throw new AdminException("Theatre id can't be less than 4 digit and should be starting with 2");
else
theatre.setTheaterId(theatreId);


System.out.println("Enter theatre name");

theatreName=sc.next();
if(theatreName.isEmpty())
throw new AdminException("Theatre name can't be empty");
else
theatre.setTheaterName(theatreName);


System.out.println("Enter theatre city");

theatreCity=sc.next();
if(theatreCity.isEmpty())
throw new AdminException("Theatre City can't be empty");
else
theatre.setTheaterCity(theatreCity);


System.out.println("Enter Manager name");

managerName=sc.next();
if(managerName.isEmpty())
throw new AdminException("Manager name can't be empty");
else
theatre.setManagerName(managerName);


System.out.println("Enter Manager contact");

managerContact=sc.next();
if(managerContact.isEmpty())
throw new AdminException("Manager contact can't be empty");

else if(managerContact.length()<10)
throw new AdminException("Manager contact can't be less than 10 digits");
else
theatre.setManagerContact(managerContact);
}

@Override
public void deleteATheater(int theaterId) throws SQLException, AdminException {
if(theaterId<=0)
throw new AdminException("Id can't be negative or zero");
boolean status =admindao.deleteTheater(theaterId);
if(status)
System.out.println("Movie deleted");
else
	System.out.println("Please check the id u have entered.");

}



@Override
public void deleteAMovie(int id) throws SQLException, AdminException {
	
System.out.println("Delete Movie Data");
System.out.println("Enter movie id");
movieId=sc.nextInt();
if(movieId<0)
throw new AdminException("Id can't be negative");
else
admindao.deleteMovie(movieId);
System.out.println("Movie deleted");

}



@Override
public void deleteAScreen(int id) throws SQLException,AdminException {
System.out.println("Delete Screen Data");
System.out.println("Enter screen id");
screenId=sc.nextInt();
if(screenId<0)
    throw new AdminException("Id can't be negative");
else
admindao.deleteScreen(screenId);
System.out.println("Screen deleted");



}

@Override
public void addAShow(Show sh) throws SQLException,AdminException, ParseException {

System.out.println("Add Show Data");

System.out.println("Enter Show Id");
sh=null;
sh=new Show();
showId = sc.nextInt();

if(showId<1000)
throw new AdminException("Theatre id can't be less than 4 digit");
else
sh.setShowId(showId);
System.out.println("Enter start time:");
SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

Date showStartTime = new Date(sdf.parse(sc.next()).getTime());
sh.setShowStartTime(showStartTime);

System.out.println("Enter end time:");
Date showEndTime = new Date(sdf.parse(sc.next()).getTime());
sh.setShowEndTime(showEndTime);

System.out.println("Enter show name--morning/evening:");
String showName = sc.next();
sh.setShowName(showName);

System.out.println("Enter movie name:");
String MovieName = sc.next();
sh.setMovieName(movieName);

System.out.println("Enter screen id:");
int screenId = sc.nextInt();
sh.setScreenId(screenId);

System.out.println("Enter theater id:");
int theaterId = sc.nextInt();
sh.setTheatreId(theaterId);

admindao.addShow(sh);


}


@Override
public void deleteAShow(int id) throws SQLException, AdminException {

System.out.println("Enter show id");
showId=sc.nextInt();
if(showId<0)
throw new AdminException("Id can't be negative");
else
admindao.deleteShow(showId);
System.out.println("Show deleted");

}

}