package com.subhasish.springboot.cruddemo.dao;

import java.util.List;

import com.subhasish.springboot.cruddemo.entity.Game;

public interface GameDAO {

	public List<Game> findAll();
	
	public Game findById(int theId);
	
	public void save(Game theGame);
	
	public void deleteById(int theId);

	public List<Game> findByName(String gameName);
}
