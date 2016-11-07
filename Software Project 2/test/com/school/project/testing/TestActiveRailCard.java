package com.school.project.testing;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.school.project.model.ActiveRailCard;
import com.school.project.model.RailCard;
import com.school.project.model.User;

public class TestActiveRailCard {

	int check = 0; //1 = true, 0 = false;
	
	public static ActiveRailCard getFirstActiveRailCard(){
		return new ActiveRailCard(1, new Date(1477260000000L), new Date(1477260000000L), "TERNAT", "DILBEEK", TestUser.getFirstUser(), TestUser.getSecondUser(), TestRailCard.getFirstRailCard(), false);
	}
	
	public static ActiveRailCard getSecondActiveRailCard(){
		return new ActiveRailCard(2, new Date(1477260000000L), new Date(1477260000000L), "GROOT-BIJGAARDEN", "JETTE", TestUser.getSecondUser(), TestUser.getFirstUser(), TestRailCard.getSecondRailCard(), false);
	}
	
	@Test
	public void testConstructor() {
		int id = 1;
		Date validFrom = new Date(1477260000000L);
		Date validTo = new Date(1477260000000L);
		String from = "TERNAT";
		String to = "DILBEEK";
		boolean archived = false;
		
		User u1 = TestUser.getFirstUser();
		User u2 = TestUser.getSecondUser();
		RailCard rc1 = TestRailCard.getFirstRailCard();
		
		ActiveRailCard arc1 = TestActiveRailCard.getFirstActiveRailCard();
		
		if(check == 1){
			assertEquals(id, arc1.getId());
			assertEquals(validFrom, arc1.getValidFrom());
			assertEquals(validTo, arc1.getValidTo());
			assertEquals(from, arc1.getFrom());
			assertEquals(to, arc1.getTo());
			assertEquals(u1, arc1.getUser());
			assertEquals(u2, arc1.getInNameOf());
			assertEquals(rc1, arc1.getRailCard());
			assertEquals(archived, arc1.isArchived());
		}
		else if(check == 0){
			RailCard rc2 = TestRailCard.getSecondRailCard();
			
			arc1.setId(2);
			arc1.setValidFrom(new Date(1477260000000L));
			arc1.setValidTo(new Date(1477260000000L));
			arc1.setFrom("GROOT-BIJGAARDEN");
			arc1.setTo("JETTE");
			arc1.setUser(u2);
			arc1.setInNameOf(u1);
			arc1.setRailCard(rc2);
			arc1.setArchived(false);
			
			assertEquals(id, arc1.getId());
			assertEquals(validFrom, arc1.getValidFrom());
			assertEquals(validTo, arc1.getValidTo());
			assertEquals(from, arc1.getFrom());
			assertEquals(to, arc1.getTo());
			assertEquals(u1, arc1.getUser());
			assertEquals(u2, arc1.getInNameOf());
			assertEquals(rc1, arc1.getRailCard());
			assertEquals(archived, arc1.isArchived());	
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
