package com.school.project.testing.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.school.project.dao.TicketDAO;
import com.school.project.dao.TicketSaleDAO;
import com.school.project.dao.UserDAO;
import com.school.project.model.Ticket;
import com.school.project.model.TicketSale;
import com.school.project.model.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTicketSaleDAO {

	@Test
	public void testGetTicketSaleIsNull() {
		List<TicketSale> ticketSales = TicketSaleDAO.getInstance().getAll();
		for(int i = 0; i < ticketSales.size(); i++){
			TicketSale result = TicketSaleDAO.getInstance().get(i);
			assertEquals(null, result);
		}
	}
	@Test
	public void testAddTicketSale(){
		List<Ticket> tickets = TicketDAO.getInstance().getAll();
		List<User> users = UserDAO.getInstance().getAll();
		Ticket dummyTicket = tickets.get(tickets.size() - 1);
		User dummyUser = users.get(users.size() - 1);
		
		TicketSale dummyTicketSale = new TicketSale(1, new Date(1477260000000L), new Date(1571868000000L), new Date(1477260000000L), "Ternat", "Jette", false, dummyTicket, dummyUser, 66);
		TicketSaleDAO.getInstance().add(dummyTicketSale);
		List<TicketSale> ticketSales = TicketSaleDAO.getInstance().getAll();
		TicketSale result = ticketSales.get(ticketSales.size() - 1);
		System.out.println("Added " + result);
	}
	@Test
	public void testDeleteTicketSale(){
		List<Ticket> tickets = TicketDAO.getInstance().getAll();
		List<User> users = UserDAO.getInstance().getAll();
		Ticket dummyTicket = tickets.get(tickets.size() - 1);
		User dummyUser = users.get(users.size() - 1);
		
		TicketSale dummyTicketSale = new TicketSale(1, new Date(1477260000000L), new Date(1571868000000L), new Date(1477260000000L), "Groot-Bijgaarden", "Brussel-Luxemburg", false, dummyTicket, dummyUser, 45);
		TicketSaleDAO.getInstance().add(dummyTicketSale);
		List<TicketSale> ticketSales = TicketSaleDAO.getInstance().getAll();
		TicketSale result = ticketSales.get(ticketSales.size() - 1);
		TicketSaleDAO.getInstance().delete(dummyTicketSale);
		System.out.println("Deleted " + result);
	}
	@Test
	public void testUpdateTicketSale(){
		List<Ticket> tickets = TicketDAO.getInstance().getAll();
		List<User> users = UserDAO.getInstance().getAll();
		Ticket dummyTicket = tickets.get(tickets.size() - 2);
		User dummyUser = users.get(users.size() - 2);
		
		List<TicketSale> ticketSales = TicketSaleDAO.getInstance().getAll();
		TicketSale lastTicketSale = ticketSales.get(ticketSales.size() - 1);
		TicketSale uDummyTicketSale = new TicketSale(lastTicketSale.getId(), new Date(1477260000000L), new Date(1571868000000L), new Date(1477260000000L), "Ternat", "Jette", false, dummyTicket, dummyUser, 95);
		TicketSaleDAO.getInstance().update(uDummyTicketSale);
		System.out.println("Updated TicketSale with ID: " + lastTicketSale.getId());
	}
}
