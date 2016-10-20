package com.school.project.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.school.project.model.Address;

public class TestAddress {
	int id = 1;
	String streetline1 = "Zonnekouter 18";
	String streetline2 = " ";
	String city = "Dilbeek";
	int postalCode = 1700;
	String country = "Belgium";
	boolean archived = false;
	
	Address a1 = new Address(id, streetline1, streetline2, city, postalCode, country, archived);
	Address a2 = new Address(1, "Zonnekouter 18", " ", "Dilbeek", 1700, "Belgium", false);
	
	@Test
	public void testConstructor() {			
		assertEquals(streetline1, a1.getStreetline1());
		assertEquals(streetline2, a1.getStreetline2());
		assertEquals(city, a1.getCity());
		assertEquals(postalCode, a1.getPostalCode());
		assertEquals(country, a1.getCountry());
	}
	
	@Test
	public void testEquals(){				
		assertEquals(true, a1.equals(a2));
	}
	
	@Test
	public void testHashCode(){
		assertEquals(a1.hashCode(), a2.hashCode());
	}
}
