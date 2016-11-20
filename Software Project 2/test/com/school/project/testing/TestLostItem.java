package com.school.project.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.school.project.model.LostItem;

public class TestLostItem {
	
	int check = 1; //1 = true, 0 = false
	
	public static LostItem getFirstLostItem(){
		return new LostItem(1, "phone", "iPhone 6 with yellow case", "Bruxelles-Midi", false, false);
	}
	
	public static LostItem getSecondLostItem(){
		return new LostItem(2, "phone", "Samsung Galaxy 7 with blue case", "Jette", true, true);
	}
	
	@Test
	public void testConstructor(){
		int id = 1;
		String type = "phone";
		String description = "iPhone 6 with yellow case";
		String location = "Bruxelles-Midi";
		boolean pickedUp = false;
		boolean archived = false;
		
		LostItem li1 = TestLostItem.getFirstLostItem();
		
		if(check == 1){
			assertEquals(id, li1.getId());
			assertEquals(type, li1.getType());
			assertEquals(description, li1.getDescription());
			assertEquals(location, li1.getLocation());
			assertEquals(pickedUp, li1.isPickedUp());
			assertEquals(archived, li1.isArchived());
		}
		else if(check == 0){
			li1.setId(2);
			li1.setType("phone");
			li1.setDescription("Samsung Galaxy 7 with blue case");
			li1.setLocation("Jette");
			li1.setPickedUp(true);
			li1.setArchived(true);
			
			assertEquals(id, li1.getId());
			assertEquals(type, li1.getType());
			assertEquals(description, li1.getDescription());
			assertEquals(location, li1.getLocation());
			assertEquals(pickedUp, li1.isPickedUp());
			assertEquals(archived, li1.isArchived());
		}
	}
	
	@Test
	public void testEquals(){	
		LostItem li1 = TestLostItem.getFirstLostItem();
		
		if(check == 1){
			LostItem li2 = TestLostItem.getFirstLostItem();
			assertEquals(true, li1.equals(li2));
		}
		else if(check == 0){
			LostItem li2 = TestLostItem.getSecondLostItem();			
			assertEquals(true, li1.equals(li2));
		}
	}
	
	@Test
	public void testHashCode(){
		LostItem li1 = TestLostItem.getFirstLostItem();
		
		if(check == 1){
			LostItem li2 = TestLostItem.getFirstLostItem();
			assertEquals(li1.hashCode(), li2.hashCode());
		}
		else if(check == 0){
			LostItem li2 = TestLostItem.getSecondLostItem();
			assertEquals(li1.hashCode(), li2.hashCode());
		}
	}

}
