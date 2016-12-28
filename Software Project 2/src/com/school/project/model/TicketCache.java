package com.school.project.model;

import java.util.ArrayList;
import java.util.List;

import com.school.project.dao.TicketDAO;
import com.school.project.gui.controller.listener.CacheUpdateListener;

public class TicketCache {
	private List<Ticket> tickets;
	private List<CacheUpdateListener<Ticket>> listeners;
	private static TicketCache instance;

	private TicketCache() {
		tickets = new ArrayList<Ticket>();
		listeners = new ArrayList<>();
	}

	public static TicketCache getInstance() {
		if (instance == null) instance = new TicketCache();
		return instance;
	}

	public Ticket getTicket(int id) {
		for (int i = 0; i < tickets.size(); i++) {
			if (id == tickets.get(i).getId()) { return tickets.get(i); }
		}
		return null;
	}
	
	public void addListener(CacheUpdateListener<Ticket> list) {
		if(list != null)
			listeners.add(list);
	}
	
	public void removeListener(CacheUpdateListener<Ticket> list) {
		listeners.remove(list);
	}

	public void addTicket(Ticket t) {
		if (t != null) {
			tickets.add(t);
			listeners.stream().forEach((c) -> c.added(t));
		}
	}

	public List<Ticket> getCache() {
		return tickets;
	}

	public void remove(int id) {
		for (int i = 0; i < tickets.size(); i++) {
			if (id == tickets.get(i).getId()) {
				final Ticket t = tickets.get(i);
				listeners.stream().forEach((c) -> c.removed(t));
				tickets.remove(i);
				break;
			}
		}
	}

	public void loadCache() {
		for (Ticket t : TicketDAO.getInstance().getAll()) {
			addTicket(t);
		}
	}
}
