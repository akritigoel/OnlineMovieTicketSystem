package com.capgemini.onlinemovie.entities;


import java.util.Date;

public class Screen {
	
	private int screenId;
	private int theaterId;
	
	private String screenName;
	private String showList;
	private Date movieEndDate;
	private int rows;
	private int columns;
	
	public Screen() {
		
	}
	 public Screen(int screenId, String screenName) {
		 this.screenId=screenId;
		 this.screenName=screenName;
		// TODO Auto-generated constructor stub
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getShowList() {
		return showList;
	}

	public void setShowList(String showList) {
		this.showList = showList;
	}

	public Date getMovieEndDate() {
		return movieEndDate;
	}

	public void setMovieEndDate(Date movieEndDate) {
		this.movieEndDate = movieEndDate;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", theaterId=" + theaterId + ", screenName=" + screenName
				+ ", showList=" + showList + ", movieEndDate=" + movieEndDate + ", rows=" + rows + ", columns="
				+ columns + "]";
	}
	
	
	
	

}
