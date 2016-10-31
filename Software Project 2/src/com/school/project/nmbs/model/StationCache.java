package com.school.project.nmbs.model;

import java.util.ArrayList;
import java.util.List;

public class StationCache {
	private List<Station> stations;
	private static StationCache instance;
	
	private StationCache() {
		stations = new ArrayList<Station>();
	}
	
	public static StationCache getInstance() {
		if(instance == null) instance = new StationCache();
		return instance;
	}
	
	public void addStation(Station station) {
		stations.add(station);
	}
	
	public List<Station> getStations() {
		return stations;
	}
	
	public String[] getStationsNames() {
		String[] arr = new String[stations.size()];
		for(int i = 0; i < stations.size(); i++)
			arr[i] = stations.get(i).getName();
		return arr;
	}
	
	public Station getStationWithID(String id) {
		for(Station st : stations) {
			if(st.getId().equals(id))
				return st;
		}
		return null;
	}
}
