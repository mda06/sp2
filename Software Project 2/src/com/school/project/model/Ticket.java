package com.school.project.model;

public class Ticket {
	private int id;
	private String name;
	private String description;
	private double price;
	private int validityPeriod;
	private boolean hasFixedRoute;
	private boolean archived;
	
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
	
	public String toString(){
		return String.format("Id: %s\n Name: %s\n Description: %s\n Price: %s\n Validity Period: %s\n Has", id, name, description, price, validityPeriod);
	}
	
}
