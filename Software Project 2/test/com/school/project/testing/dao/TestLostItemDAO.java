package com.school.project.testing.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.school.project.dao.LostItemDAO;
import com.school.project.model.LostItem;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLostItemDAO {

	@Test
	public void testGetLostItemIsNull() {
		List<LostItem> lostItems = LostItemDAO.getInstance().getAll();
		for(int i = 0; i < lostItems.size(); i++){
			LostItem result = LostItemDAO.getInstance().get(i);
			assertEquals(null, result);
		}
	}
	@Test
	public void testAddLostItem(){
		LostItem dummyLostItem = new LostItem(1, "test_Earphones", "blue earphones of the brand Sennheiser", "Brussel-Centraal", false, false);
		LostItemDAO.getInstance().add(dummyLostItem);
		List<LostItem> lostItems = LostItemDAO.getInstance().getAll();
		LostItem result = lostItems.get(lostItems.size() - 1);
		System.out.println("Added " + result);
	}
	@Test
	public void testDeleteLostItem(){
		LostItem dummyLostItem = new LostItem(1, "test_Bag", "black schoolbag of the brand Dakine", "Jette", false, false);
		LostItemDAO.getInstance().add(dummyLostItem);
		List<LostItem> lostItems = LostItemDAO.getInstance().getAll();
		LostItem result = lostItems.get(lostItems.size() - 1);
		LostItemDAO.getInstance().delete(dummyLostItem);
		System.out.println("Deleted " + result);
	}
	@Test
	public void testUpdateLostItem(){
		List<LostItem> lostItems = LostItemDAO.getInstance().getAll();
		LostItem lastLostItem = lostItems.get(lostItems.size() - 1);
		LostItem uDummyLostItem = new LostItem(lastLostItem.getId(), "test_Earphones", "blue earphones of the brand Sennheiser", "Brussel-Centraal", true, false);
		LostItemDAO.getInstance().update(uDummyLostItem);
		System.out.println("Updated LostItem with ID: " + lastLostItem.getId());
		tearDown();
	}
	
	@AfterClass
	public static void tearDown(){
		LostItemDAO.getInstance().deleteDummies();
	}
}
