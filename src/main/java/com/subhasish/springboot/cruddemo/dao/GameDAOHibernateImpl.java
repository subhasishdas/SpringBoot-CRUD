package com.subhasish.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.subhasish.springboot.cruddemo.entity.Game;

@Repository
public class GameDAOHibernateImpl implements GameDAO{

	// define field for entitymanager	
	private EntityManager entityManager;
			
		// set up constructor injection
	@Autowired
	public GameDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
		
		
	@Override
	public List<Game> findAll() {
		// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
				
				// create a query
				Query<Game> theQuery =
						currentSession.createQuery("from Game", Game.class);
				
				// execute query and get result list
				List<Game> games = theQuery.getResultList();
				
				// return the results		
				return games;
	}

	@Override
	public Game findById(int theId) {
		// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
				
				// get the employee
				Game theGame =
						currentSession.get(Game.class, theId);
				
				// return the employee
				return theGame;
	}

	@Override
	public List<Game> findByName(String gameName) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Game> theQuery =
				currentSession.createQuery("from Game where title=:theGameName");
		
		theQuery.setParameter("theGameName", gameName);
		// execute query and get result list
		List<Game> games = theQuery.getResultList();
		
		// return the results		
		return games;
		
	}
	
	@Override
	public void save(Game theGame) {
		// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
				
				// save employee
				currentSession.saveOrUpdate(theGame);
		
	}

	@Override
	public void deleteById(int theId) {
		// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
						
				// delete object with primary key
				Query theQuery = 
						currentSession.createQuery(
								"delete from Game where id=:gameId");
				theQuery.setParameter("gameId", theId);
				
				theQuery.executeUpdate(); 
		
	}


	

}
