package com.school.project.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.school.project.model.UserCredential;

public class TestUserCredentials {

	int check = 1; //1 = true, 0 = false
	
	@Test
	public void testConstructor() {
		int id = 1;
		String username = "pattynw";
		String password = "oraoraora";
		boolean archived = false;
		
		UserCredential uc1 = new UserCredential(id, username, password, archived);
		
		if(check == 1){
			assertEquals(id, uc1.getId());
			assertEquals(username, uc1.getUsername());
			assertEquals(password, uc1.getPassword());
			assertEquals(archived, uc1.isArchived());			
		}
		else if(check == 0){
			uc1.setId(1);
			uc1.setUsername("pattynw");
			uc1.setPassword("mudamudamuda");
			uc1.setArchived(false);
			
			assertEquals(id, uc1.getId());
			assertEquals(username, uc1.getUsername());
			assertEquals(password, uc1.getPassword());
			assertEquals(archived, uc1.isArchived());	
		}
	}
	
	@Test
	public void testEquals(){
		int id = 1;
		String username = "pattynw";
		String password = "oraoraora";
		boolean archived = false;
		
		UserCredential uc1 = new UserCredential(id, username, password, archived);
		
		if(check == 1){
			UserCredential uc2 = new UserCredential(1, "pattynw", "oraoraora", false);	
			assertEquals(true, uc1.equals(uc2));
		}
		else if(check == 0){
			UserCredential uc2 = new UserCredential(1, "mda06", "blabla", false);
			assertEquals(true, uc1.equals(uc2));
		}
	}
	
	@Test
	public void testHashCode(){
		int id = 1;
		String username = "pattynw";
		String password = "oraoraora";
		boolean archived = false;
		
		UserCredential uc1 = new UserCredential(id, username, password, archived);
		
		if(check == 1){
			UserCredential uc2 = new UserCredential(1, "pattynw", "oraoraora", false);
			assertEquals(uc1.hashCode(), uc2.hashCode());
		}
		else if(check == 0){
			UserCredential uc2 = new UserCredential(1, "mda06", "blabla", false);	
			assertEquals(uc1.hashCode(), uc2.hashCode());
		}
	}
}
