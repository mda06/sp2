package com.school.project.testing.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.school.project.dao.ActiveRailCardDAO;
import com.school.project.dao.RailCardDAO;
import com.school.project.dao.UserDAO;
import com.school.project.model.ActiveRailCard;
import com.school.project.model.RailCard;
import com.school.project.model.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestActiveRailCardDAO {

	@Test
	public void testGetActiveRailcardIsNull() {
		List<ActiveRailCard> acrs = ActiveRailCardDAO.getInstance().getAll();
		for(int i = 0; i < acrs.size(); i++){
			ActiveRailCard result = ActiveRailCardDAO.getInstance().get(i);
			assertEquals(null, result);
		}
	}
	@Test
	public void testAddActiveRailcard(){
		List <RailCard> railcards = RailCardDAO.getInstance().getAll();
		List <User> users = UserDAO.getInstance().getAll();
		RailCard dummyRailcard = railcards.get(railcards.size() - 1);
		User dummyInNameOf = users.get(users.size() - 1);
		User dummySoldBy = users.get(users.size() - 2);
		
		ActiveRailCard dummyACR = new ActiveRailCard(1, new Date(1477260000000L), new Date(1477260000000L), "London", "Amsterdam", dummySoldBy, dummyInNameOf, dummyRailcard, false);
		ActiveRailCardDAO.getInstance().add(dummyACR);
		List<ActiveRailCard> acrs = ActiveRailCardDAO.getInstance().getAll();
		ActiveRailCard result = acrs.get(acrs.size() - 1);
		System.out.println("Added " + result);
	}
	@Test
	public void testDeleteActiveRailcard(){
		List <RailCard> railcards = RailCardDAO.getInstance().getAll();
		List <User> users = UserDAO.getInstance().getAll();
		RailCard dummyRailcard = railcards.get(railcards.size() - 1);
		User dummyInNameOf = users.get(users.size() - 1);
		User dummySoldBy = users.get(users.size() - 2);
		
		ActiveRailCard dummyACR = new ActiveRailCard(1, new Date(1477260000000L), new Date(1477260000000L), "Berlin", "Paris", dummySoldBy, dummyInNameOf, dummyRailcard, false);
		ActiveRailCardDAO.getInstance().add(dummyACR);
		List<ActiveRailCard> acrs = ActiveRailCardDAO.getInstance().getAll();
		ActiveRailCard result = acrs.get(acrs.size() - 1);
		ActiveRailCardDAO.getInstance().delete(dummyACR);
		System.out.println("Deleted " + result);
	}
	@Test
	public void testUpdateActiveRailcard(){
		List <RailCard> railcards = RailCardDAO.getInstance().getAll();
		List <User> users = UserDAO.getInstance().getAll();
		RailCard dummyRailcard = railcards.get(railcards.size() - 2);
		User dummyInNameOf = users.get(users.size() - 2);
		User dummySoldBy = users.get(users.size() - 3);
		
		List<ActiveRailCard> acrs = ActiveRailCardDAO.getInstance().getAll();
		ActiveRailCard lastACR = acrs.get(acrs.size() - 1);
		ActiveRailCard uDummyACR = new ActiveRailCard(lastACR.getId(), new Date(1477260000000L), new Date(1477260000000L), "Brussels", "Amsterdam", dummySoldBy, dummyInNameOf, dummyRailcard, false);
		ActiveRailCardDAO.getInstance().update(uDummyACR);
		System.out.println("Updated ActiveRailCard with ID: " + lastACR.getId());
	}
}
