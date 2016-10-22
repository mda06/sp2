package com.school.project.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.school.project.model.LostItem;

public class TestLostItem {
	
	int check = 1; //1 = true, 0 = false
	
	@Test
	public void testConstructor(){
		int id = 1;
		String type = "phone";
		String description = "iPhone 6 with yellow case";
		String location = "Bruxelles-Midi";
		boolean pickedUp = false;
		boolean archived = false;
		
		LostItem li1 = new LostItem(id, type, description, location, pickedUp, archived);
		
		if(check == 1){
			assertEquals(id, li1.getId());
			assertEquals(type, li1.getType());
			assertEquals(description, li1.getDescription());
			assertEquals(location, li1.getLocation());
			assertEquals(pickedUp, li1.isPickedUp());
			assertEquals(archived, li1.isArchived());
		}
		else if(check == 0){
			li1.setId(1);
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
		int id = 1;
		String type = "phone";
		String description = "iPhone 6 with yellow case";
		String location = "Bruxelles-Midi";
		boolean pickedUp = false;
		boolean archived = false;
		
		LostItem li1 = new LostItem(id, type, description, location, pickedUp, archived);
		LostItem li2 = new LostItem(1, "phone", "iPhone 6 with yellow case", "Bruxelles-Midi", false, false);
		
		if(check == 1){
			assertEquals(true, li1.equals(li2));
		}
		else if(check == 0){
			li1.setId(1);
			li1.setType("accessoires");
			li1.setDescription("Battery charger");
			li1.setLocation("Vilvoorde");
			li1.setPickedUp(true);
			li1.setArchived(true);
			
			assertEquals(true, li1.equals(li2));
		}
	}
	
	@Test
	public void testHashCode(){
		int id = 1;
		String type = "phone";
		String description = "iPhone 6 with yellow case";
		String location = "Bruxelles-Midi";
		boolean pickedUp = false;
		boolean archived = false;
		
		LostItem li1 = new LostItem(id, type, description, location, pickedUp, archived);
		LostItem li2 = new LostItem(1, "phone", "iPhone 6 with yellow case", "Bruxelles-Midi", false, false);
		
		if(check == 1){
			assertEquals(li1.hashCode(), li2.hashCode());
		}
		else if(check == 0){
			li1.setId(1);
			li1.setType("phone");
			li1.setDescription("iPhone 6 with yellow case");
			li1.setLocation("Vilvoorde");
			li1.setPickedUp(true);
			li1.setArchived(true);
		}
	}

}
