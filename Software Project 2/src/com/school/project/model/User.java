package com.school.project.model;

import java.sql.Date;

public class User {
	public enum Gender {
		MALE, FEMALE;
	}
	
	public enum UserType {
		CUSTOMER, EMPLOYEE, ADMIN;
	}
	
	private int id;
	private Gender gender;
	private UserType type;
	private UserCredential credentials;
	private String firstName, lastName;
	private java.sql.Date dateOfBirth;
	private boolean archived;
	
	public User(int id, Gender gender, UserType type, String firstName, String lastName, Date dateOfBirth, boolean archived) {
		this.id = id;
		this.gender = gender;
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.archived = archived;
		credentials = null;
	}
	
	public boolean hasCredentials() {
		return credentials != null;
	}

	public int getId() {
		return id;
	}

	public Gender getGender() {
		return gender;
	}

	public UserType getType() {
		return type;
	}

	public UserCredential getCredentials() {
		return credentials;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public java.sql.Date getDateOfBirth() {
		return dateOfBirth;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public void setCredentials(UserCredential credentials) {
		this.credentials = credentials;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(java.sql.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (archived ? 1231 : 1237);
		result = prime * result + ((credentials == null) ? 0 : credentials.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		User other = (User) obj;
		if (archived != other.archived) return false;
		if (credentials == null) {
			if (other.credentials != null) return false;
		} else if (!credentials.equals(other.credentials)) return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null) return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth)) return false;
		if (firstName == null) {
			if (other.firstName != null) return false;
		} else if (!firstName.equals(other.firstName)) return false;
		if (gender != other.gender) return false;
		if (id != other.id) return false;
		if (lastName == null) {
			if (other.lastName != null) return false;
		} else if (!lastName.equals(other.lastName)) return false;
		if (type != other.type) return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", gender=" + gender + ", type=" + type + ", credentials=" + credentials + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", archived=" + archived + "]";
	}
	
}
