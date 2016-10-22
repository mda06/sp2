package com.school.project.model;

import java.util.ArrayList;
import java.util.List;

public class TicketCache {
	private List<Ticket> tickets;
	private static TicketCache instance;
	
	private TicketCache() {
		tickets = new ArrayList<Ticket>();
	}
	
	public static TicketCache getInstance() {
		if(instance == null)
			instance = new TicketCache();
		return instance;
	}
	
	public void addTicket(Ticket t){
		if(t != null)
			tickets.add(t);
	}
	
	public List<Ticket> getCache() {
		return tickets;
	}
}
