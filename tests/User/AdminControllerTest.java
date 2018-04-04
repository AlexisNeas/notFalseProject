package User;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import University.University;
import DatabaseController.DBController;

public class AdminControllerTest {
	
	private AdminController adminController;
	private DBController db;
	
	@Before
	public void setUp() throws Exception {
		adminController = new AdminController();
		db = new DBController("notfal","csci230");
	}

	@Test
	public void testGetListOfUsers() {
		ArrayList<Account> result = adminController.getListOfUsers();
		assertTrue("Should be an ArrayList of Accounts", result instanceof ArrayList);
	}

	@Test
	public void testViewUniversities() {
		ArrayList<String> result = adminController.viewUniversities();
		assertTrue("Should be an ArrayList of Strings", result instanceof ArrayList);
	}

	@Test
	public void testGetSchoolInformation() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddNewUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSchoolInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeactivateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserInfo() {
		fail("Not yet implemented");
	}

}
