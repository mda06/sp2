package com.school.project.model;

import java.util.Objects;

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
	
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(getClass() != obj.getClass()){
			return false;
		}
		RailCard other = (RailCard)obj;
		if(this.id != other.id){
			return false;
		}
		if(this.name == null){
			if(other.name != null){
				return false;
			}
			else if(!name.equals(other.name)){
				return false;
			}
		}
		if(this.description == null){
			if(other.description != null){
				return false;
			}
			else if(!description.equals(other.description)){
				return false;
			}
		}
		if(this.pricePerMonth != other.pricePerMonth){
			return false;
		}
		if(this.pricePer3Month != other.pricePer3Month){
			return false;
		}
		if(this.pricePerYear != other.pricePerYear){
			return false;
		}
		if(this.hasFixedRoute != other.hasFixedRoute){
			return false;
		}
		if(this.archived != other.archived){
			return false;
		}
		return true;
	}
	
	public int hashCode(){
		int result = 1;
		final int prime = 31;
		result = prime * result + id;
		result = prime * result + Objects.hashCode(name);
		result = prime * result + Objects.hashCode(description);
		result = prime * result + (int)pricePerMonth;
		result = prime * result + (int)pricePer3Month;
		result = prime * result + (int)pricePerYear;
		result = prime * result + (hasFixedRoute ? 0 : 1);
		result = prime * result + (archived ? 0 : 1);
		return result;
	}
	
	public String toString() {
		return String.format("Id: %s\nName %s\nDescription: %s\nPrice per month: %s\nPrice per 3 month: %s\nPrice per year: %s\nHas fixed route: %s\nArchived: %s\n", id, name, description, pricePerMonth, pricePer3Month, pricePerYear, (hasFixedRoute ? "True" : "False"), (archived ? "True" : "False"));
	}

}
