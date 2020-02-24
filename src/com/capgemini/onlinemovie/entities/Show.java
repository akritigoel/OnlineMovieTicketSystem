package com.capgemini.onlinemovie.entities;



import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;



public class Show {
private int showId;
private Date showStartTime;
private Date showEndTime;
//private Seat seats[];
private String showName;
private String movieName;
private int screenId;
private int theatreId;

public Show(int showId, Date showStartTime, Date showEndTime,
String showName, String movieName, int screenId,
int theatreId) {
super();
this.showId = showId;
this.showStartTime = showStartTime;
this.showEndTime = showEndTime;
this.showName = showName;
this.movieName = movieName;
this.screenId = screenId;
this.theatreId = theatreId;
}
public Show() {
// TODO Auto-generated constructor stub
}
public int getShowId() {
return showId;
}
public void setShowId(int showId) {
this.showId = showId;
}
public Date getShowStartTime() {
return showStartTime;
}
public void setShowStartTime(Date showStartTime) {
this.showStartTime = showStartTime;
}
public Date getShowEndTime() {
return showEndTime;
}
public void setShowEndTime(Date showEndTime) {
this.showEndTime = showEndTime;
}
/*public Seat[] getSeats() {
return seats;
}
public void setSeats(Seat[] seats) {
this.seats = seats;
}*/
public String getShowName() {
return showName;
}
public void setShowName(String showName) {
this.showName = showName;
}
public String getMovieName() {
return movieName;
}
public void setMovieName(String movieName) {
this.movieName = movieName;
}
public int getScreenId() {
return screenId;
}
public void setScreenId(int screenId) {
this.screenId = screenId;
}
public int getTheatreId() {
return theatreId;
}
public void setTheatreId(int theatreId) {
this.theatreId = theatreId;
}
@Override
public String toString() {
return "Show [showId=" + showId + ", showStartTime=" + showStartTime
+ ", showEndTime=" + showEndTime 
+  ", showName=" + showName
+ ", movieName=" + movieName + ", screenId=" + screenId
+ ", theatreId=" + theatreId + "]";
}






}
