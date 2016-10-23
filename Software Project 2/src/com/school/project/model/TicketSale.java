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

	public TicketSale(int id, Date validFrom, Date validTo, Date soldOn, String from, String to, boolean archived) {
		this.id = id;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.soldOn = soldOn;
		this.from = from;
		this.to = to;
		this.archived = archived;
	}
	
	
}
