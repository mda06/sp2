package com.school.project.model;
import java.sql.Date;

public class TicketSale {
	private int id;
	private Date validFrom;
	private Date validTo;
	private Date soldOn;
	private String from;
	private String to;
	private boolean archived;
	private Ticket ticket;
	private User user;

	public TicketSale(int id, Date validFrom, Date validTo, Date soldOn, String from, String to, boolean archived, Ticket ticket, User user) {
		this.id = id;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.soldOn = soldOn;
		this.from = from;
		this.to = to;
		this.archived = archived;
		this.ticket = ticket;
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
		if(this.id != other.id || this.validFrom != other.validFrom || this.validTo != other.validTo || this.soldOn != other.soldOn
			|| this.from != other.from || this.to != other.to || this.archived != other.archived || this.ticket != other.ticket || this.user != other.user){
			return false;
		}
		return true;
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

	public Date getSoldOn() {
		return soldOn;
	}

	public void setSoldOn(Date soldOn) {
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

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((validFrom == null) ? 0 : validFrom.hashCode());
		result = prime * result + ((validTo == null) ? 0 : validTo.hashCode());
		result = prime * result + ((soldOn == null) ? 0 : soldOn.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		result = prime * result + (archived ? 1231 : 1237);
		result = prime * result + ((ticket == null) ? 0 : ticket.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	
	public String toString(){
		return String.format("Id: %s\nvalidFrom: %s\nvalidTo: %s\nSold on: %s\nFrom: %s\nTo: %s\nArchived: %s\nTicket: %s\nUser %s\n", id, validFrom, validTo, soldOn, from, to, archived, ticket.toString(), user.toString());
	}
	
}
