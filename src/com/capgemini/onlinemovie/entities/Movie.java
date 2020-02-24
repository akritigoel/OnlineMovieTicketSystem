package com.capgemini.onlinemovie.entities;



import java.util.*;

public class Movie {
	private int movieId;
	private String movieName;
	private String movieGenre;
	private String movieDirector;
	private int movieLength;
	private String language;
	private Date movieReleaseDate;
	
public Movie() {
		
	}
	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	
	public Movie(int movieId, String movieName, String movieGenre, String movieDirector, int movieLength,
			String language, Date movieReleaseDate) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieDirector = movieDirector;
		this.movieLength = movieLength;
		this.language = language;
		this.movieReleaseDate = movieReleaseDate;
	}

	public Movie(int movieId,String movieName) {
		super();
		this.movieId=movieId;
		this.movieName = movieName;
	}

	public Movie(String movieName) {
		super();
		this.movieName = movieName;
	}
	
	
	
	
	

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public int getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	

	
	
	public int getMovieId() {
		//System.out.println("id returns");
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
		System.out.println("id set");
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre
				+ ", movieDirector=" + movieDirector + ", movieLength=" + movieLength + ", language=" + language
				+ ", movieReleaseDate=" + movieReleaseDate + "]";
	}

	

	
	
	

	
	
	

}
