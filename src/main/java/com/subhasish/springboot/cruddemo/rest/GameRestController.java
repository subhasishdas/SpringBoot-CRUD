package com.subhasish.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.subhasish.springboot.cruddemo.entity.Game;

import com.subhasish.springboot.cruddemo.service.GameService;

@RestController
@RequestMapping("/api")
public class GameRestController {

private GameService gameService;
	
	@Autowired
	public GameRestController(GameService theGameService) {
		gameService = theGameService;
	}
	
	@GetMapping("/games")
	public List<Game> findAll() {
		return gameService.findAll();
	}
	
	@GetMapping("/games/{gameId}")
	public Game getGame(@PathVariable int gameId) {
		
		Game theGame = gameService.findById(gameId);
		
		if (theGame == null) {
			throw new RuntimeException("Game id not found - " + gameId);
		}
		
		return theGame;
	}
	
	@GetMapping("/games/name/{gameName}")
	public List<Game> getGameByName(@PathVariable String gameName) {
		return gameService.findByName(gameName);

	}
	
	@PostMapping("/games")
	public Game addGame(@RequestBody Game theGame) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theGame.setId(0);
		
		gameService.save(theGame);
		
		return theGame;
	}
	
	@PutMapping("/games")
	public Game updateGame(@RequestBody Game theGame) {
		
		gameService.save(theGame);
		
		return theGame;
	}
	
	@DeleteMapping("/games/{gameId}")
	public String deleteGame(@PathVariable int gameId) {
		
		Game tempGame = gameService.findById(gameId);
		
		// throw exception if null
		
		if (tempGame == null) {
			throw new RuntimeException("Game id not found - " + gameId);
		}
		
		gameService.deleteById(gameId);
		
		return "Deleted game id - " + gameId;
	}
}
