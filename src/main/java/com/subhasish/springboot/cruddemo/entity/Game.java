package com.subhasish.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mytable")
public class Game {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="platform")
	private String platform;
	
	@Column(name="score")
	private String score;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="editors_choice")
	private String editors_choice;
	
	// define constructors
	
	public Game() {
		
	}

	public Game(String title, String platform, String score, String genre, String editors_choice) {
		super();
		this.title = title;
		this.platform = platform;
		this.score = score;
		this.genre = genre;
		this.editors_choice = editors_choice;
	}

	// define getter/setter
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getPlatform() {
		return platform;
	}



	public void setPlatform(String platform) {
		this.platform = platform;
	}



	public String getScore() {
		return score;
	}



	public void setScore(String score) {
		this.score = score;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public String getEditors_choice() {
		return editors_choice;
	}



	public void setEditors_choice(String editors_choice) {
		this.editors_choice = editors_choice;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	// define tostring
	
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", platform=" + platform + ", score=" + score + ", genre="
				+ genre + ", editors_choice=" + editors_choice + "]";
	}




		
}











