package com.school.project.model;

public class RailCard {
	private int id;
	private String name;
	private String description;
	private double pricePerMonth;
	private double pricePer3Month;
	private double pricePerYear;
	private boolean hasFixedRoute;
	private boolean archived;
	
	public RailCard(int id, String name, String description, double pricePerMonth, double pricePer3Month,
			double pricePerYear, boolean hasFixedRoute, boolean archived) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.pricePerMonth = pricePerMonth;
		this.pricePer3Month = pricePer3Month;
		this.pricePerYear = pricePerYear;
		this.hasFixedRoute = hasFixedRoute;
		this.archived = archived;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPricePerMonth() {
		return pricePerMonth;
	}

	public void setPricePerMonth(double pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}

	public double getPricePer3Month() {
		return pricePer3Month;
	}

	public void setPricePer3Month(double pricePer3Month) {
		this.pricePer3Month = pricePer3Month;
	}

	public double getPricePerYear() {
		return pricePerYear;
	}

	public void setPricePerYear(double pricePerYear) {
		this.pricePerYear = pricePerYear;
	}

	public boolean isHasFixedRoute() {
		return hasFixedRoute;
	}

	public void setHasFixedRoute(boolean hasFixedRoute) {
		this.hasFixedRoute = hasFixedRoute;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}
	
	
}
