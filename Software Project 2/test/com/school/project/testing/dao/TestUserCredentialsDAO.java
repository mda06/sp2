package com.school.project.testing.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.school.project.dao.UserCredentialsDAO;
import com.school.project.model.User;
import com.school.project.model.UserCredential;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUserCredentialsDAO {

	@Test
	public void testGetCredentialsIsNull() {
		List<UserCredential> credentials = UserCredentialsDAO.getInstance().getAll();
		for(int i = 0; i < credentials.size(); i++){
			UserCredential result = UserCredentialsDAO.getInstance().get(i);
			assertEquals(null, result);
		}
	}
	@Test
	public void testAddCredentials(){
		UserCredential dummyCredential = new UserCredential(1, "test_cred", "cred", false);
		User dummyUser = new User(62, null, null, null, null, null, false);
		dummyCredential.setUserId(dummyUser.getId());
		UserCredentialsDAO.getInstance().add(dummyCredential);
		List<UserCredential> credentials = UserCredentialsDAO.getInstance().getAll();
		UserCredential result = credentials.get(credentials.size() - 1);
		System.out.println("Added " + result);
	}
	@Test
	public void testDeleteCredentials(){
		UserCredential dummyCredential = new UserCredential(1, "test_cred2", "cred2", false);
		User dummyUser = new User(60, null, null, null, null, null, false);
		dummyCredential.setUserId(dummyUser.getId());
		UserCredentialsDAO.getInstance().add(dummyCredential);
		List<UserCredential> credentials = UserCredentialsDAO.getInstance().getAll();
		UserCredential result = credentials.get(credentials.size() - 1);
		UserCredentialsDAO.getInstance().delete(dummyCredential);
		System.out.println("Deleted " + result);
	}
	@Test
	public void testUpdateCredentials(){
		List<UserCredential> credentials = UserCredentialsDAO.getInstance().getAll();
		UserCredential lastCredential = credentials.get(credentials.size() - 1);
		UserCredential uDummyCredential = new UserCredential(lastCredential.getId(), "test_u_cred", "u_cred", false);
		User dummyUser = new User(62, null, null, null, null, null, false);
		uDummyCredential.setUserId(dummyUser.getId());
		UserCredentialsDAO.getInstance().update(uDummyCredential);
		System.out.println("Updated UserCredential with ID: " + lastCredential.getId());
	}
}
