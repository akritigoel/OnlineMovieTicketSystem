package com.capgemini.onlinemovie.dao;


import com.capgemini.onlinemovie.entities.Show;

import java.sql.SQLException;
import java.util.HashMap;



public interface ScreenDao  {

public Show searchShow(String showName) throws SQLException;
public HashMap<Integer, Show> showShows()throws SQLException;

}