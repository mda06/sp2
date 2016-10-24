package com.school.project.testing;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.school.project.model.Address;
import com.school.project.model.User;
import com.school.project.model.User.Gender;
import com.school.project.model.User.UserType;
import com.school.project.model.UserCredential;

public class TestUser{

	int check = 1; //1 = true, 0 = false
	
	@Test
	public void testConstructor() {
		int id = 1;
		Gender gender = Gender.MALE;
		UserType type = UserType.CUSTOMER;
		String firstName = "Willem-Jan";
		String lastName = "Pattyn";
		java.sql.Date dateOfBirth = new Date(863395200);
		boolean archived = false;
		
		User u1 = new User(id, gender, type, firstName, lastName, dateOfBirth, archived);
		
		if(check == 1){
			assertEquals(id, u1.getId());
			assertEquals(gender, u1.getGender());
			assertEquals(type, u1.getType());
			assertEquals(firstName, u1.getFirstName());
			assertEquals(lastName, u1.getLastName());
			assertEquals(dateOfBirth, u1.getDateOfBirth());
			assertEquals(archived, u1.isArchived());
		}
		else if(check == 0){
			u1.setId(1);
			u1.setGender(Gender.MALE);
			u1.setType(UserType.ADMIN);
			u1.setFirstName("Marc");
			u1.setLastName("De Hertogh");
			u1.setDateOfBirth(new Date(-228528000));
			u1.setArchived(true);
			
			assertEquals(id, u1.getId());
			assertEquals(gender, u1.getGender());
			assertEquals(type, u1.getType());
			assertEquals(firstName, u1.getFirstName());
			assertEquals(lastName, u1.getLastName());
			assertEquals(dateOfBirth, u1.getDateOfBirth());
			assertEquals(archived, u1.isArchived());
		}
	}
	
	@Test
	public void testEquals(){
		int id = 1;
		Gender gender = Gender.MALE;
		UserType type = UserType.CUSTOMER;
		String firstName = "Willem-Jan";
		String lastName = "Pattyn";
		java.sql.Date dateOfBirth = new Date(863395200);
		boolean archived = false;
		
		User u1 = new User(id, gender, type, firstName, lastName, dateOfBirth, archived);
		
		if(check == 1){
			User u2 = new User(1, Gender.MALE, UserType.CUSTOMER, "Willem-Jan", "Pattyn", dateOfBirth, archived);
			assertEquals(true, u1.equals(u2));
		}
		else if(check == 0){
			User u2 = new User(1, Gender.MALE, UserType.ADMIN, "Marc", "De Hertogh", new Date(-228528000), true);
			assertEquals(true, u1.equals(u2));
		}
	}
	
	@Test
	public void testHashCode(){
		int id = 1;
		Gender gender = Gender.MALE;
		UserType type = UserType.CUSTOMER;
		String firstName = "Willem-Jan";
		String lastName = "Pattyn";
		java.sql.Date dateOfBirth = new Date(863395200);
		boolean archived = false;
		
		User u1 = new User(id, gender, type, firstName, lastName, dateOfBirth, archived);
		
		if(check == 1){
			User u2 = new User(1, Gender.MALE, UserType.CUSTOMER, "Willem-Jan", "Pattyn", dateOfBirth, archived);
			assertEquals(u1.hashCode(), u2.hashCode());
		}
		else if(check == 0){
			User u2 = new User(1, Gender.MALE, UserType.CUSTOMER, "Marc", "De Hertogh", dateOfBirth = new Date(-228528000), true);
			assertEquals(u1.hashCode(), u2.hashCode());
		}
	}
	
	@Test
	public void testCredentials(){
		int id = 1;
		Gender gender = Gender.MALE;
		UserType type = UserType.CUSTOMER;
		String firstName = "Willem-Jan";
		String lastName = "Pattyn";
		java.sql.Date dateOfBirth = new Date(863395200);
		boolean archived = false;
		
		User u1 = new User(id, gender, type, firstName, lastName, dateOfBirth, archived);
		
		if(check == 1){
			assertEquals(null, u1.getCredentials());
		}
		else if(check == 0){
			u1.setCredentials(new UserCredential(1, "wjpattyn", "blabla", false));
			assertEquals(null, u1.getCredentials());
		}
	}
	
	@Test
	public void testAddress(){
		int id = 1;
		Gender gender = Gender.MALE;
		UserType type = UserType.CUSTOMER;
		String firstName = "Willem-Jan";
		String lastName = "Pattyn";
		java.sql.Date dateOfBirth = new Date(863395200);
		boolean archived = false;
		
		User u1 = new User(id, gender, type, firstName, lastName, dateOfBirth, archived);
		
		Address a1 = new Address(1, "Zonnekouter 18", " ", "Dilbeek", 1700, "Belgium", false);
		u1.setAddress(a1);
		
		if(check == 1){
			Address a2 = new Address(1, "Zonnekouter 18", " ", "Dilbeek", 1700, "Belgium", false);
			assertEquals(u1.getAddress(), a2);
		}
		else if(check == 0){
			Address a2 = new Address(1, "Leopoldlaan 165", " ", "Zaventem", 1930, "Belgium", false);
			assertEquals(u1.getAddress(), a2);
		}
	}
}
