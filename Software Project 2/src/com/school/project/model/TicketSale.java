package com.school.project.model;

public class TicketSale extends Ticket {
	private String validFrom;
	private String validTo;
	private String soldOn;
	private String from;
	private String to;
	private User user;
	
	public TicketSale(User user, int id, String name, String description, double price, int validityPeriod, boolean hasFixedRoute, boolean archived, String validFrom, String validTo, String soldOn, String from, String to){
		super(id, name, description, price, validityPeriod, hasFixedRoute, archived);
		this.user = user;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.soldOn = soldOn;
		this.from = from;
		this.to = to;
	}

	public String getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	public String getValidTo() {
		return validTo;
	}

	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}

	public String getSoldOn() {
		return soldOn;
	}

	public void setSoldOn(String soldOn) {
		this.soldOn = soldOn;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		TicketSale other = (TicketSale)obj;
		if(this.id != other.id || this.validFrom != other.validFrom || this.validTo != other.validTo
			|| this.soldOn != other.soldOn || this.from != other.from || this.to != other.to 
			|| this.archived != other.archived){
			return false;
		}
		return true;
	}
	
	
}
