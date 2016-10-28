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
	
	public void remove(int id){
		for(int i = 0; i < tickets.size(); i++){
			if(id == tickets.get(i).getId()){
				tickets.remove(i);
			}
		}
	}
	
	public void loadCache(){
		for(RailCard t : tickets){
			RailCardCache.getInstance().addTicket(t);
		}
	}
	
	public void update(RailCard t){
		if(t == null){ return; }
		RailCard other = tickets.get(t.getId());
		if(other.getPricePerMonth() != t.getPricePerMonth()){
			RailCardCache.getInstance().remove(other.getId());
			RailCardCache.getInstance().addTicket(t);
		}
		if(other.getPricePer3Month() != t.getPricePer3Month()){
			RailCardCache.getInstance().remove(other.getId());
			RailCardCache.getInstance().addTicket(t);
		}
		if(other.getPricePerYear() != t.getPricePerYear()){
			RailCardCache.getInstance().remove(other.getId());
			RailCardCache.getInstance().addTicket(t);
		}
		
		
	}
	
	
}
