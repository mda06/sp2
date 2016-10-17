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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
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
		result = prime * result + id;
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
		LostItem other = (LostItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LostItem [id=" + id + ", type=" + type + ", description=" + description + ", location=" + location
				+ ", pickedUp=" + pickedUp + ", archived=" + archived + "]";
	}
	
	
	
}
