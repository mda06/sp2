package com.school.project.model;

public class Address {
	private int id;
	private String country, city, streetline1, streetline2, postalCode;
	private boolean archived;
	
	public Address(int id, String streetline1, String streetline2, String city, String postalCode, String country,
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreetline1() {
		return streetline1;
	}
	public void setStreetline1(String streetline1) {
		this.streetline1 = streetline1;
	}
	public String getStreetline2() {
		return streetline2;
	}
	public void setStreetline2(String streetline2) {
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
		result = prime * result + (archived ? 1231 : 1237);
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + id;
		result = prime * result + postalCode.hashCode();
		result = prime * result + ((streetline1 == null) ? 0 : streetline1.hashCode());
		result = prime * result + ((streetline2 == null) ? 0 : streetline2.hashCode());
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
		if (archived != other.archived)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id != other.id)
			return false;
		if (postalCode != other.postalCode)
			return false;
		if (streetline1 == null) {
			if (other.streetline1 != null)
				return false;
		} else if (!streetline1.equals(other.streetline1))
			return false;
		if (streetline2 == null) {
			if (other.streetline2 != null)
				return false;
		} else if (!streetline2.equals(other.streetline2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", postalCode=" + postalCode + ", city=" + city + ", streetline1=" + streetline1
				+ ", streetline2=" + streetline2 + ", country=" + country + ", archived=" + archived + "]";
	
	}
	
}
