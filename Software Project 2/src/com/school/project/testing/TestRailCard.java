package com.school.project.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.school.project.model.RailCard;

public class TestRailCard {

	int check = 1; //1 = true, 0 = false
	@Test
	public void testConstructor() {
		int id = 1;
		String name = "SCHOOL RAILCARD";
		String description = "students under 26, discounted rate, unlimited travel on a fixed route";
		double pricePerMonth = 16.10;
		double pricePer3Month = 45.00;
		double pricePerYear = 161.00; 
		boolean hasFixedRoute = true;
		boolean archived = false;
		
		RailCard rc1 = new RailCard(id, name, description, pricePerMonth, pricePer3Month, pricePerYear, hasFixedRoute, archived);
		
		if(check == 1){
			assertEquals(id, rc1.getId());
			assertEquals(name, rc1.getName());
			assertEquals(description, rc1.getDescription());
			assertEquals(pricePerMonth, rc1.getPricePerMonth(), 0);
			assertEquals(pricePer3Month, rc1.getPricePer3Month(), 0);
			assertEquals(pricePerYear, rc1.getPricePerYear(), 0);
			assertEquals(hasFixedRoute, rc1.isHasFixedRoute());
			assertEquals(archived, rc1.isArchived());
		}
		else if(check == 0){
			rc1.setId(1);
			rc1.setName("JOURNEY RAILCARD");
			rc1.setDescription("commuters, unlimited travel on your route, emplyer's contribution");
			rc1.setPricePerMonth(26.00);
			rc1.setPricePer3Month(73.00);
			rc1.setPricePerYear(260.00);
			rc1.setHasFixedRoute(true);
			rc1.setArchived(false);
			
			assertEquals(id, rc1.getId());
			assertEquals(name, rc1.getName());
			assertEquals(description, rc1.getDescription());
			assertEquals(pricePerMonth, rc1.getPricePerMonth(), 0);
			assertEquals(pricePer3Month, rc1.getPricePer3Month(), 0);
			assertEquals(pricePerYear, rc1.getPricePerYear(), 0);
			assertEquals(hasFixedRoute, rc1.isHasFixedRoute());
			assertEquals(archived, rc1.isArchived());
		}
	}	
	
	@Test
	public void testEquals(){
		int id = 1;
		String name = "SCHOOL RAILCARD";
		String description = "students under 26, discounted rate, unlimited travel on a fixed route";
		double pricePerMonth = 16.10;
		double pricePer3Month = 45.00;
		double pricePerYear = 161.00; 
		boolean hasFixedRoute = true;
		boolean archived = false;
		
		RailCard rc1 = new RailCard(id, name, description, pricePerMonth, pricePer3Month, pricePerYear, hasFixedRoute, archived);
		
		if(check == 1){
			RailCard rc2 = new RailCard(1, "SCHOOL RAILCARD", "students under 26, discounted rate, unlimited travel on a fixed route", 16.10, 45.00, 161.00, true, false);
			assertEquals(true, rc1.equals(rc2));
		}
		else if(check == 0){
			RailCard rc2 = new RailCard(1, "JOURNEY RAILCARD", "commuters, unlimited travel on your route, emplyer's contribution", 26.00, 73.00, 260.00, true, false);
			assertEquals(true, rc1.equals(rc2));
		}
	}
	
	@Test
	public void testHashCode(){
		int id = 1;
		String name = "SCHOOL RAILCARD";
		String description = "students under 26, discounted rate, unlimited travel on a fixed route";
		double pricePerMonth = 16.10;
		double pricePer3Month = 45.00;
		double pricePerYear = 161.00; 
		boolean hasFixedRoute = true;
		boolean archived = false;
		
		RailCard rc1 = new RailCard(id, name, description, pricePerMonth, pricePer3Month, pricePerYear, hasFixedRoute, archived);
		
		if(check == 1){
			RailCard rc2 = new RailCard(1, "SCHOOL RAILCARD", "students under 26, discounted rate, unlimited travel on a fixed route", 16.10, 45.00, 161.00, true, false);
			assertEquals(rc1.hashCode(), rc2.hashCode());
		}
		else if(check == 0){
			RailCard rc2 = new RailCard(1, "JOURNEY RAILCARD", "commuters, unlimited travel on your route, emplyer's contribution", 26.00, 73.00, 260.00, true, false);
			assertEquals(rc1.hashCode(), rc2.hashCode());
		}
	}
}
