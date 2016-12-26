package com.school.project.testing.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.school.project.dao.RailCardDAO;
import com.school.project.model.RailCard;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRailCardDAO {

	@Test
	public void testGetRailcardIsNull() {
		List<RailCard> railcards = RailCardDAO.getInstance().getAll();
		for(int i = 0; i < railcards.size(); i++){
			RailCard result = RailCardDAO.getInstance().get(i);
			assertEquals(null, result);
		}
	}
	@Test
	public void testAddRailcard(){
		RailCard dummyRailCard = new RailCard(1, "test_Railcard", "this railcard was generated by a unit test", 7, 0, 7, false, false);
		RailCardDAO.getInstance().add(dummyRailCard);
		List<RailCard> railcards = RailCardDAO.getInstance().getAll();
		RailCard result = railcards.get(railcards.size() - 1);
		System.out.println("Added " + result);
	}
	@Test
	public void testDeleteRailcard(){
		RailCard dummyRailCard = new RailCard(1, "test_Railcard Mk.2", "congratulations, your railcard evolved", 14, 0, 14, false, false);
		RailCardDAO.getInstance().add(dummyRailCard);
		List<RailCard> railcards = RailCardDAO.getInstance().getAll();
		RailCard result = railcards.get(railcards.size() - 1);
		RailCardDAO.getInstance().delete(dummyRailCard);
		System.out.println("Deleted " + result);
	}
	@Test
	public void testUpdateRailcard(){
		List<RailCard> railcards = RailCardDAO.getInstance().getAll();
		RailCard lastRailCard = railcards.get(railcards.size() - 1);
		RailCard uDummyRailCard = new RailCard(lastRailCard.getId(), "test_Railcard_u", "this railcard was generated and updated by a unit test", 7, 0, 7, true, false);
		RailCardDAO.getInstance().update(uDummyRailCard);
		System.out.println("Updated RailCard with ID: " + lastRailCard.getId());
	}
}