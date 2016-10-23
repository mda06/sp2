package com.school.project.model;

import java.sql.Date; 

public class ActiveRailCard {
	private int id;
	private Date validFrom;
	private Date validTo;
	private String from;
	private String to;
	private User user;
	
	public ActiveRailCard(int id, Date validFrom, Date validTo, String from, String to, User user) {
		super();
		this.id = id;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.from = from;
		this.to = to;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
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
		ActiveRailCard other = (ActiveRailCard)obj;
		if(this.id != other.id || this.validFrom != other.validFrom || this.validTo != other.validTo
				|| this.from != other.from || this.to != other.to || !user.equals(other.user));
		return true;
	}
	
	public int hashCode(){
		int result = 1;
		final int prime = 31;
		result = prime * result + id;
		result = prime * result + ((validFrom == null) ? 0 : validFrom.hashCode());
		result = prime * result + ((validTo == null) ? 0 : validTo.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	
	public String toString(){
		return String.format("Id: %s\nvalidFrom: %s\nvalidTo: %s\nFrom: %s\nTo: %s\nUser: %s\n", id, validFrom, validTo, from, to, user.toString());
	}
}
