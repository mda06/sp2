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
		RailCard rc1 = new RailCard(1, "SCHOOL RAILCARD", "students under 26, discounted rate, unlimited travel on a fixed route", 16.10, 45.00, 161.00, true, false);
		RailCardCache.getInstance().addTicket(rc1);
		
		if(check == 1){
			assertEquals(rc1, RailCardCache.getInstance().getCache().get(0));
		}
		else if(check == 0){
			RailCard rc2 = new RailCard(1, "JOURNEY RAILCARD", "commuters, unlimited travel on your route, emplyer's contribution", 26.00, 73.00, 260.00, true, false);
			assertEquals(rc2, RailCardCache.getInstance().getCache().get(0));
		}
	}
}
