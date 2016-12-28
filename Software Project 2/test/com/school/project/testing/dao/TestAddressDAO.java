package com.school.project.testing.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.school.project.dao.AddressDAO;
import com.school.project.model.Address;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAddressDAO {
	
	@Test
	public void testGetAddressIsNull() {
		List<Address> addresses = AddressDAO.getInstance().getAll();
		for(int i = 0; i < addresses.size(); i++){
			Address result = AddressDAO.getInstance().get(i);
			assertEquals(null, result);
		}
	}
	@Test
	public void testAddAddress(){
		Address dummyAddress = new Address(1, "test_Sand Fork Road", "", "Flora", "46929", "United States", false);
		AddressDAO.getInstance().add(dummyAddress);
		List<Address> addresses = AddressDAO.getInstance().getAll();
		Address result = addresses.get(addresses.size() - 1);
		System.out.println("Added " + result);
	}
	@Test
	public void testDeleteAddress(){
		Address dummyAddress = new Address(1, "test_Parkview Drive", "CA", "San Bernardino", "92401", "United States", false);
		AddressDAO.getInstance().add(dummyAddress);
		List<Address> addresses = AddressDAO.getInstance().getAll();
		Address result = addresses.get(addresses.size() - 1);
		AddressDAO.getInstance().delete(dummyAddress);
		System.out.println("Deleted " + result);
	}
	@Test
	public void testUpdateAddress(){
		List<Address> addresses = AddressDAO.getInstance().getAll();
		Address lastAddress = addresses.get(addresses.size() - 1);
		Address uDummyAddress = new Address(lastAddress.getId(), "test_152 Sand Fork Road","CA", "Flora", "46929", "United States", false);
		AddressDAO.getInstance().update(uDummyAddress);
		System.out.println("Updated Address with ID: " + lastAddress.getId());
		tearDown();
	}
	
	@AfterClass
	public static void tearDown(){
		AddressDAO.getInstance().deleteDummies();
	}
}
