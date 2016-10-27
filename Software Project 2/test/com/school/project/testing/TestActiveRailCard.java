package com.school.project.testing;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.school.project.model.ActiveRailCard;
import com.school.project.model.RailCard;
import com.school.project.model.User;
import com.school.project.model.User.Gender;
import com.school.project.model.User.UserType;

public class TestActiveRailCard {

	int check = 1; //1 = true, 0 = false;
	
	@Test
	public void testConstructor() {
		int id = 1;
		Date validFrom = new Date(1477260000000L);
		Date validTo = new Date(1477260000000L);
		String from = "TERNAT";
		String to = "DILBEEK";
		
		User u1 = new User(1, Gender.MALE, UserType.CUSTOMER, "Willem-Jan", "Pattyn", new Date(863395200L), false);
		RailCard rc1 = new RailCard(1, "SCHOOL RAILCARD", "students under 26, discounted rate, unlimited travel on a fixed route", 16.10, 45.00, 161.00, true, false);
		
		ActiveRailCard arc1 = new ActiveRailCard(id, validFrom, validTo, from, to, u1, rc1);
		
		if(check == 1){
			assertEquals(id, arc1.getId());
			assertEquals(validFrom, arc1.getValidFrom());
			assertEquals(validTo, arc1.getValidTo());
			assertEquals(from, arc1.getFrom());
			assertEquals(to, arc1.getTo());
			assertEquals(u1, arc1.getUser());
			assertEquals(rc1, arc1.getRailCard());			
		}
		else if(check == 0){
			User u2 = new User(1, Gender.MALE, UserType.ADMIN, "Marc", "De Hertogh", new Date(-228528000), true);
			RailCard rc2 = new RailCard(1, "JOURNEY RAILCARD", "commuters, unlimited travel on your route, emplyer's contribution", 26.00, 73.00, 260.00, true, false);
			
			arc1.setId(1);
			arc1.setValidFrom(new Date(1477260000000L));
			arc1.setValidTo(new Date(1477260000000L));
			arc1.setFrom("GROOT-BIJGAARDEN");
			arc1.setTo("JETTE");
			arc1.setUser(u2);
			arc1.setRailCard(rc2);
			
			assertEquals(id, arc1.getId());
			assertEquals(validFrom, arc1.getValidFrom());
			assertEquals(validTo, arc1.getValidTo());
			assertEquals(from, arc1.getFrom());
			assertEquals(to, arc1.getTo());
			assertEquals(u1, arc1.getUser());
			assertEquals(rc1, arc1.getRailCard());		
		}
	}
	
	@Test
	public void testEquals(){
		int id = 1;
		Date validFrom = new Date(1477260000000L);
		Date validTo = new Date(1477260000000L);
		String from = "TERNAT";
		String to = "DILBEEK";
		
		User u1 = new User(1, Gender.MALE, UserType.CUSTOMER, "Willem-Jan", "Pattyn", new Date(863395200L), false);
		RailCard rc1 = new RailCard(1, "SCHOOL RAILCARD", "students under 26, discounted rate, unlimited travel on a fixed route", 16.10, 45.00, 161.00, true, false);
		
		ActiveRailCard arc1 = new ActiveRailCard(id, validFrom, validTo, from, to, u1, rc1);
		
		if(check == 1){
			ActiveRailCard arc2 = new ActiveRailCard(1, new Date(1477260000000L), new Date(1477260000000L), "TERNAT", "DILBEEK", new User(1, Gender.MALE, UserType.CUSTOMER, "Willem-Jan", "Pattyn", new Date(863395200L), false), new RailCard(1, "SCHOOL RAILCARD", "students under 26, discounted rate, unlimited travel on a fixed route", 16.10, 45.00, 161.00, true, false));
			assertEquals(true, arc1.equals(arc2));
		}
		else if(check == 0){
			ActiveRailCard arc2 = new ActiveRailCard(2, new Date(1477260000000L), new Date(1477260000000L), "GROOT-BIJGAARDEN", "JETTE", new User(1, Gender.MALE, UserType.ADMIN, "Marc", "De Hertogh", new Date(-228528000), true), new RailCard(1, "JOURNEY RAILCARD", "commuters, unlimited travel on your route, emplyer's contribution", 26.00, 73.00, 260.00, true, false));
			assertEquals(true, arc1.equals(arc2));
		}
	}
	
	@Test
	public void testHashCode(){
		int id = 1;
		Date validFrom = new Date(1477260000000L);
		Date validTo = new Date(1477260000000L);
		String from = "TERNAT";
		String to = "DILBEEK";
		
		User u1 = new User(1, Gender.MALE, UserType.CUSTOMER, "Willem-Jan", "Pattyn", new Date(863395200L), false);
		RailCard rc1 = new RailCard(1, "SCHOOL RAILCARD", "students under 26, discounted rate, unlimited travel on a fixed route", 16.10, 45.00, 161.00, true, false);
		
		ActiveRailCard arc1 = new ActiveRailCard(id, validFrom, validTo, from, to, u1, rc1);
		
		if(check == 1){
			ActiveRailCard arc2 = new ActiveRailCard(1, new Date(1477260000000L), new Date(1477260000000L), "TERNAT", "DILBEEK", new User(1, Gender.MALE, UserType.CUSTOMER, "Willem-Jan", "Pattyn", new Date(863395200L), false), new RailCard(1, "SCHOOL RAILCARD", "students under 26, discounted rate, unlimited travel on a fixed route", 16.10, 45.00, 161.00, true, false));
			assertEquals(arc1.hashCode(), arc2.hashCode());
		}
		else if(check == 0){
			ActiveRailCard arc2 = new ActiveRailCard(2, new Date(1477260000000L), new Date(1477260000000L), "GROOT-BIJGAARDEN", "JETTE", new User(1, Gender.MALE, UserType.ADMIN, "Marc", "De Hertogh", new Date(-228528000), true), new RailCard(1, "JOURNEY RAILCARD", "commuters, unlimited travel on your route, emplyer's contribution", 26.00, 73.00, 260.00, true, false));
			assertEquals(arc1.hashCode(), arc2.hashCode());
		}
	}
}
