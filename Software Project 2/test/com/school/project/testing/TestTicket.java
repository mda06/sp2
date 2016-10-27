package com.school.project.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.school.project.model.Ticket;

public class TestTicket {

	int check = 1; //1 = true, 0 = false
	
	@Test
	public void testConstructor(){
		int id = 1;
		String name = "STANDARD TICKET";
		String description = "All days, no limitation";
		double price = 4.50;
		int validityPeriod = 1;
		boolean hasFixedRoute = true;
		boolean archived = false;
		
		Ticket t1 = new Ticket(1, name, description, price, validityPeriod, hasFixedRoute, archived);
		
		if(check == 1){
			assertEquals(id, t1.getId());
			assertEquals(name, t1.getName());
			assertEquals(description, t1.getDescription());
			assertEquals(price, t1.getPrice(), 0);
			assertEquals(validityPeriod, t1.getValidityPeriod());
			assertEquals(hasFixedRoute, t1.isHasFixedRoute());
			assertEquals(archived, t1.isArchived());
		}
		else if(check == 0){
			t1.setId(2);
			t1.setName("SENIOR TICKET");
			t1.setDescription("For people aged 65 and over");
			t1.setPrice(3.50);
			t1.setValidityPeriod(1);
			t1.setHasFixedRoute(true);
			t1.setArchived(false);

			assertEquals(id, t1.getId());
			assertEquals(name, t1.getName());
			assertEquals(description, t1.getDescription());
			assertEquals(price, t1.getPrice(), 0);
			assertEquals(validityPeriod, t1.getValidityPeriod());
			assertEquals(hasFixedRoute, t1.isHasFixedRoute());
			assertEquals(archived, t1.isArchived());
		}
	}
	
	@Test
	public void testEquals(){
		int id = 1;
		String name = "STANDARD TICKET";
		String description = "All days, no limitation";
		double price = 4.50;
		int validityPeriod = 1;
		boolean hasFixedRoute = true;
		boolean archived = false;
		
		Ticket t1 = new Ticket(id, name, description, price, validityPeriod, hasFixedRoute, archived);

		if(check == 1){
			Ticket t2 = new Ticket(1, "STANDARD TICKET", "All days, no limitation", 4.50, 1, true, false);
			assertEquals(true, t1.equals(t2));
		}
		else if(check == 0){
			Ticket t2 = new Ticket(1, "SENIOR TICKET", "For people aged 65 and over", 3.50, 1, true, false);
			assertEquals(true, t1.equals(t2));
		}
	}
	
	@Test
	public void testHashCode(){
		int id = 1;
		String name = "STANDARD TICKET";
		String description = "All days, no limitation";
		double price = 4.50;
		int validityPeriod = 1;
		boolean hasFixedRoute = true;
		boolean archived = false;
		
		Ticket t1 = new Ticket(id, name, description, price, validityPeriod, hasFixedRoute, archived);
		
		if(check == 1){
			Ticket t2 = new Ticket(1, "STANDARD TICKET", "All days, no limitation", 4.50, 1, true, false);
			assertEquals(t1.hashCode(), t2.hashCode());
		}
		else if(check == 0){
			Ticket t2 = new Ticket(1, "SENIOR TICKET", "For people aged 65 and over", 3.50, 1, true, false);
			assertEquals(t1.hashCode(), t2.hashCode());
		}
	}
}
