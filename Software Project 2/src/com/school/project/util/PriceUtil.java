package com.school.project.util;

import com.school.project.model.Ticket;
import com.school.project.nmbs.model.Station;

public class PriceUtil {
	public static double getPrice(Station s1, Station s2, Ticket t) {
		if(!t.isHasFixedRoute()) return t.getPrice();
		return distanceBetweenStations(s1, s2) * t.getPrice();
	}
		
	// http://stackoverflow.com/questions/27928/calculate-distance-between-two-latitude-longitude-points-haversine-formula
	public static double distanceBetweenStations(Station s1, Station s2) {
		double p = Math.PI / 180;
		double lat1 = s1.getLatitude(), lon1 = s1.getLongitude();
		double lat2 = s2.getLatitude(), lon2 = s2.getLongitude();
		double a = 0.5 - Math.cos((lat2 - lat1) * p) / 2 + Math.cos(lat1 * p) * Math.cos(lat2 * p) * (1 - Math.cos((lon2 - lon1) * p)) / 2;
		return 12742 * Math.asin(Math.sqrt(a)); // 2 * R; R = 6371 km
	}
}
