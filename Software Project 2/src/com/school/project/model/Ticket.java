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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (archived ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (hasFixedRoute ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + validityPeriod;
		return result;
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
		if(this.price != other.price){
			return false;
		}
		if(this.validityPeriod != other.validityPeriod){
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

	public String toString(){
		return String.format("Id: %s\nName: %s\nDescription: %s\nPrice: %s\nValidity Period: %s\nHas fixed route: %s\nArchived: %s\n", id, name, description, price, validityPeriod, (hasFixedRoute ? "True" : "False"),(archived ? "True" : "False"));
	}
	
}
