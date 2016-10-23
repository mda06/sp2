package com.school.project.nmbs;

import java.util.List;

import com.school.project.nmbs.dao.ConnectionDAO;
import com.school.project.nmbs.dao.StationDAO;
import com.school.project.nmbs.model.Connection;
import com.school.project.nmbs.model.Station;
import com.school.project.nmbs.model.StationCache;

//JSON APi
//https://github.com/stleary/JSON-java
public class TestMainNMBS {
	public static void main(String[] args) throws Exception {
		StationDAO.loadCache();
		List<Station> st = StationCache.getInstance().getStations();

		System.out.println("Cache is loaded");
		int i = 0;
		for(Connection c : ConnectionDAO.getConnections(st.get(143), st.get(153)))
			System.out.println("N°" + ++i + " " + c + "\n");
	}
}
