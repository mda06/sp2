package com.school.project.model;

public class Address {
	private int id, postalCode, city, streetline1, streetline2;
	private String country;
	private boolean archived;
	
	public Address(int id, int postalCode, int city, int streetline1, int streetline2, String country,
			boolean archived) {
		super();
		this.id = id;
		this.postalCode = postalCode;
		this.city = city;
		this.streetline1 = streetline1;
		this.streetline2 = streetline2;
		this.country = country;
		this.archived = archived;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public int getStreetline1() {
		return streetline1;
	}
	public void setStreetline1(int streetline1) {
		this.streetline1 = streetline1;
	}
	public int getStreetline2() {
		return streetline2;
	}
	public void setStreetline2(int streetline2) {
		this.streetline2 = streetline2;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
		Address other = (Address) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", postalCode=" + postalCode + ", city=" + city + ", streetline1=" + streetline1
				+ ", streetline2=" + streetline2 + ", country=" + country + ", archived=" + archived + "]";
	}
	
	
	
}
