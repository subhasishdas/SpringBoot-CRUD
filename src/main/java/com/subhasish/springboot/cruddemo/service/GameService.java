package com.subhasish.springboot.cruddemo.service;

import java.util.List;


import com.subhasish.springboot.cruddemo.entity.Game;

public interface GameService {

	public List<Game> findAll();
	
	public Game findById(int theId);
	
	public List<Game> findByName(String gameName);
	
	public void save(Game theGame);
	
	public void deleteById(int theId);
}
