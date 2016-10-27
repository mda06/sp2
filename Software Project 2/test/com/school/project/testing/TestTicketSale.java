package com.school.project.testing;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.school.project.model.Ticket;
import com.school.project.model.TicketSale;
import com.school.project.model.User;
import com.school.project.model.User.Gender;
import com.school.project.model.User.UserType;

public class TestTicketSale {

	int check = 1; //1 = true, 0 = false;
	
	@Test
	public void testConstructor() {
		int id = 1;
		Date validFrom = new Date(1477260000000L);
		Date validTo = new Date(1571868000000L);
		Date soldOn = new Date(1477260000000L);
		String from = "DILBEEK";
		String to = "BRUXELLES-CENTRAL";
		boolean archived = false;
		
		User u1 = new User(1, Gender.MALE, UserType.CUSTOMER, "Willem-Jan", "Pattyn", new Date(863395200), archived);
		Ticket t1 = new Ticket(1, "STANDARD TICKET", "All days, no limitation", 4.50, 1, true, false);
		
		TicketSale ts1 = new TicketSale(id, validFrom, validTo, soldOn, from, to, archived, t1, u1);
		
		if(check == 1){
			assertEquals(id, ts1.getId());
			assertEquals(validFrom, ts1.getValidFrom());
			assertEquals(validTo, ts1.getValidTo());
			assertEquals(soldOn, ts1.getSoldOn());
			assertEquals(from, ts1.getFrom());
			assertEquals(to, ts1.getTo());
			assertEquals(archived, ts1.isArchived());
			assertEquals(u1, ts1.getUser());
			assertEquals(t1, ts1.getTicket());
		}
		else if(check == 0){
			User u2 = new User(1, Gender.MALE, UserType.ADMIN, "Marc", "De Hertogh", new Date(-228528000), true);
			Ticket t2 = new Ticket(1, "SENIOR TICKET", "For people aged 65 and over", 3.50, 1, true, false);
			
			ts1.setId(1);
			ts1.setValidFrom(new Date(1473890400000L));
			ts1.setValidTo(new Date(1568498400000L));
			ts1.setSoldOn(new Date(1473890400000L));
			ts1.setFrom("BRUXELLES-SCHUMAN");
			ts1.setTo("ALOST");
			ts1.setArchived(false);
			ts1.setTicket(t2);
			ts1.setUser(u2);

			assertEquals(id, ts1.getId());
			assertEquals(validFrom, ts1.getValidFrom());
			assertEquals(validTo, ts1.getValidTo());
			assertEquals(soldOn, ts1.getSoldOn());
			assertEquals(from, ts1.getFrom());
			assertEquals(to, ts1.getTo());
			assertEquals(archived, ts1.isArchived());
			assertEquals(u1, ts1.getUser());
			assertEquals(t1, ts1.getTicket());
		}
	}
	
	@Test
	public void testEquals(){
		int id = 1;
		Date validFrom = new Date(1477260000000L);
		Date validTo = new Date(1571868000000L);
		Date soldOn = new Date(1477260000000L);
		String from = "DILBEEK";
		String to = "BRUXELLES-CENTRAL";
		boolean archived = false;
		
		User u1 = new User(1, Gender.MALE, UserType.CUSTOMER, "Willem-Jan", "Pattyn", new Date(863395200), false);
		Ticket t1 = new Ticket(1, "STANDARD TICKET", "All days, no limitation", 4.50, 1, true, false);
		
		TicketSale ts1 = new TicketSale(id, validFrom, validTo, soldOn, from, to, archived, t1, u1);
		
		if(check == 1){
			TicketSale ts2 = new TicketSale(1, new Date(1477260000000L), new Date(1571868000000L), new Date(1477260000000L), "DILBEEK", "BRUXELLES-CENTRAL", false, new Ticket(1, "STANDARD TICKET", "All days, no limitation", 4.50, 1, true, false), new User(1, Gender.MALE, UserType.CUSTOMER, "Willem-Jan", "Pattyn", new Date(863395200), false));
			assertEquals(true, ts1.equals(ts2));
		}
		else if(check == 0){
			TicketSale ts2 = new TicketSale(1, new Date(1473890400000L), new Date(1568498400000L), new Date(1473890400000L), "BRUXELLES-SCHUMAN", "ALOST", false, new Ticket(1, "SENIOR TICKET", "For people aged 65 and over", 3.50, 1, true, false), new User(1, Gender.MALE, UserType.ADMIN, "Marc", "De Hertogh", new Date(-228528000), true));
			assertEquals(true, ts1.equals(ts2));
		}
	}
	
	@Test
	public void testHashCode(){
		int id = 1;
		Date validFrom = new Date(1477260000000L);
		Date validTo = new Date(1571868000000L);
		Date soldOn = new Date(1477260000000L);
		String from = "DILBEEK";
		String to = "BRUXELLES-CENTRAL";
		boolean archived = false;
		
		User u1 = new User(1, Gender.MALE, UserType.CUSTOMER, "Willem-Jan", "Pattyn", new Date(863395200), false);
		Ticket t1 = new Ticket(1, "STANDARD TICKET", "All days, no limitation", 4.50, 1, true, false);
		
		TicketSale ts1 = new TicketSale(id, validFrom, validTo, soldOn, from, to, archived, t1, u1);
		
		if(check == 1){
			TicketSale ts2 = new TicketSale(1, new Date(1477260000000L), new Date(1571868000000L), new Date(1477260000000L), "DILBEEK", "BRUXELLES-CENTRAL", false, new Ticket(1, "STANDARD TICKET", "All days, no limitation", 4.50, 1, true, false), new User(1, Gender.MALE, UserType.CUSTOMER, "Willem-Jan", "Pattyn", new Date(863395200), false));
			assertEquals(ts1.hashCode(), ts2.hashCode());
		}
		else if(check == 0){
			TicketSale ts2 = new TicketSale(1, new Date(1473890400000L), new Date(1568498400000L), new Date(1473890400000L), "BRUXELLES-SCHUMAN", "ALOST", false, new Ticket(1, "SENIOR TICKET", "For people aged 65 and over", 3.50, 1, true, false), new User(1, Gender.MALE, UserType.ADMIN, "Marc", "De Hertogh", new Date(-228528000), true));
			assertEquals(ts1.hashCode(), ts2.hashCode());
		}
	}
}
