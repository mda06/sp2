package com.school.project.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.school.project.model.RailCard;
import com.school.project.model.RailCardCache;

public class TestRailCardCache {

	int check = 1; //1 = true, 0 = false
	
	@Test
	public void testInstance() {
		
		if(check == 1){			
			assertEquals(RailCardCache.getInstance(), RailCardCache.getInstance());
		}
		else if(check == 0){
			assertEquals(null, RailCardCache.getInstance());
		}
	}
	
	@Test
	public void testAddTicket(){		
		RailCard rc1 = TestRailCard.getFirstRailCard();
		RailCardCache.getInstance().addRailCard(rc1);
		
		if(check == 1){
			assertEquals(rc1, RailCardCache.getInstance().getCache().get(0));
		}
		else if(check == 0){
			RailCard rc2 = TestRailCard.getSecondRailCard();
			assertEquals(rc2, RailCardCache.getInstance().getCache().get(0));
		}
	}
}
