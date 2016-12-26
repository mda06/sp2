package com.school.project.testing.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.school.project.dao.UserDAO;
import com.school.project.model.Address;
import com.school.project.model.User;
import com.school.project.model.User.Gender;
import com.school.project.model.User.UserType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUserDAO {
	
	@Test
	public void testGetUserIsNull() {
		List<User> users = UserDAO.getInstance().getAll();
		for(int i = 0; i < users.size(); i++){
			User result = UserDAO.getInstance().get(i);
			assertEquals(null, result);
		}
	}
	@Test
	public void testAddUser(){
		User dummyUser = new User(1, Gender.MALE, UserType.CUSTOMER, "test_Pete", "Richardson", new Date(863395200), false);
		Address dummyAddress = new Address(1, null, null, null, null, null, false);
		dummyUser.setAddress(dummyAddress);
		UserDAO.getInstance().add(dummyUser);
		List<User> users = UserDAO.getInstance().getAll();
		User result = users.get(users.size() - 1);
		System.out.println("Added " + result);
	}
	@Test
	public void testDeleteUser(){
		User dummyUser = new User(1, Gender.FEMALE, UserType.EMPLOYEE, "test_Susan", "Cannon", new Date(863395200), false);
		Address dummyAddress = new Address(1, null, null, null, null, null, false);
		dummyUser.setAddress(dummyAddress);
		UserDAO.getInstance().add(dummyUser);
		List<User> users = UserDAO.getInstance().getAll();
		User result = users.get(users.size() - 1);
		System.out.println("Deleted " + result);
		UserDAO.getInstance().delete(dummyUser);
	}
	@Test
	public void testUpdateUser(){
		List<User> users = UserDAO.getInstance().getAll();
		User lastUser = users.get(users.size() - 1);
		User uDummyUser = new User(lastUser.getId(), Gender.FEMALE, UserType.CUSTOMER, "test_Susan", "Cannon", new Date(863395200), false);
		Address dummyAddress = new Address(1, null, null, null, null, null, false);
		uDummyUser.setAddress(dummyAddress);
		UserDAO.getInstance().update(uDummyUser);
		System.out.println("Updated User with ID: " + lastUser.getId());
	}

}
