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
		Ticket t1 = new Ticket(1, "STANDARD TICKET", "All days, no limitation", 4.50, 1, true, false);
		TicketCache.getInstance().addTicket(t1);
		
		if(check == 1){
			assertEquals(t1, TicketCache.getInstance().getCache().get(0));
		}
		else if(check == 0){
			Ticket t2 = new Ticket(1, "SENIOR TICKET", "For people aged 65 and over", 3.50, 1, true, false);
			assertEquals(t2, TicketCache.getInstance().getCache().get(0));
		}
	}
}
