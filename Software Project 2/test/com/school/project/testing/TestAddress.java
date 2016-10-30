package com.school.project.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.school.project.model.Address;

public class TestAddress {
	
	int check = 1; //1 = true, 0 = false
	
	public static Address getFirstAddress(){
		return new Address(1, "Zonnekouter 18", " ", "Dilbeek", 1700, "Belgium", false);
	}
	
	public static Address getSecondAddress(){
		return new Address(1, "Nijverheidskaai 170", "Bus 5", "Anderlecht", 1070, "Belgium", false);
	}
	
	@Test
	public void testConstructor() {		
		int id = 1;
		String streetline1 = "Zonnekouter 18";
		String streetline2 = " ";
		String city = "Dilbeek";
		int postalCode = 1700;
		String country = "Belgium";
		boolean archived = false;
		
		Address a1 = TestAddress.getFirstAddress();
		
		if(check == 1){
			assertEquals(id, a1.getId());
			assertEquals(streetline1, a1.getStreetline1());
			assertEquals(streetline2, a1.getStreetline2());
			assertEquals(city, a1.getCity());
			assertEquals(postalCode, a1.getPostalCode());
			assertEquals(country, a1.getCountry());
			assertEquals(archived, a1.isArchived());
		}
		else if(check == 0){
			a1.setId(1);
			a1.setStreetline1("Nijverheidskaai 170");
			a1.setStreetline2("Bus 5");
			a1.setCity("Anderlecht");
			a1.setPostalCode(1070);
			a1.setCountry("Belgium");
			a1.setArchived(false);
			
			assertEquals(id, a1.getId());
			assertEquals(streetline1, a1.getStreetline1());
			assertEquals(streetline2, a1.getStreetline2());
			assertEquals(city, a1.getCity());
			assertEquals(postalCode, a1.getPostalCode());
			assertEquals(country, a1.getCountry());
			assertEquals(archived, a1.isArchived());
		}
	}
	
	@Test
	public void testEquals(){		
		Address a1 = TestAddress.getFirstAddress();
		Address a2 = TestAddress.getFirstAddress();
		
		if(check == 1)
			assertEquals(true, a1.equals(a2));
		else if(check == 0){
			a2.setId(TestAddress.getSecondAddress().getId());
			a2.setStreetline1(TestAddress.getSecondAddress().getStreetline1());
			a2.setStreetline2(TestAddress.getSecondAddress().getStreetline2());
			a2.setCity(TestAddress.getSecondAddress().getCity());
			a2.setPostalCode(TestAddress.getSecondAddress().getPostalCode());
			a2.setCountry(TestAddress.getSecondAddress().getCountry());
			a2.setArchived(TestAddress.getSecondAddress().isArchived());
			
			assertEquals(true, a1.equals(a2));
		}
	}
	
	@Test
	public void testHashCode(){		
		Address a1 = TestAddress.getFirstAddress();
		Address a2 = TestAddress.getFirstAddress();
		
		if(check == 1){
			assertEquals(a1.hashCode(), a2.hashCode());
		}
		else if(check == 0){
			a2.setId(TestAddress.getSecondAddress().getId());
			a2.setStreetline1(TestAddress.getSecondAddress().getStreetline1());
			a2.setStreetline2(TestAddress.getSecondAddress().getStreetline2());
			a2.setCity(TestAddress.getSecondAddress().getCity());
			a2.setPostalCode(TestAddress.getSecondAddress().getPostalCode());
			a2.setCountry(TestAddress.getSecondAddress().getCountry());
			a2.setArchived(TestAddress.getSecondAddress().isArchived());
			
			assertEquals(a1.hashCode(), a2.hashCode());
		}
	}
}
