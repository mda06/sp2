package com.school.project.model;

public class LostItem {
	private int id;
	private String type, description, location;
	private boolean pickedUp, archived;
	
	public LostItem(int id, String type, String description, String location, boolean pickedUp, boolean archived) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.location = location;
		this.pickedUp = pickedUp;
		this.archived = archived;
	}
	
	
	
}
