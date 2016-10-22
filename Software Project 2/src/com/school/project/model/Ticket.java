package com.school.project.model;

import java.util.Objects;

public class Ticket {
	protected int id;
	protected String name;
	protected String description;
	protected double price;
	protected int validityPeriod;
	protected boolean hasFixedRoute;
	protected boolean archived;
	
	public Ticket(int id, String name, String description, double price, int validityPeriod, boolean hasFixedRoute,
			boolean archived) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.validityPeriod = validityPeriod;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(int validityPeriod) {
		this.validityPeriod = validityPeriod;
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
		Ticket other = (Ticket)obj;
		if(this.id != other.id || this.name != other.name || this.description != other.description
				|| this.price != other.price || this.validityPeriod != other.validityPeriod
				|| this.hasFixedRoute != other.hasFixedRoute || this.archived != other.archived){
			return false;
		}
		
		return true;
	}
	
	public int hashCode(){
		int result = 1;
		int prime = 31;
		result = prime * result + id;
		result = prime * result + Objects.hashCode(name);
		result = prime * result + Objects.hashCode(description);
		result = prime * result + (int) price;
		result = prime * result + validityPeriod;
		result = prime * result + (hasFixedRoute ? 0 : 1);
		result = prime * result + (archived ? 0 : 1);		
		return result;
	}
	
	public String toString(){
		return String.format("Id: %s\nName: %s\nDescription: %s\nPrice: %s\nValidity Period: %s\nHasFixedRoute: %s\nArchived: %s", id, name, description, price, validityPeriod,(hasFixedRoute ? "True" : "False"), (archived ? "True" : "False"));
	}
	
}
