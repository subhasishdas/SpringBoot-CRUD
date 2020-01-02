package com.subhasish.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.subhasish.springboot.cruddemo.dao.GameDAO;
import com.subhasish.springboot.cruddemo.entity.Game;

@Service
public class GameServiceImpl implements GameService{
	private GameDAO gameDAO;
	
	@Autowired
	public GameServiceImpl(GameDAO theGameDAO) {
		gameDAO = theGameDAO;
	}

	@Override
	@Transactional
	public List<Game> findAll() {
		return gameDAO.findAll();
	}

	@Override
	@Transactional
	public Game findById(int theId) {
		return gameDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Game theGame) {
		gameDAO.save(theGame);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		gameDAO.deleteById(theId);
		
	}

	@Override
	@Transactional
	public List<Game> findByName(String gameName) {
		return gameDAO.findByName(gameName);
	}

}
