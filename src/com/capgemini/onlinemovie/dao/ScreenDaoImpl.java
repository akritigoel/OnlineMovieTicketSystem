package com.capgemini.onlinemovie.dao;


import com.capgemini.onlinemovie.entities.Show;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.HashMap;

import com.capgemini.onlinemovie.database.*;

public class ScreenDaoImpl implements ScreenDao{
Connection connection;
Statement st;
ResultSet rs;
PreparedStatement pst;

Show show;
HashMap<Integer,Show> hashmap;

public ScreenDaoImpl()throws SQLException
{
connection=Database.myconnection();
}


@Override
public Show searchShow(String showName) throws SQLException {

pst=connection.prepareStatement("select * from show where showName=?");
pst.setString(1, showName);
rs=null;
rs=pst.executeQuery();

if(rs.next())
{
show=null;
show=new Show();

show.setShowId(rs.getInt(1));
show.setShowStartTime(rs.getTime(2));
show.setShowEndTime(rs.getTime(3));
show.setShowName(rs.getString(4));
show.setMovieName(rs.getString(5));
show.setScreenId(rs.getInt(6));
show.setTheatreId(rs.getInt(7));
}
return show;
}

@Override
public HashMap<Integer,Show> showShows()throws SQLException {
st=connection.createStatement();
rs=st.executeQuery("select * from show");
hashmap=null;
hashmap=new HashMap<Integer, Show>();
while(rs.next())
{
show=null;
show=new Show();

show.setShowId(rs.getInt(1));
show.setShowStartTime(rs.getTime(2));
show.setShowEndTime(rs.getTime(3));
show.setShowName(rs.getString(4));
show.setMovieName(rs.getString(5));
show.setScreenId(rs.getInt(6));
show.setTheatreId(rs.getInt(7));

hashmap.put(rs.getInt(1), show);
}
return hashmap;
}

}
