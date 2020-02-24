package com.capgemini.onlinemovie.entities;



public class Theater {
	
	private int theaterId;
	private String theaterName;
	private String theaterCity;
	
	String managerName;
	String managerContact;
	
	
	public int getTheaterId() {
	//	System.out.println("theater id reyrns");
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public String getTheaterName() {
		//System.out.println("theater name returns");
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getTheaterCity() {
		return theaterCity;
	}
	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}
	
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	public Theater() {
		
	}
	public Theater(int theaterId, String theaterName, String theaterCity, Movie movies, Screen listofScreens,
			String managerName, String managerContact) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		
		this.managerName = managerName;
		this.managerContact = managerContact;
	}
	@Override
	public String toString() {
		return "Theater [theaterId=" + theaterId + ", theaterName=" + theaterName + ", theaterCity=" + theaterCity
				+ ", managerName=" + managerName + ", managerContact=" + managerContact + "]";
	}
	

}
