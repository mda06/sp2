package com.school.project.util;

import java.util.List;

import com.school.project.model.Ticket;
import com.school.project.model.price.Formula;
import com.school.project.nmbs.dao.ConnectionDAO;
import com.school.project.nmbs.model.Connection;
import com.school.project.nmbs.model.Station;

public class PriceUtil {
	private static PriceUtil instance;
	private Formula formula;

	private PriceUtil() {
		formula = new Formula();
		formula.setFormula(Formula.VAR_PRICE + " + " + Formula.VAR_DST + " * " + Formula.VAR_FIXROUTE + " - " + Formula.VAR_PRICE + " * " + Formula.VAR_FIXROUTE);
	}

	public static PriceUtil getInstance() {
		if (instance == null) instance = new PriceUtil();
		return instance;
	}
	
	public String getStrFormula() {
		return formula.getFormula();
	}
	
	public void setFormula(String f){
		formula.setFormula(f);
	}
	
	public double getPrice(Station s1, Station s2, Ticket t) {
		formula.clearVars();
		if(formula.containsVar(Formula.VAR_DST))
			formula.addVar(Formula.VAR_DST, distanceBetweenStations(s1, s2));
		if(formula.containsVar(Formula.VAR_VAL))
			formula.addVar(Formula.VAR_VAL, (double)t.getValidityPeriod());
		if(formula.containsVar(Formula.VAR_PRICE))
			formula.addVar(Formula.VAR_PRICE, t.getPrice());
		if(formula.containsVar(Formula.VAR_FIXROUTE))
			formula.addVar(Formula.VAR_FIXROUTE, t.isHasFixedRoute() ? 1 : 0.);
		if(formula.containsVar(Formula.VAR_DUR) || formula.containsVar(Formula.VAR_NBSTOPS)) {
			try {
				List<Connection> c = ConnectionDAO.getConnections(s1, s2);
				if(c.size() > 0) {
					Connection connection = c.get(0);
					if(formula.containsVar(Formula.VAR_DUR))
						formula.addVar(Formula.VAR_DUR, (double)connection.getDuration());
					if(formula.containsVar(Formula.VAR_NBSTOPS))
						formula.addVar(Formula.VAR_NBSTOPS, (double)connection.getVias().size());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return formula.parse();
	}
		
	// http://stackoverflow.com/questions/27928/calculate-distance-between-two-latitude-longitude-points-haversine-formula
	public double distanceBetweenStations(Station s1, Station s2) {
		if(s1 == null || s2 == null) return 0;
		double p = Math.PI / 180;
		double lat1 = s1.getLatitude(), lon1 = s1.getLongitude();
		double lat2 = s2.getLatitude(), lon2 = s2.getLongitude();
		double a = 0.5 - Math.cos((lat2 - lat1) * p) / 2 + Math.cos(lat1 * p) * Math.cos(lat2 * p) * (1 - Math.cos((lon2 - lon1) * p)) / 2;
		return 12742 * Math.asin(Math.sqrt(a)); // 2 * R; R = 6371 km
	}
}
