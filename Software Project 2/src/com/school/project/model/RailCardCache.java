package com.school.project.model;

import java.util.ArrayList;
import java.util.List;

public class RailCardCache {
	private List<RailCard> tickets;
	private static RailCardCache instance;
	
	private RailCardCache() {
		tickets = new ArrayList<RailCard>();
	}
	
	public static RailCardCache getInstance() {
		if(instance == null)
			instance = new RailCardCache();
		return instance;
	}
	
	public void addTicket(RailCard t){
		if(t != null)
			tickets.add(t);
	}
	
	public List<RailCard> getCache() {
		return tickets;
	}
}
