package com.school.project.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.school.project.model.LostItem;

public class TestLostItem {

	int id = 1;
	String type = "phone";
	String description = "iPhone 6 with yellow case";
	String location = "Bruxelles-Midi";
	boolean pickedUp = false;
	boolean archived = false;
	
	LostItem li1 = new LostItem(id, type, description, location, pickedUp, archived);
	LostItem li2 = new LostItem(1, "phone", "iPhone 6 with yellow case", "Bruxelles-Midi", false, false);
	
	@Test
	public void testConstructor(){
		assertEquals(id, li1.getId());
		assertEquals(type, li1.getType());
		assertEquals(description, li1.getDescription());
		assertEquals(location, li1.getLocation());
		assertEquals(pickedUp, li1.isPickedUp());
		assertEquals(archived, li1.isArchived());
	}
	
	@Test
	public void testEquals(){				
		assertEquals(true, li1.equals(li2));
	}
	
	@Test
	public void testHashCode(){
		assertEquals(li1.hashCode(), li2.hashCode());
	}

}
