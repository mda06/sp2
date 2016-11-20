package com.school.project.model;

import java.sql.Date; 

public class ActiveRailCard {
	private int id;
	private Date validFrom;
	private Date validTo;
	private String from;
	private String to;
	private User inNameOf;
	private User user;
	private RailCard railCard;
	private Boolean archived;
	
	public ActiveRailCard(int id, Date validFrom, Date validTo, String from, String to, User user, User inNameOf, RailCard railCard, Boolean archived) {
		this.id = id;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.from = from;
		this.to = to;
		this.inNameOf = inNameOf;
		this.user = user;
		this.railCard = railCard;
		this.archived = archived;
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
	
	public User getInNameOf() {
		return inNameOf;
	}

	public void setInNameOf(User inNameOf) {
		this.inNameOf = inNameOf;
	}

	public RailCard getRailCard(){
		return railCard;
	}
	
	public void setRailCard(RailCard railCard){
		this.railCard = railCard;
	}
	
	public Boolean isArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + id;
		result = prime * result + ((railCard == null) ? 0 : railCard.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((validFrom == null) ? 0 : validFrom.hashCode());
		result = prime * result + ((validTo == null) ? 0 : validTo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActiveRailCard other = (ActiveRailCard) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (id != other.id)
			return false;
		if (railCard == null) {
			if (other.railCard != null)
				return false;
		} else if (!railCard.equals(other.railCard))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (validFrom == null) {
			if (other.validFrom != null)
				return false;
		} else if (!validFrom.equals(other.validFrom))
			return false;
		if (validTo == null) {
			if (other.validTo != null)
				return false;
		} else if (!validTo.equals(other.validTo))
			return false;
		return true;
	}
	
	public String toString(){
		return String.format("Id: %s\nvalidFrom: %s\nvalidTo: %s\nFrom: %s\nTo: %s\nUser: %s\n", id, validFrom, validTo, from, to, user.toString(), railCard.toString());
	}
	
	//Test case op deze equals geeft me een error
	/*public boolean equals(Object obj){
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
				|| this.from != other.from || this.to != other.to || !user.equals(other.user) || !railCard.equals(other.railCard));
		return true;*/
}
