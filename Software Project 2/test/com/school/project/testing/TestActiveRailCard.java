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
	
	public static ActiveRailCard getFirstActiveRailCard(){
		return new ActiveRailCard(1, new Date(1477260000000L), new Date(1477260000000L), "TERNAT", "DILBEEK", TestUser.getFirstUser(), TestRailCard.getFirstRailCard());
	}
	
	public static ActiveRailCard getSecondActiveRailCard(){
		return new ActiveRailCard(2, new Date(1477260000000L), new Date(1477260000000L), "GROOT-BIJGAARDEN", "JETTE", TestUser.getSecondUser(), TestRailCard.getSecondRailCard());
	}
	
	@Test
	public void testConstructor() {
		int id = 1;
		Date validFrom = new Date(1477260000000L);
		Date validTo = new Date(1477260000000L);
		String from = "TERNAT";
		String to = "DILBEEK";
		
		User u1 = TestUser.getFirstUser();
		RailCard rc1 = TestRailCard.getFirstRailCard();
		
		ActiveRailCard arc1 = TestActiveRailCard.getFirstActiveRailCard();
		
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
			User u2 = TestUser.getSecondUser();
			RailCard rc2 = TestRailCard.getSecondRailCard();
			
			arc1.setId(2);
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
		ActiveRailCard arc1 = TestActiveRailCard.getFirstActiveRailCard();
		
		if(check == 1){
			ActiveRailCard arc2 = TestActiveRailCard.getFirstActiveRailCard();
			assertEquals(true, arc1.equals(arc2));
		}
		else if(check == 0){
			ActiveRailCard arc2 = TestActiveRailCard.getSecondActiveRailCard();
			assertEquals(true, arc1.equals(arc2));
		}
	}
	
	@Test
	public void testHashCode(){
		ActiveRailCard arc1 = TestActiveRailCard.getFirstActiveRailCard();
		
		if(check == 1){
			ActiveRailCard arc2 = TestActiveRailCard.getFirstActiveRailCard();
			assertEquals(arc1.hashCode(), arc2.hashCode());
		}
		else if(check == 0){
			ActiveRailCard arc2 = TestActiveRailCard.getSecondActiveRailCard();
			assertEquals(arc1.hashCode(), arc2.hashCode());
		}
	}
}
