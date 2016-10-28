package com.school.project.model;

import java.util.ArrayList;
import java.util.List;

import com.school.project.dao.RailCardDAO;

public class RailCardCache {
	private List<RailCard> railcards;
	private static RailCardCache instance;
	
	private RailCardCache() {
		railcards = new ArrayList<RailCard>();
	}
	
	public static RailCardCache getInstance() {
		if(instance == null)
			instance = new RailCardCache();
		return instance;
	}
	
	public void addRailCard(RailCard t){
		if(t != null)
			railcards.add(t);
	}
	
	public List<RailCard> getCache() {
		return railcards;
	}
	
	public void remove(int id){
		for(int i = 0; i < railcards.size(); i++){
			if(id == railcards.get(i).getId()){
				railcards.remove(i);
				break;
			}
		}
	}
	
	public void loadCache(){
		for(RailCard t : RailCardDAO.getInstance().getAll()){
			addRailCard(t);
		}
	}
	
}
