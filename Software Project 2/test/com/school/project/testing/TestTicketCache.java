package com.school.project.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.school.project.model.Ticket;
import com.school.project.model.TicketCache;

public class TestTicketCache {

	int check = 1; //1 = true, 0 = false;
	
	@Test
	public void testInstance() {
		if(check == 1){
			assertEquals(TicketCache.getInstance(), TicketCache.getInstance());
		}
		else if(check == 0){
			assertEquals(null, TicketCache.getInstance());
		}
	}
	
	@Test
	public void testAddTicket(){
		Ticket t1 = TestTicket.getFirstTicket();
		TicketCache.getInstance().addTicket(t1);
		
		if(check == 1){
			assertEquals(t1, TicketCache.getInstance().getCache().get(0));
		}
		else if(check == 0){
			Ticket t2 = TestTicket.getSecondTicket();
			assertEquals(t2, TicketCache.getInstance().getCache().get(0));
		}
	}
}
