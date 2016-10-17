package com.school.project.model;

public class UserCredential {
	private int id;
	private String username, password;
	private boolean archived;
	
	public UserCredential(int id, String username, String password, boolean archived) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.archived = archived;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (archived ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		UserCredential other = (UserCredential) obj;
		if (archived != other.archived) return false;
		if (id != other.id) return false;
		if (password == null) {
			if (other.password != null) return false;
		} else if (!password.equals(other.password)) return false;
		if (username == null) {
			if (other.username != null) return false;
		} else if (!username.equals(other.username)) return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserCredential [id=" + id + ", username=" + username + ", password=" + password + ", archived=" + archived + "]";
	}
	
}
